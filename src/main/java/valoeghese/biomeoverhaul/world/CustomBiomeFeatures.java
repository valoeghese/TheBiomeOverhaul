package valoeghese.biomeoverhaul.world;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.LakeDecoratorConfig;
import net.minecraft.world.gen.decorator.NoiseHeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.BushFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;
import valoeghese.biomeoverhaul.world.biome.TBOBiome;
import valoeghese.biomeoverhaul.world.feature.TBOFeatures;

public class CustomBiomeFeatures
{

	public static void addGrasslandFeatures(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.FLOWER, DefaultBiomeFeatures.PLAINS_FLOWER_CONFIG, Decorator.NOISE_HEIGHTMAP_32, new NoiseHeightmapDecoratorConfig(-0.8D, 10, 4)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.GRASS_CONFIG, Decorator.NOISE_HEIGHTMAP_DOUBLE, new NoiseHeightmapDecoratorConfig(-0.8D, 5, 10)));
	}

	public static void addBayouFeatures(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(new RandomFeatureEntry<>(TBOFeatures.LARGE_SWAMP_TREE.configure(FeatureConfig.DEFAULT), 0.2f)), Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.SWAMP_TREE_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(8, 0.1F, 1)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.BLUE_ORCHID_CONFIG, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(1)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.GRASS_CONFIG, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(3)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.LILY_PAD_CONFIG, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(4)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG, Decorator.COUNT_CHANCE_HEIGHTMAP, new CountChanceDecoratorConfig(10, 0.35F)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.RED_MUSHROOM_CONFIG, Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new CountChanceDecoratorConfig(10, 0.175F)));
	}

	public static void addExtraBayouFeatures(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.LARGE_SWAMP_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.BLUE_ORCHID_CONFIG, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(1)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.GRASS_CONFIG, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(3)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.LILY_PAD_CONFIG, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(15)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG, Decorator.COUNT_CHANCE_HEIGHTMAP, new CountChanceDecoratorConfig(13, 0.35F)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.RED_MUSHROOM_CONFIG, Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new CountChanceDecoratorConfig(13, 0.175F)));
	}

	public static void addIncreasedMushrooms(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG, Decorator.CHANCE_HEIGHTMAP_DOUBLE, new LakeDecoratorConfig(7)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.RED_MUSHROOM_CONFIG, Decorator.CHANCE_HEIGHTMAP_DOUBLE, new LakeDecoratorConfig(14)));
	}

	public static void addIncreasedWaterLakes(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, TBOBiome.configure(Feature.LAKE, new BushFeatureConfig(Blocks.WATER.getDefaultState()), Decorator.WATER_LAKE, new LakeDecoratorConfig(2)));
	}

	public static void addBrushlandTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.ACACIA_TREE.configure(DefaultBiomeFeatures.ACACIA_TREE_CONFIG), 0.08f),
				new RandomFeatureEntry<>(TBOFeatures.BRUSHLAND_FEATURE.configure(FeatureConfig.DEFAULT), 0.18f),
				new RandomFeatureEntry<>(Feature.DARK_OAK_TREE.configure(DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG), 0.08f)
				), TBOFeatures.BRUSHLAND_SCRUB.configure(FeatureConfig.DEFAULT)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(9, 0.1F, 1)));
	}

	public static void addChapparalShrubs(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.SCRUB, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(6, 0.1F, 1)));
	}

	public static void addShieldTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.FANCY_TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG), 0.05f)
				), Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
	}

	public static void addGroveTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.FANCY_TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG), 0.5f)
				), Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(2, 0.1F, 1)));
	}

	public static void addRainforestVegetation(Biome biome_1) {
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.MELON_PATCH_CONFIG, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(2)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.VINES, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHT_64, new CountDecoratorConfig(20)));
	}

	public static void addRainforestTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.FANCY_TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_BEEHIVES_CONFIG), 0.02f),
				new RandomFeatureEntry<>(TBOFeatures.EMPTY_FEATURE.configure(FeatureConfig.DEFAULT), 0.3f),
				new RandomFeatureEntry<>(Feature.MEGA_JUNGLE_TREE.configure(DefaultBiomeFeatures.MEGA_JUNGLE_TREE_CONFIG), 0.3f)
				), Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(20, 0.3F, 10)));
	}

	public static void addPalms(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.PALM, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.1F, 1)));
	}

	public static void addExtraPalms(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.PALM, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(2, 0.1F, 1)));
	}

	public static void addSubtropicalRainforestTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.FANCY_TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG), 0.15f),
				new RandomFeatureEntry<>(Feature.MEGA_SPRUCE_TREE.configure(DefaultBiomeFeatures.MEGA_PINE_TREE_CONFIG), 0.2f),
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 0.35f)
				), Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.3F, 10)));
	}

	public static void addShrublandShrubs(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.LARGE_SHRUB, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(3, 0.1F, 1)));
	}

	public static void addSteppeTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.NORMAL_TREE, DefaultBiomeFeatures.SPRUCE_TREE_CONFIG, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(0, 0.05F, 1)));
	}

	public static void addTemperateRainforestTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(TBOFeatures.FIR_TEMPERATE_RAINFOREST_FEATURE.configure(FeatureConfig.DEFAULT), 0.03f),
				new RandomFeatureEntry<>(TBOFeatures.FIR_TREE_FEATURE.configure(FeatureConfig.DEFAULT), 0.3f),
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 0.2f),
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 0.25f),
				new RandomFeatureEntry<>(TBOFeatures.LARGE_SHRUB.configure(FeatureConfig.DEFAULT), 0.15f)), Feature.FANCY_TREE.configure(DefaultBiomeFeatures.FANCY_TREE_WITH_BEEHIVES_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(6, 0.3F, 6)));
	}

	public static void addMarshShrubs(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.LARGE_SHRUB, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(1, 0.7F, 2)));
	}

	public static void addFenTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 0.2f),
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 0.1f)
				), TBOFeatures.DEAD_TREE_FEATURE.configure(FeatureConfig.DEFAULT)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(0, 0.35F, 1)));
	}

	public static void addExtraFenTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.PINE_TREE_CONFIG), 0.25f),
				new RandomFeatureEntry<>(Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG), 0.15f)
				), TBOFeatures.DEAD_TREE_FEATURE.configure(FeatureConfig.DEFAULT)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(3, 0.1F, 1)));
	}

	public static void addMireTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(TBOFeatures.DEAD_TREE_FEATURE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(4, 0.3F, 2)));
	}

	public static void addBorealTrees(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(ImmutableList.of(
				new RandomFeatureEntry<>(TBOFeatures.FIR_TREE_FEATURE.configure(FeatureConfig.DEFAULT), 0.32f),
				new RandomFeatureEntry<>(TBOFeatures.LARGE_SPRUCE_SHRUB.configure(FeatureConfig.DEFAULT), 0.1f)
				), Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG)), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(4, 0.1F, 1)));
	}

	public static void addWaterlillies(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DefaultBiomeFeatures.LILY_PAD_CONFIG, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(4)));
	}

	public static void addFlowerFieldFlowers(Biome biome_1)
	{
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, POPPY, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(6)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, DANDELION, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(6)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, AZURE_BLUET, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(3)));
		biome_1.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBOBiome.configure(Feature.RANDOM_PATCH, CORNFLOWER, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(2)));
	}

	public static RandomPatchFeatureConfig createForFlower(BlockState state) {
		return new RandomPatchFeatureConfig.Builder(new SimpleStateProvider(state), new SimpleBlockPlacer()).tries(64).build();
	}

	public static final RandomPatchFeatureConfig POPPY = createForFlower(Blocks.POPPY.getDefaultState());
	public static final RandomPatchFeatureConfig DANDELION = createForFlower(Blocks.DANDELION.getDefaultState());
	public static final RandomPatchFeatureConfig AZURE_BLUET = createForFlower(Blocks.AZURE_BLUET.getDefaultState());
	public static final RandomPatchFeatureConfig CORNFLOWER = createForFlower(Blocks.CORNFLOWER.getDefaultState());
}
