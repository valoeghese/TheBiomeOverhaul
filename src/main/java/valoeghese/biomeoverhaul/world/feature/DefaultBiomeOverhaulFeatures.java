package valoeghese.biomeoverhaul.world.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class DefaultBiomeOverhaulFeatures
{
	public static final Feature<DefaultFeatureConfig> EMPTY_FEATURE;
	public static final Feature<DefaultFeatureConfig> LARGE_SHRUB;
	public static final Feature<DefaultFeatureConfig> LARGE_SWAMP_TREE;
	public static final Feature<DefaultFeatureConfig> PALM;
	public static final Feature<DefaultFeatureConfig> SHRUB;
	

	static
	{
		EMPTY_FEATURE = register("tbo:empty", new EmptyFeature(DefaultFeatureConfig::deserialize));
		LARGE_SWAMP_TREE = register("tbo:large_swamp_tree", new LargeSwampTreeFeature(DefaultFeatureConfig::deserialize));
		LARGE_SHRUB = register("tbo:large_shrub", new ShrubFeature(DefaultFeatureConfig::deserialize));
		PALM = register("tbo:palm", new PalmTreeFeature(DefaultFeatureConfig::deserialize));
		SHRUB = register("tbo:chapparal_shrub", new BushFeature(DefaultFeatureConfig::deserialize));
	}

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String string_1, F feature_1)
	{
		return (F)Registry.register(Registry.FEATURE, (String)string_1, feature_1);
	}
}
