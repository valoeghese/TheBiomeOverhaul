package valoeghese.biomeoverhaul.world.biome;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import valoeghese.biomeoverhaul.util.math.Tuple;
import valoeghese.biomeoverhaul.world.biome.TBOBiome.TBOSurfaceConfig;

public class BiomeFactory
{
	private String baseBiome = (String)null;
	private TBOBiome parent;
	
	private SurfaceBuilder<TernarySurfaceConfig> surfaceBuilder = SurfaceBuilder.DEFAULT;

	public TBOSurfaceConfig surfaceConfig = new TBOSurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState());

	private float temperature = 0.5F;
	private float downfall = 0.5F;

	private int waterColour = 4159204;
	private int waterFogColour = 329011;
	
	private int customSkyColour = -1;
	
	private boolean hasCustomColours = false;
	private int grassColour;
	private int foliageColour;
	
	private float spawnChance = 0.1F;
	
	public final float baseHeight;
	public final float scale;
	public final Biome.Precipitation precipitation;
	public final Biome.Category category;
	
	private RiverType riverType = RiverType.WATER;
	
	private BiomeFactory(float baseHeight, float scale, Biome.Category category, Biome.Precipitation precipitation)
	{
		this.baseHeight = baseHeight;
		this.scale = scale;
		this.precipitation = precipitation;
		this.category = category;
	}

	//==================================================//

	public static BiomeFactory create(float baseHeight, float scale, Biome.Category category)
	{
		BiomeFactory factory = create(baseHeight, scale, Biome.Precipitation.RAIN, category);
		return factory;
	}
	
	public static BiomeFactory create(float baseHeight, float scale, Biome.Precipitation precipitation, Biome.Category category)
	{
		BiomeFactory factory = new BiomeFactory(baseHeight, scale, category, precipitation);
		return factory;
	}

	//==================================================//

	public BiomeFactory setSurfaceBuilder(SurfaceBuilder<TernarySurfaceConfig> builder)
	{
		this.surfaceBuilder = builder;
		return this;
	}

	public BiomeFactory setTemperatureDownfall(float temperature, float downfall)
	{
		this.temperature = temperature;
		this.downfall = downfall;
		return this;
	}

	public BiomeFactory setWaterProperties(int waterColour, int waterFogColour)
	{
		this.waterColour = waterColour;
		this.waterFogColour = waterFogColour;
		return this;
	}
	
	public BiomeFactory setDarkWaterProperties()
	{
		return this.setWaterProperties(0x524ed8, 0x518abc);
	}

	public BiomeFactory setColourProperties(int grassColour, int foliageColour)
	{
		this.hasCustomColours = true;
		this.foliageColour = foliageColour;
		this.grassColour = grassColour;
		return this;
	}
	
	public BiomeFactory setSpawnChance(float spawnChance)
	{
		this.spawnChance = spawnChance;
		return this;
	}
	
	public BiomeFactory setBaseBiome(String baseBiome)
	{
		this.baseBiome = baseBiome;
		return this;
	}
	
	public BiomeFactory setRiverType(RiverType riverType)
	{
		this.riverType = riverType;
		return this;
	}
	
	public BiomeFactory setCustomSkyColour(int colour)
	{
		this.customSkyColour = colour;
		return this;
	}
	
	//==================================================//

	public Biome.Settings build()
	{
		return new Biome.Settings().configureSurfaceBuilder(this.surfaceBuilder, this.surfaceConfig).precipitation(this.precipitation).category(this.category).depth(this.baseHeight).scale(this.scale).temperature(this.temperature).downfall(this.downfall).waterColor(this.waterColour).waterFogColor(this.waterFogColour).parent(this.baseBiome);
	}

	public int getGrassColour()
	{
		return this.grassColour;
	}
	public int getFoliageColour()
	{
		return this.foliageColour;
	}
	public boolean hasCustomColours()
	{
		return this.hasCustomColours;
	}
	
	public float getSpawnChance()
	{
		return this.spawnChance;
	}
	
	public RiverType getRiverType()
	{
		return riverType;
	}
	
	public boolean hasCustomSkyColour()
	{
		return this.customSkyColour != -1;
	}
	
	public int getCustomSkyColour()
	{
		return this.customSkyColour;
	}
	
	//==================================================//
	
	public void setParent(TBOBiome parent)
	{
		this.parent = parent;
	}
	
	public TBOBiome getParent()
	{
		return this.parent;
	}
	
	public BiomePopulator createPopulator()
	{
		return new BiomePopulator(this.getParent());
	}
	
	public void addDefaultGeneration()
	{
		this.parent.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL));
		this.parent.addStructureFeature(Feature.STRONGHOLD, FeatureConfig.DEFAULT);
		DefaultBiomeFeatures.addLandCarvers(this.parent);
		DefaultBiomeFeatures.addDefaultStructures(this.parent);
		DefaultBiomeFeatures.addDungeons(this.parent);
	}
	
	public void addDefaultMineables()
	{
		DefaultBiomeFeatures.addMineables(this.parent);
		DefaultBiomeFeatures.addDefaultOres(this.parent);
		DefaultBiomeFeatures.addDefaultDisks(this.parent);
	}

	public static class BiomePopulator
	{
		public final TBOBiome parent;
		public BiomePopulator(TBOBiome parent)
		{
			this.parent = parent;
		}
		
		public int treesPerChunk = 0;
		public float extraTreeChance = 0.1F;
		public int extraTreeCount = 1;
		
		private List<Tuple<Feature<DefaultFeatureConfig>, Float>> treeFeatures = new ArrayList<>();
		
		private float weightSum = 0;
		
		public BiomePopulator addTreeFeature(Feature<DefaultFeatureConfig> feature, float weight)
		{
			weightSum += weight;
			this.treeFeatures.add(new Tuple<Feature<DefaultFeatureConfig>, Float>(feature, weight));
			return this;
		}
		
		public void buildTreeFeatures()
		{
			float tpc = (float) this.treesPerChunk;
			for (Tuple<Feature<DefaultFeatureConfig>, Float> feature : treeFeatures)
			{
				int n1 = MathHelper.floor(tpc * (feature.getB().floatValue() / this.weightSum));
				
				this.parent.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(feature.getA(), FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(n1, this.extraTreeChance, this.extraTreeCount)));
			}
		}
	}
	
	public static enum RiverType
	{
		NONE,
		WATER,
		ICY;
	}
}
