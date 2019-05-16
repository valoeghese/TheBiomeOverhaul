package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import valoeghese.biomeoverhaul.util.BlockGenerator;
import valoeghese.biomeoverhaul.util.PublicWorldModifier;

public class PalmTreeFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();

	public PalmTreeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config)
	{
		super(config, false);
	}

	public boolean generate(Set<BlockPos> positions, ModifiableTestableWorld world, Random rand, BlockPos pos, MutableIntBoundingBox bb)
	{
		int height = rand.nextInt(3) + 6;
		pos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos);

		BlockGenerator generator = new BlockGenerator(world, positions, bb);

		if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256 && !isWater(world, pos) && (this.isSandOrClay(world, pos.down()) || super.isNaturalDirtOrGrass(world, pos.down())))
		{
			generator.setBlock(pos.down(), Blocks.DIRT.getDefaultState(), true);
			
			BlockPos origin = pos.add(0, height - 1, 0);
			
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
			
			for (int i = 0; i <= height - 1; ++i) generator.setBlock(pos.add(0, i, 0), LOG, false);
			
			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}
	
	private boolean isSandOrClay(TestableWorld world, BlockPos down)
	{
		return world.testBlockState(down, (state) -> {
			Block block = state.getBlock();
			return block == Blocks.RED_SAND || block == Blocks.SAND || block == Blocks.CLAY;
		});
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state, MutableIntBoundingBox bb)
	{
		super.setBlockState(set, world, pos, state, bb);
	}
}
