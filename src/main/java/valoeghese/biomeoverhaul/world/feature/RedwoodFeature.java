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

public class RedwoodFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.DARK_OAK_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();

	public RedwoodFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1)
	{
		super(function_1, false);
	}

	public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random random_1, BlockPos blockPos_1)
	{
		int height = 25 + random_1.nextInt(45);

		blockPos_1 = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);

		BlockGenerator generator = new BlockGenerator(world, set_1);

		if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, blockPos_1.down()))
		{

			//Last 5 layers leaves
			for (int i = height - 6; i <= height; ++i)
			{
				int j = i == height - 5 ? height - 3 : i + 1;
				if (i == height - 6) j = height - 2;

				int k = height - j;

				for (int x = -k; x < k + 1; ++x)
					for (int z = -k; z < k + 1; ++z)
					{
						if (Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2)) < k)
							generator.setBlock(blockPos_1.add(x, i, z), LEAVES, true);
					}
			}

			//More leaves lol
			for (int i = height / 2 - 5; i < height - 5; ++i)
			{
				int j = height < 2 * height / 3 ? 3 : 3 + random_1.nextInt(2);
				int j1 = height < 2 * height / 3 + 2 ? 3 : 4;

				int k = j + ((height - i) % j1);

				if (k < 4) k = 4;

				for (int x = -k; x < k + 1; ++x)
					for (int z = -k; z < k + 1; ++z)
					{
						if (Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2)) < k - 1)
							generator.setBlock(blockPos_1.add(x, i, z), LEAVES, true);
					}
			}

			//Trunk up to height - 3
			for (int i = -2; i < height - 3; ++i)
			{
				for (int x = -1; x < 2; ++x)
					for (int z = -1; z < 2; ++z)
						generator.setBlock(blockPos_1.add(x, i, z), LOG, i < 1 ? true : false);
			}

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
