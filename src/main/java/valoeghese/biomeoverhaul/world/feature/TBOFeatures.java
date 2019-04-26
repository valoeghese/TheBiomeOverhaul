package valoeghese.biomeoverhaul.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class TBOFeatures
{
	public static final Feature<DefaultFeatureConfig> BOREAL_FEATURE;
	public static final Feature<DefaultFeatureConfig> DEAD_TREE_FEATURE;
	public static final Feature<DefaultFeatureConfig> EMPTY_FEATURE;
	public static final Feature<DefaultFeatureConfig> LARGE_BOREAL_FEATURE;
	public static final Feature<DefaultFeatureConfig> LARGE_SHRUB;
	public static final Feature<DefaultFeatureConfig> LARGE_SPRUCE_SHRUB;
	public static final Feature<DefaultFeatureConfig> LARGE_SWAMP_TREE;
	public static final Feature<DefaultFeatureConfig> PALM;
	public static final Feature<DefaultFeatureConfig> REDWOOD;
	public static final Feature<DefaultFeatureConfig> SHRUB;
	public static final Feature<DefaultFeatureConfig> SMALL_REDWOOD;

	static
	{
		BOREAL_FEATURE = register("tbo:boreal_tree", new BorealFeature(DefaultFeatureConfig::deserialize));
		DEAD_TREE_FEATURE = register("tbo:dead_tree", new DeadTreeFeature(DefaultFeatureConfig::deserialize));
		EMPTY_FEATURE = register("tbo:empty", new EmptyFeature(DefaultFeatureConfig::deserialize));
		LARGE_BOREAL_FEATURE = register("tbo:temperate_rainforest_feature", new TemperateRainforestFeature(DefaultFeatureConfig::deserialize));
		LARGE_SWAMP_TREE = register("tbo:large_swamp_tree", new LargeSwampTreeFeature(DefaultFeatureConfig::deserialize));
		LARGE_SHRUB = register("tbo:large_shrub", new LargeShrubFeature(Blocks.OAK_LEAVES.getDefaultState(), DefaultFeatureConfig::deserialize));
		LARGE_SPRUCE_SHRUB = register("tbo:large_spruce_shrub", new LargeShrubFeature(Blocks.SPRUCE_LEAVES.getDefaultState(), DefaultFeatureConfig::deserialize));
		REDWOOD = register("tbo:redwood", new RedwoodFeature(DefaultFeatureConfig::deserialize));
		PALM = register("tbo:palm", new PalmTreeFeature(DefaultFeatureConfig::deserialize));
		SHRUB = register("tbo:chapparal_shrub", new BushFeature(DefaultFeatureConfig::deserialize));
		SMALL_REDWOOD = register("tbo:small_redwood", new SmallRedwoodFeature(DefaultFeatureConfig::deserialize));
	}

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String string_1, F feature_1)
	{
		return (F)Registry.register(Registry.FEATURE, (String)string_1, feature_1);
	}
}
