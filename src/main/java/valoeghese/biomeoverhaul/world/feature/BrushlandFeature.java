package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import valoeghese.biomeoverhaul.util.BlockGenerator;
import valoeghese.biomeoverhaul.util.PublicWorldModifier;

public class BrushlandFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.DARK_OAK_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();

	public BrushlandFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1)
	{
		super(function_1, false);
	}

	public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random random_1, BlockPos blockPos_1,  MutableIntBoundingBox mibb)
	{
		int height = random_1.nextInt(4) + 4;
		blockPos_1 = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);

		BlockGenerator generator = new BlockGenerator(world, set_1, mibb);

		if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, blockPos_1.down()))
		{
			generator.setBlock(blockPos_1.down(), Blocks.DIRT.getDefaultState(), true);

			for (int i = 0; i <= height; ++i) 
			{
				generator.setBlock(blockPos_1.add(0, i, 0), i == height ? LEAVES : LOG, false);
				if (random_1.nextInt(4) > 0 && i >= height / 3 && i != height)
				{
					int k = random_1.nextInt(3) + 1;
					
					for (int i1 = 0; i1 < k; ++i1)
					{
						int n1 = (random_1.nextInt(3) - 1);
						boolean b = random_1.nextBoolean();
						
						if (n1 != 0)
						{
							if (b) generator.setBlock(blockPos_1.add(n1, i, 0), LEAVES, false);
							else generator.setBlock(blockPos_1.add(0, i, n1), LEAVES, false);
						}
					}
				}
			}

			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state,  MutableIntBoundingBox mibb)
	{
		super.setBlockState(set, world, pos, state, mibb);
	}
}
