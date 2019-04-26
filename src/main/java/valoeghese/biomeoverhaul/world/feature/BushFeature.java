package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import valoeghese.biomeoverhaul.util.BlockGenerator;
import valoeghese.biomeoverhaul.util.PublicWorldModifier;

public class BushFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();

	public BushFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1)
	{
		super(function_1, false);
	}

	public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random random_1, BlockPos blockPos_1)
	{
		int height = 3;
		blockPos_1 = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);

		BlockGenerator generator = new BlockGenerator(world, set_1);

		if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, blockPos_1.down()))
		{
			generator.setBlock(blockPos_1.down(), Blocks.DIRT.getDefaultState(), true);
			
			generator.setBlock(blockPos_1.add(0, 0, 0), LOG, false);
			
			generator.setBlock(blockPos_1.add(1, 0, 0), LEAVES, true);
			generator.setBlock(blockPos_1.add(-1, 0, 0), LEAVES, true);
			generator.setBlock(blockPos_1.add(0, 0, 1), LEAVES, true);
			generator.setBlock(blockPos_1.add(0, 0, -1), LEAVES, true);

			generator.setBlock(blockPos_1.add(0, 1, 0), LEAVES, true);

			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state)
	{
		super.setBlockState(set, world, pos, state);
	}
}
