package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import valoeghese.biomeoverhaul.util.BlockGenerator;
import valoeghese.biomeoverhaul.util.PublicWorldModifier;

public class PalmFeature extends TBOTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();

	public PalmFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1)
	{
		super(function_1, false);
	}

	public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random random_1, BlockPos blockPos_1, BlockBox mibb)
	{
		int height = random_1.nextInt(3) + 6;
		blockPos_1 = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);

		BlockGenerator generator = new BlockGenerator(world, set_1, mibb);

		if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256 && !isWater(world, blockPos_1) && (this.isSandOrClay(world, blockPos_1.down()) || super.isNaturalDirtOrGrass(world, blockPos_1.down())))
		{
			generator.setBlock(blockPos_1.down(), Blocks.DIRT.getDefaultState(), true);

			BlockPos origin = blockPos_1.add(0, height - 1, 0);

			for (int i = -1; i < 2; ++i)
			{
				generator.setBlock(origin.add(1, i, 0), LEAVES, true);
				generator.setBlock(origin.add(-1, i, 0), LEAVES, true);
				generator.setBlock(origin.add(0, i, 1), LEAVES, true);
				generator.setBlock(origin.add(0, i, -1), LEAVES, true);
			}

			generator.setBlock(origin.add(1, 0, 1), LEAVES, true);
			generator.setBlock(origin.add(-1, 0, 1), LEAVES, true);
			generator.setBlock(origin.add(1, 0, -1), LEAVES, true);
			generator.setBlock(origin.add(-1, 0, -1), LEAVES, true);

			for (int i = -2; i < 2; ++i)
			{
				if (i == 0) continue;
				generator.setBlock(origin.add(2, i, 0), LEAVES, true);
				generator.setBlock(origin.add(-2, i, 0), LEAVES, true);
				generator.setBlock(origin.add(0, i, 2), LEAVES, true);
				generator.setBlock(origin.add(0, i, -2), LEAVES, true);
			}

			generator.setBlock(origin.add(0, 1, 0), LEAVES, true);

			for (int i = 0; i <= height - 1; ++i) generator.setBlock(blockPos_1.add(0, i, 0), LOG, false);

			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}

	private boolean isSandOrClay(TestableWorld world, BlockPos down)
	{
		return world.testBlockState(down, (blockState_1) -> {
			Block block_1 = blockState_1.getBlock();
			return block_1 == Blocks.RED_SAND || block_1 == Blocks.SAND || block_1 == Blocks.CLAY;
		});
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state, BlockBox mibb)
	{
		super.setBlockState(set, world, pos, state, mibb);
	}
}
