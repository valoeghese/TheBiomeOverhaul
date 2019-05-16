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

public class BushFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();

	public BushFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config)
	{
		super(config, false);
	}

	public boolean generate(Set<BlockPos> positions, ModifiableTestableWorld world, Random rand, BlockPos pos, MutableIntBoundingBox bb)
	{
		int height = 3;
		pos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos);

		BlockGenerator generator = new BlockGenerator(world, positions, bb);

		if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, pos.down()))
		{
			generator.setBlock(pos.down(), Blocks.DIRT.getDefaultState(), true);
			
			generator.setBlock(pos.add(0, 0, 0), LOG, false);
			
			generator.setBlock(pos.add(1, 0, 0), LEAVES, true);
			generator.setBlock(pos.add(-1, 0, 0), LEAVES, true);
			generator.setBlock(pos.add(0, 0, 1), LEAVES, true);
			generator.setBlock(pos.add(0, 0, -1), LEAVES, true);

			generator.setBlock(pos.add(0, 1, 0), LEAVES, true);

			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state, MutableIntBoundingBox bb)
	{
		super.setBlockState(set, world, pos, state, bb);
	}
}
