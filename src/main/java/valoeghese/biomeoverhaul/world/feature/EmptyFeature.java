package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class EmptyFeature extends AbstractTreeFeature<DefaultFeatureConfig>
{
	public EmptyFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> confug)
	{
		super(confug, false);
	}

	public boolean generate(Set<BlockPos> positions, ModifiableTestableWorld world, Random rand, BlockPos pos, MutableIntBoundingBox bb)
	{
		int height = 3;
		pos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos);

		if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, pos.down()))
		{
			return canTreeReplace(world, pos);
		}
		else
		{
			return false;
		}
	}
}
