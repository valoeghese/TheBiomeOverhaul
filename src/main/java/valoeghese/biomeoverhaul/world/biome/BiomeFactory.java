package valoeghese.biomeoverhaul.world.biome;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import valoeghese.biomeoverhaul.api.modifier.RiverType;

// modified from updated 1.15 version from WinterBiomeMod, ported and updated from ValarLib 1.14, originally from TBO 1.14
public class BiomeFactory {
	private String baseBiome = (String)null;
	private TBOBiome parent;

	private SurfaceBuilder<TernarySurfaceConfig> surfaceBuilder = SurfaceBuilder.DEFAULT;

	TBOBiome.TBOSurfaceConfig surfaceConfig = new TBOBiome.TBOSurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState());

	private float temperature = 0.5F;
	private float downfall = 0.5F;

	private int waterColour = 4159204;
	private int waterFogColour = 329011;

	private int customSkyColour = -1;

	boolean hasCustomGrassColour = false;
	boolean hasCustomFoliageColour = false;

	private int grassColour;
	private int foliageColour;

	private float spawnChance = 0.1F;

	private final float baseHeight;
	private final float scale;
	private final TBOBiome.Precipitation precipitation;
	private final TBOBiome.Category category;
	
	private RiverType riverType = RiverType.WATER;

	private BiomeFactory(float baseHeight, float scale, TBOBiome.Category category, TBOBiome.Precipitation precipitation) {
		this.baseHeight = baseHeight;
		this.scale = scale;
		this.precipitation = precipitation;
		this.category = category;
	}

	//==================================================//

	public static BiomeFactory create(float baseHeight, float scale, TBOBiome.Category category) {
		BiomeFactory factory = create(baseHeight, scale, Biome.Precipitation.RAIN, category);
		return factory;
	}

	public static BiomeFactory create(float baseHeight, float scale, TBOBiome.Precipitation precipitation, TBOBiome.Category category) {
		BiomeFactory factory = new BiomeFactory(baseHeight, scale, category, precipitation);
		return factory;
	}

	//==================================================//

	public BiomeFactory setSurfaceBuilder(SurfaceBuilder<TernarySurfaceConfig> builder) {
		this.surfaceBuilder = builder;
		return this;
	}

	public BiomeFactory setTemperatureDownfall(float temperature, float downfall) {
		this.temperature = temperature;
		this.downfall = downfall;
		return this;
	}

	public BiomeFactory setWaterProperties(int waterColour, int waterFogColour) {
		this.waterColour = waterColour;
		this.waterFogColour = waterFogColour;
		return this;
	}

	public BiomeFactory setDarkWaterProperties() {
		return this.setWaterProperties(0x524ed8, 0x518abc);
	}

	public BiomeFactory setGrassColour(int grassColour) {
		this.hasCustomGrassColour = true;
		this.grassColour = grassColour;
		return this;
	}

	public BiomeFactory setFoliageColour(int foliageColour) {
		this.hasCustomFoliageColour = true;
		this.foliageColour = foliageColour;
		return this;
	}

	public BiomeFactory setSpawnChance(float spawnChance) {
		this.spawnChance = spawnChance;
		return this;
	}

	public BiomeFactory setBaseBiome(String baseBiome) {
		this.baseBiome = baseBiome;
		return this;
	}
	
	public BiomeFactory setRiverType(RiverType riverType) {
		this.riverType = riverType;
		return this;
	}

	public BiomeFactory setCustomSkyColour(int colour) {
		this.customSkyColour = colour;
		return this;
	}

	//==================================================//

	public TBOBiome.Settings build() {
		return new TBOBiome.Settings().configureSurfaceBuilder(this.surfaceBuilder, this.surfaceConfig).precipitation(this.precipitation).category(this.category).depth(this.baseHeight).scale(this.scale).temperature(this.temperature).downfall(this.downfall).waterColor(this.waterColour).waterFogColor(this.waterFogColour).parent(this.baseBiome);
	}

	public int getGrassColour() {
		return this.grassColour;
	}

	public int getFoliageColour() {
		return this.foliageColour;
	}

	public float getSpawnChance() {
		return this.spawnChance;
	}
	
	public RiverType getRiverType() {
		return riverType;
	}

	public boolean hasCustomSkyColour() {
		return this.customSkyColour != -1;
	}

	public int getCustomSkyColour() {
		return this.customSkyColour;
	}

	//==================================================//

	public void setParent(TBOBiome parent) {
		this.parent = parent;
	}

	public TBOBiome getParent() {
		return this.parent;
	}

	public BiomePopulator createPopulator() {
		return new BiomePopulator(this.getParent());
	}

	public void addDefaultGeneration() {
		this.parent.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));
		this.parent.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
		DefaultBiomeFeatures.addLandCarvers(this.parent);
		DefaultBiomeFeatures.addDefaultStructures(this.parent);
		DefaultBiomeFeatures.addDungeons(this.parent);
		DefaultBiomeFeatures.addFrozenTopLayer(this.parent);
	}

	public void addDefaultMineables() {
		DefaultBiomeFeatures.addMineables(this.parent);
		DefaultBiomeFeatures.addDefaultOres(this.parent);
		DefaultBiomeFeatures.addDefaultDisks(this.parent);
	}

	public static class BiomePopulator {
		public final TBOBiome parent;

		public BiomePopulator(TBOBiome parent) {
			this.parent = parent;
		}

		public int treesPerChunk = 0;
		public float extraTreeChance = 0.1F;
		public int extraTreeCount = 1;

		private List<Pair<ConfiguredFeature<?, ?>, Float>> treeFeatures = new ArrayList<>();

		private float weightSum = 0;

		public <T extends FeatureConfig> BiomePopulator addTreeFeature(Feature<T> feature, T config, float weight) {
			weightSum += weight;
			this.treeFeatures.add(new Pair<>(feature.configure(config), weight));
			return this;
		}

		public void buildTreeFeatures() {
			float tpc = (float) this.treesPerChunk;
			for (Pair<ConfiguredFeature<?, ?>, Float> feature : treeFeatures)
			{
				int n1 = MathHelper.floor(tpc * (feature.getRight().floatValue() / this.weightSum));

				this.parent.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, feature.getLeft().createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(n1, this.extraTreeChance, this.extraTreeCount))));
			}
		}
	}
}