package valoeghese.biomeoverhaul.world.layer;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import valoeghese.biomeoverhaul.ModBiomes;
import valoeghese.biomeoverhaul.api.Layer;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;

public class DefaultBiomeLayers
{
	public static final Layer ocean_frozen = new Layer(Registry.BIOME.getRawId(Biomes.FROZEN_OCEAN));
	public static final Layer ocean_cool = new Layer(Registry.BIOME.getRawId(Biomes.COLD_OCEAN));
	public static final Layer ocean_temperate = new Layer(Registry.BIOME.getRawId(Biomes.LUKEWARM_OCEAN));
	public static final Layer ocean_warm = new Layer(Registry.BIOME.getRawId(Biomes.WARM_OCEAN));
	
	public static final Layer desert_humid = new Layer(Registry.BIOME.getRawId(Biomes.DESERT), Registry.BIOME.getRawId(Biomes.DESERT_LAKES), Registry.BIOME.getRawId(Biomes.DESERT_LAKES), Registry.BIOME.getRawId(Biomes.DESERT_HILLS)).withCategories(GenerationCategory.PLAINS);
	public static final Layer desert_standard = new Layer(Registry.BIOME.getRawId(Biomes.DESERT), Registry.BIOME.getRawId(Biomes.DESERT_HILLS)).withCategories(GenerationCategory.PLAINS);
	public static final Layer desert_badlands = new Layer(Registry.BIOME.getRawId(Biomes.DESERT), Registry.BIOME.getRawId(Biomes.DESERT_HILLS), Registry.BIOME.getRawId(Biomes.DESERT), Registry.BIOME.getRawId(Biomes.BADLANDS)).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer tropical_savanna_forest = new Layer(Registry.BIOME.getRawId(Biomes.SAVANNA), Registry.BIOME.getRawId(Biomes.DARK_FOREST)).withCategories(GenerationCategory.WOODLAND);
	public static final Layer tropical_savanna = new Layer(Registry.BIOME.getRawId(Biomes.SAVANNA), Registry.BIOME.getRawId(Biomes.SAVANNA_PLATEAU), Registry.BIOME.getRawId(Biomes.SHATTERED_SAVANNA), Registry.BIOME.getRawId(Biomes.SHATTERED_SAVANNA_PLATEAU)).withCategories(GenerationCategory.PLAINS);
	
	//TODO actual brushland biome
	public static final Layer tropical_brushland = new Layer(Registry.BIOME.getRawId(Biomes.SAVANNA), Registry.BIOME.getRawId(Biomes.DARK_FOREST)).withCategories(GenerationCategory.PLAINS);
	public static final Layer tropical_jungle = new Layer(Registry.BIOME.getRawId(Biomes.JUNGLE), Registry.BIOME.getRawId(Biomes.JUNGLE_HILLS), Registry.BIOME.getRawId(Biomes.MODIFIED_JUNGLE), Registry.BIOME.getRawId(Biomes.JUNGLE)).withCategories(GenerationCategory.WOODLAND);
	public static final Layer tropical_darkforest = new Layer(Registry.BIOME.getRawId(Biomes.DARK_FOREST), Registry.BIOME.getRawId(Biomes.DARK_FOREST_HILLS), Registry.BIOME.getRawId(Biomes.DARK_FOREST), Registry.BIOME.getRawId(Biomes.PLAINS)).withCategories(GenerationCategory.WOODLAND);
	public static final Layer tropical_rainforest = new Layer(Registry.BIOME.getRawId(ModBiomes.RAINFOREST), Registry.BIOME.getRawId(ModBiomes.RAINFOREST_MOUNTAINS), Registry.BIOME.getRawId(ModBiomes.RAINFOREST_MOUNTAINS), Registry.BIOME.getRawId(ModBiomes.RAINFOREST)).withCategories(GenerationCategory.RAINFOREST);
	
	public static final Layer tropical_bayou = new Layer(Registry.BIOME.getRawId(ModBiomes.BAYOU), Registry.BIOME.getRawId(ModBiomes.BAYOU_HILLS)).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer temperate_plains_dry = new Layer(Registry.BIOME.getRawId(Biomes.PLAINS), Registry.BIOME.getRawId(Biomes.FOREST), Registry.BIOME.getRawId(Biomes.PLAINS), Registry.BIOME.getRawId(Biomes.WOODED_HILLS)).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_plains_plus = new Layer(Registry.BIOME.getRawId(Biomes.PLAINS), Registry.BIOME.getRawId(Biomes.FOREST), Registry.BIOME.getRawId(Biomes.PLAINS), Registry.BIOME.getRawId(Biomes.FLOWER_FOREST)).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_forest = new Layer(Registry.BIOME.getRawId(Biomes.FOREST), Registry.BIOME.getRawId(Biomes.WOODED_HILLS), Registry.BIOME.getRawId(Biomes.FOREST), Registry.BIOME.getRawId(Biomes.FLOWER_FOREST)).withCategories(GenerationCategory.WOODLAND);
	public static final Layer temperate_subtropical_rainforest = new Layer(Registry.BIOME.getRawId(ModBiomes.SUBTROPICAL_RAINFOREST)).withCategories(GenerationCategory.RAINFOREST);
	
	public static final Layer temperate_plains_humid = new Layer(Registry.BIOME.getRawId(ModBiomes.SHRUBLAND), Registry.BIOME.getRawId(Biomes.FOREST), Registry.BIOME.getRawId(ModBiomes.SHRUBLAND), Registry.BIOME.getRawId(Biomes.WOODED_HILLS)).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_forest_humid = new Layer(Registry.BIOME.getRawId(Biomes.BIRCH_FOREST), Registry.BIOME.getRawId(Biomes.BIRCH_FOREST_HILLS), Registry.BIOME.getRawId(Biomes.TALL_BIRCH_FOREST), Registry.BIOME.getRawId(Biomes.TALL_BIRCH_HILLS)).withCategories(GenerationCategory.WOODLAND);
	
	public static final Layer temperate_foothills = new Layer(Registry.BIOME.getRawId(Biomes.MOUNTAINS), Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS), Registry.BIOME.getRawId(Biomes.GRAVELLY_MOUNTAINS), Registry.BIOME.getRawId(Biomes.MODIFIED_GRAVELLY_MOUNTAINS)).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer temperate_mountains = new Layer(Registry.BIOME.getRawId(ModBiomes.WOODED_MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.GRAVELLY_MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.MOUNTAIN_PEAKS)).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer temperate_meditteranean_plains = new Layer(Registry.BIOME.getRawId(ModBiomes.CHAPARRAL), Registry.BIOME.getRawId(ModBiomes.CHAPARRAL), Registry.BIOME.getRawId(ModBiomes.CHAPARRAL) ,Registry.BIOME.getRawId(ModBiomes.GROVE)).withCategories(GenerationCategory.MEDITERRANEAN);
	public static final Layer temperate_meditteranean_forest = new Layer(Registry.BIOME.getRawId(ModBiomes.GROVE)).withCategories(GenerationCategory.MEDITERRANEAN);
	
	public static final Layer temperate_swamp = new Layer(Registry.BIOME.getRawId(Biomes.SWAMP), Registry.BIOME.getRawId(Biomes.SWAMP_HILLS)).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer cool_plains_dry = new Layer(Registry.BIOME.getRawId(ModBiomes.STEPPE), Registry.BIOME.getRawId(ModBiomes.STEPPE), Registry.BIOME.getRawId(ModBiomes.STEPPE), Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS)).withCategories(GenerationCategory.PLAINS);
	public static final Layer cool_forest_dry = new Layer(Registry.BIOME.getRawId(Biomes.TAIGA), Registry.BIOME.getRawId(Biomes.TAIGA_HILLS), Registry.BIOME.getRawId(Biomes.TAIGA_MOUNTAINS), Registry.BIOME.getRawId(Biomes.TAIGA)).withCategories(GenerationCategory.WOODLAND);
	
	public static final Layer cool_humid_foothills = new Layer(Registry.BIOME.getRawId(Biomes.TAIGA), Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS), Registry.BIOME.getRawId(ModBiomes.TUNDRA), Registry.BIOME.getRawId(ModBiomes.TUNDRA)).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer cool_dry_foothills = new Layer(Registry.BIOME.getRawId(Biomes.MOUNTAIN_EDGE), Registry.BIOME.getRawId(Biomes.MOUNTAIN_EDGE), Registry.BIOME.getRawId(Biomes.MOUNTAINS), Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS)).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer cool_humid_mountains = new Layer(Registry.BIOME.getRawId(ModBiomes.WOODED_MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.MOOR), Registry.BIOME.getRawId(ModBiomes.MOOR)).withCategories(GenerationCategory.MOUNTAIN);
	public static final Layer cool_dry_mountains = new Layer(Registry.BIOME.getRawId(ModBiomes.WOODED_MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.MOUNTAIN_PEAKS), Registry.BIOME.getRawId(ModBiomes.HIGHLAND), Registry.BIOME.getRawId(ModBiomes.HIGHLAND)).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer cool_forest_humid = new Layer(Registry.BIOME.getRawId(Biomes.TAIGA), Registry.BIOME.getRawId(Biomes.TAIGA_HILLS), Registry.BIOME.getRawId(ModBiomes.SHIELD), Registry.BIOME.getRawId(ModBiomes.SHIELD)).withCategories(GenerationCategory.WOODLAND);
	public static final Layer cool_plains_humid = new Layer(Registry.BIOME.getRawId(ModBiomes.GRASSLAND)).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer cool_boreal_plains = new Layer(Registry.BIOME.getRawId(ModBiomes.TUNDRA), Registry.BIOME.getRawId(ModBiomes.TUNDRA), Registry.BIOME.getRawId(ModBiomes.TUNDRA), Registry.BIOME.getRawId(Biomes.MOUNTAINS)).withCategories(GenerationCategory.BOREAL);
	public static final Layer cool_boreal_forest = new Layer(Registry.BIOME.getRawId(ModBiomes.SHIELD), Registry.BIOME.getRawId(ModBiomes.SHIELD), Registry.BIOME.getRawId(Biomes.MOUNTAIN_EDGE), Registry.BIOME.getRawId(Biomes.MOUNTAINS)).withCategories(GenerationCategory.BOREAL);
	
	//TODO Ice spikes as modification
	public static final Layer frozen_plains_dry = new Layer(Registry.BIOME.getRawId(Biomes.SNOWY_TUNDRA), Registry.BIOME.getRawId(Biomes.SNOWY_MOUNTAINS), Registry.BIOME.getRawId(Biomes.SNOWY_TUNDRA), Registry.BIOME.getRawId(Biomes.ICE_SPIKES)).withCategories(GenerationCategory.PLAINS);
	
	//TODO Alps Edge
	public static final Layer frozen_foothills = new Layer(Registry.BIOME.getRawId(Biomes.SNOWY_MOUNTAINS)).withCategories(GenerationCategory.MOUNTAIN);
	public static final Layer frozen_mountains = new Layer(Registry.BIOME.getRawId(ModBiomes.ALPS)).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer frozen_forest = new Layer(Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA), Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA_HILLS), Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA_MOUNTAINS), Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA)).withCategories(GenerationCategory.WOODLAND);
	public static final Layer frozen_plains_humid = new Layer(Registry.BIOME.getRawId(ModBiomes.ICE_PLAINS), Registry.BIOME.getRawId(Biomes.SNOWY_MOUNTAINS), Registry.BIOME.getRawId(ModBiomes.ICE_PLAINS), Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA)).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer mesa_0 = new Layer(Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU), Registry.BIOME.getRawId(Biomes.BADLANDS), Registry.BIOME.getRawId(Biomes.MODIFIED_BADLANDS_PLATEAU), Registry.BIOME.getRawId(Biomes.BADLANDS));
	public static final Layer mesa_1 = new Layer(Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU), Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU), Registry.BIOME.getRawId(Biomes.MODIFIED_BADLANDS_PLATEAU), Registry.BIOME.getRawId(Biomes.MODIFIED_BADLANDS_PLATEAU));
	public static final Layer mesa_2 = new Layer(Registry.BIOME.getRawId(Biomes.BADLANDS), Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU), Registry.BIOME.getRawId(Biomes.BADLANDS), Registry.BIOME.getRawId(Biomes.MODIFIED_BADLANDS_PLATEAU));
}