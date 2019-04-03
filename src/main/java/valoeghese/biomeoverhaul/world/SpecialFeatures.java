package valoeghese.biomeoverhaul.world;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class SpecialFeatures
{
	public static final Feature<DefaultFeatureConfig> LARGE_SWAMP_TREE;
	public static final Feature<DefaultFeatureConfig> SHRUB;

	static
	{
		LARGE_SWAMP_TREE = register("large_swamp_tree", new LargeSwampTreeFeature(DefaultFeatureConfig::deserialize));
		SHRUB = register("chapparal_shrub", new BushFeature(DefaultFeatureConfig::deserialize));
	}

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String string_1, F feature_1)
	{
		return (F)Registry.register(Registry.FEATURE, (String)string_1, feature_1);
	}
}
