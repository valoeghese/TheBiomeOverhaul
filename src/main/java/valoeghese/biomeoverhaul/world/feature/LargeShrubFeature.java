package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import com.mojang.datafixers.kinds.IdF;
import net.minecraft.block.Block;
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
import valoeghese.biomeoverhaul.util.PublicWorldModifierTester;

public class LargeShrubFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifierTester
{
	private static final int[][] coords = {{1,1},{1,-1},{-1,1},{-1,-1}};
	
	private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
	private final BlockState LEAVES;

	public LargeShrubFeature(BlockState leaves, Function<Dynamic<?>, ? extends DefaultFeatureConfig> config)
	{
		super(config, false);
		
		LEAVES = leaves;
	}

	public boolean generate(Set<BlockPos> positions, ModifiableTestableWorld world, Random rand, BlockPos pos, MutableIntBoundingBox bb)
	{
		int height = 3;
		pos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos);

		BlockGenerator generator = new BlockGenerator(world, positions, bb);

		if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, pos.down()))
		{
			generator.setBlock(pos.down(), Blocks.DIRT.getDefaultState(), true);
			
			for (int i = -2; i <= 2; ++i)
			{
				for (int j = -2; j <= 2; ++j)
				{
					generator.setBlock(pos.add(i, 0, j), LEAVES, true);
				}
			}
			generator.setBlock(pos.add(0, 1, 1), LEAVES, true);
			generator.setBlock(pos.add(0, 1, -1), LEAVES, true);
			generator.setBlock(pos.add(1, 1, 0), LEAVES, true);
			generator.setBlock(pos.add(0, 1, 0), LEAVES, true);
			generator.setBlock(pos.add(-1, 1, 0), LEAVES, true);
			
			//counters
			int c0 = 3;
			int c1 = 0;
			
			for (int n = 4; n > 0; --n)
			{
				if (c1 == 2) break;
				
				if (rand.nextInt(c0) == 0)
				{
					generator.setBlock(pos.add(coords[n - 1][0], 1, coords[n - 1][1]), LEAVES, true);
					++c1;
				}
				else if (c0 > 1) --c0;
			}
			
			generator.setBlock(pos, LOG, false);
			
			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableTestableWorld world, BlockPos pos, BlockState state, MutableIntBoundingBox bb)
	{
		if ((canTreeReplace(world, pos) || world.testBlockState(pos, (blockState_1) -> {
			Block block = blockState_1.getBlock();
			return block == Blocks.GRASS;
		})) && world.testBlockState(pos, (blockState_1) -> {
			Block block = blockState_1.getBlock();
			return block != Blocks.GRASS_BLOCK && block != Blocks.DIRT && block != Blocks.COARSE_DIRT;
		}))
				super.setBlockState(set, world, pos, state, bb);
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state, MutableIntBoundingBox bb)
	{
		super.setBlockState(set, world, pos, state, bb);
	}
}
