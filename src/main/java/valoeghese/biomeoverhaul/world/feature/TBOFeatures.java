package valoeghese.biomeoverhaul.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class TBOFeatures
{
	public static final Feature<DefaultFeatureConfig> BRUSHLAND_SCRUB;
	public static final Feature<DefaultFeatureConfig> BRUSHLAND_FEATURE;
	public static final Feature<DefaultFeatureConfig> DEAD_TREE_FEATURE;
	public static final Feature<DefaultFeatureConfig> EMPTY_FEATURE;
	public static final Feature<DefaultFeatureConfig> FIR_TREE_FEATURE;
	public static final Feature<DefaultFeatureConfig> FIR_TEMPERATE_RAINFOREST_FEATURE;
	public static final Feature<DefaultFeatureConfig> LARGE_SHRUB;
	public static final Feature<DefaultFeatureConfig> LARGE_SPRUCE_SHRUB;
	public static final Feature<DefaultFeatureConfig> LARGE_SWAMP_TREE;
	public static final Feature<DefaultFeatureConfig> PALM;
	public static final Feature<DefaultFeatureConfig> REDWOOD;
	public static final Feature<DefaultFeatureConfig> SCRUB;
	public static final Feature<DefaultFeatureConfig> SMALL_REDWOOD;

	static
	{
		BRUSHLAND_SCRUB = register("tbo:brushland_shrub", new BrushlandScrubFeature(DefaultFeatureConfig::deserialize));
		BRUSHLAND_FEATURE = register("tbo:brushland_tall_tree", new BrushlandFeature(DefaultFeatureConfig::deserialize));
		DEAD_TREE_FEATURE = register("tbo:dead_tree", new DeadTreeFeature(DefaultFeatureConfig::deserialize));
		EMPTY_FEATURE = register("tbo:empty", new EmptyFeature(DefaultFeatureConfig::deserialize));
		FIR_TREE_FEATURE = register("tbo:boreal_tree", new FirTreeFeature(DefaultFeatureConfig::deserialize));
		FIR_TEMPERATE_RAINFOREST_FEATURE = register("tbo:temperate_rainforest_feature", new TemperateRainforestFirFeature(DefaultFeatureConfig::deserialize));
		LARGE_SWAMP_TREE = register("tbo:large_swamp_tree", new LargeSwampTreeFeature(DefaultFeatureConfig::deserialize));
		LARGE_SHRUB = register("tbo:large_shrub", new ShrubFeature(Blocks.OAK_LEAVES.getDefaultState(), DefaultFeatureConfig::deserialize));
		LARGE_SPRUCE_SHRUB = register("tbo:large_spruce_shrub", new ShrubFeature(Blocks.SPRUCE_LEAVES.getDefaultState(), DefaultFeatureConfig::deserialize));
		REDWOOD = register("tbo:redwood", new RedwoodFeature(DefaultFeatureConfig::deserialize));
		PALM = register("tbo:palm", new PalmFeature(DefaultFeatureConfig::deserialize));
		SCRUB = register("tbo:chapparal_shrub", new ScrubFeature(DefaultFeatureConfig::deserialize));
		SMALL_REDWOOD = register("tbo:small_redwood", new SmallRedwoodFeature(DefaultFeatureConfig::deserialize));
	}

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String string_1, F feature_1)
	{
		return (F)Registry.register(Registry.FEATURE, (String)string_1, feature_1);
	}
}
