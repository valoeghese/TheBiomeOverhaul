package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.MegaTreeFeature;

public class BorealFeature extends MegaTreeFeature<DefaultFeatureConfig>
{
	private static final BlockState LOG, LEAVES;

	public BorealFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config)
	{
		super(config, false, 12, 4, LOG, LEAVES);
	}

	public boolean generate(Set<BlockPos> positions, ModifiableTestableWorld world, Random rand, BlockPos pos, MutableIntBoundingBox bb)
	{
		int height = this.getHeight(rand);
		if (!this.checkTreeFitsAndReplaceGround(world, pos, height))
		{
			return false;
		} else
		{
			this.makeTopLeaves(world, pos.getX(), pos.getZ(), pos.getY() + height, 0, rand, bb, positions);

			for(int i = 0; i < height; ++i)
			{
				if (isAirOrLeaves(world, pos.up(i)))
				{
					this.setBlockState(positions, world, pos.up(i), this.log, bb);
				}

				if (i < height - 1)
				{
					if (isAirOrLeaves(world, pos.add(1, i, 0)))
					{
						this.setBlockState(positions, world, pos.add(1, i, 0), this.log, bb);
					}

					if (isAirOrLeaves(world, pos.add(1, i, 1)))
					{
						this.setBlockState(positions, world, pos.add(1, i, 1), this.log, bb);
					}

					if (isAirOrLeaves(world, pos.add(0, i, 1)))
					{
						this.setBlockState(positions, world, pos.add(0, i, 1), this.log, bb);
					}
				}
			}

			this.replaceGround(world, rand, pos);
			return true;
		}
	}

	private void makeTopLeaves(ModifiableTestableWorld world, int x, int z, int y, int offset, Random rand, MutableIntBoundingBox bb, Set<BlockPos> positions)
	{
		int height = rand.nextInt(5) + (this.baseHeight);
		int lastLayer = 0;

		for(int i = y - height; i <= y; ++i)
		{
			int layerHeight = y - i;
			int offsetHeight = offset + MathHelper.floor((float)layerHeight / (float)height * 3.5F);
			this.makeSquaredLeafLayer(world, new BlockPos(x, i, z), offsetHeight + (layerHeight > 0 && offsetHeight == lastLayer && (i & 1) == 0 ? 1 : 0), bb, positions);
			lastLayer = offsetHeight;
		}

	}

	public void replaceGround(ModifiableTestableWorld world, Random rand, BlockPos pos)
	{
		this.replaceGroundNear(world, pos.west().north());
		this.replaceGroundNear(world, pos.east(2).north());
		this.replaceGroundNear(world, pos.west().south(2));
		this.replaceGroundNear(world, pos.east(2).south(2));

		for(int i = 0; i < 5; ++i)
		{
			int int_2 = rand.nextInt(64);
			int int_3 = int_2 % 8;
			int int_4 = int_2 / 8;
			if (int_3 == 0 || int_3 == 7 || int_4 == 0 || int_4 == 7)
			{
				this.replaceGroundNear(world, pos.add(-3 + int_3, 0, -3 + int_4));
			}
		}

	}

	private void replaceGroundNear(ModifiableTestableWorld world, BlockPos pos)
	{
		for(int int_1 = -2; int_1 <= 2; ++int_1)
		{
			for(int int_2 = -2; int_2 <= 2; ++int_2)
			{
				if (Math.abs(int_1) != 2 || Math.abs(int_2) != 2)
				{
					this.prepareGroundColumn(world, pos.add(int_1, 0, int_2));
				}
			}
		}

	}

	private void prepareGroundColumn(ModifiableTestableWorld world, BlockPos pos)
	{
		for(int int_1 = 2; int_1 >= -3; --int_1)
		{
			BlockPos blockPos_2 = pos.up(int_1);
			
			if (!isAir(world, blockPos_2) && int_1 < 0)
			{
				break;
			}
		}

	}

	static
	{
		LOG = Blocks.SPRUCE_LOG.getDefaultState();
		LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();
	}

}
