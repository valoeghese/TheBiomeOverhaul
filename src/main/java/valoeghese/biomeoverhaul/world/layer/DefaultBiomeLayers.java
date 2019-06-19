package valoeghese.biomeoverhaul.world.layer;

import net.minecraft.world.biome.Biomes;
import valoeghese.biomeoverhaul.ModBiomes;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.api.layer.Layer;

public class DefaultBiomeLayers
{
	public static final Layer ocean_frozen = new Layer(Biomes.FROZEN_OCEAN);
	public static final Layer ocean_cool = new Layer(Biomes.COLD_OCEAN);
	public static final Layer ocean_temperate = new Layer(Biomes.LUKEWARM_OCEAN);
	public static final Layer ocean_warm = new Layer(Biomes.WARM_OCEAN);
	
	public static final Layer deep_ocean_frozen = new Layer(Biomes.DEEP_FROZEN_OCEAN);
	public static final Layer deep_ocean_cool = new Layer(Biomes.DEEP_COLD_OCEAN);
	public static final Layer deep_ocean_temperate = new Layer(Biomes.DEEP_LUKEWARM_OCEAN);
	public static final Layer deep_ocean_warm = new Layer(Biomes.DEEP_WARM_OCEAN);
	
	public static final Layer ocean_cliffs = new Layer(ModBiomes.CLIFFS).withCategories(GenerationCategory.BLUFF);
	
	public static final Layer desert_humid = new Layer(Biomes.DESERT,  Biomes.DESERT_LAKES,  Biomes.DESERT_LAKES,  Biomes.DESERT_HILLS).withCategories(GenerationCategory.PLAINS);
	public static final Layer desert_standard = new Layer(Biomes.DESERT,  Biomes.DESERT_HILLS).withCategories(GenerationCategory.PLAINS);
	public static final Layer desert_badlands = new Layer(Biomes.DESERT,  Biomes.DESERT_HILLS,  Biomes.DESERT,  Biomes.BADLANDS).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer desert_dunes = new Layer(ModBiomes.DUNES).withCategories(GenerationCategory.BADLANDS);
	
	public static final Layer tropical_savanna_forest = new Layer(Biomes.SAVANNA,  Biomes.DARK_FOREST).withCategories(GenerationCategory.WOODLAND);
	public static final Layer tropical_savanna = new Layer(Biomes.SAVANNA,  Biomes.SAVANNA_PLATEAU,  Biomes.SHATTERED_SAVANNA,  Biomes.SHATTERED_SAVANNA_PLATEAU).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer tropical_brushland = new Layer(ModBiomes.BRUSHLAND).withCategories(GenerationCategory.PLAINS);
	public static final Layer tropical_jungle = new Layer(Biomes.JUNGLE,  Biomes.JUNGLE_HILLS,  Biomes.MODIFIED_JUNGLE,  Biomes.JUNGLE).withCategories(GenerationCategory.WOODLAND);
	public static final Layer tropical_darkforest = new Layer(Biomes.DARK_FOREST,  Biomes.DARK_FOREST_HILLS,  Biomes.DARK_FOREST,  Biomes.PLAINS).withCategories(GenerationCategory.WOODLAND);
	public static final Layer tropical_rainforest = new Layer(ModBiomes.RAINFOREST,  ModBiomes.RAINFOREST_MOUNTAINS,  ModBiomes.RAINFOREST_MOUNTAINS,  ModBiomes.RAINFOREST).withCategories(GenerationCategory.RAINFOREST);
	
	public static final Layer tropical_outback = new Layer(ModBiomes.OUTBACK).withCategories(GenerationCategory.BADLANDS).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer tropical_bayou = new Layer(ModBiomes.BAYOU,  ModBiomes.BAYOU_HILLS).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer tropical_island = new Layer(ModBiomes.TROPICAL_ISLAND,  Biomes.WARM_OCEAN).withCategories(GenerationCategory.ISLAND);
	
	public static final Layer tropical_bog = new Layer(ModBiomes.PEAT_BOG).withCategories(GenerationCategory.ESTUARY);
	
	public static final Layer temperate_plains_dry = new Layer(Biomes.PLAINS,  Biomes.FOREST,  Biomes.PLAINS,  Biomes.WOODED_HILLS).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_plains_plus = new Layer(ModBiomes.FLOWER_FIELD,  Biomes.FOREST,  Biomes.PLAINS,  Biomes.FLOWER_FOREST).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_forest = new Layer(Biomes.FOREST,  Biomes.WOODED_HILLS,  Biomes.FOREST,  Biomes.FLOWER_FOREST).withCategories(GenerationCategory.WOODLAND);
	public static final Layer temperate_dry_thicket = new Layer(ModBiomes.OAKEN_THICKET).withCategories(GenerationCategory.WOODLAND);
	
	public static final Layer temperate_temperate_rainforest = new Layer(ModBiomes.TEMPERATE_RAINFOREST).withCategories(GenerationCategory.RAINFOREST);
	public static final Layer temperate_subtropical_rainforest = new Layer(ModBiomes.SUBTROPICAL_RAINFOREST).withCategories(GenerationCategory.RAINFOREST);
	
	public static final Layer temperate_plains_humid = new Layer(ModBiomes.SHRUBLAND,  Biomes.FOREST,  ModBiomes.SHRUBLAND,  Biomes.WOODED_HILLS).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_forest_humid = new Layer(Biomes.BIRCH_FOREST,  Biomes.BIRCH_FOREST_HILLS,  Biomes.TALL_BIRCH_FOREST,  Biomes.TALL_BIRCH_HILLS).withCategories(GenerationCategory.WOODLAND);
	public static final Layer temperate_redwoods = new Layer(ModBiomes.REDWOODS).withCategories(GenerationCategory.CANOPY);
	public static final Layer temperate_spires = new Layer(ModBiomes.FORESTED_SPIRES).withCategories(GenerationCategory.RAINFOREST);
	
	public static final Layer temperate_foothills = new Layer(Biomes.MOUNTAINS,  Biomes.WOODED_MOUNTAINS,  Biomes.GRAVELLY_MOUNTAINS,  Biomes.MODIFIED_GRAVELLY_MOUNTAINS).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer temperate_mountains = new Layer(ModBiomes.WOODED_MOUNTAIN_PEAKS,  ModBiomes.MOUNTAIN_PEAKS,  ModBiomes.GRAVELLY_MOUNTAIN_PEAKS,  ModBiomes.MOUNTAIN_PEAKS).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer temperate_meditteranean_plains = new Layer(ModBiomes.CHAPARRAL,  ModBiomes.CHAPARRAL,  ModBiomes.CHAPARRAL, ModBiomes.GROVE).withCategories(GenerationCategory.MEDITERRANEAN);
	public static final Layer temperate_meditteranean_forest = new Layer(ModBiomes.GROVE).withCategories(GenerationCategory.MEDITERRANEAN);
	
	public static final Layer temperate_swamp = new Layer(Biomes.SWAMP,  Biomes.SWAMP_HILLS).withCategories(GenerationCategory.PLAINS);
	public static final Layer temperate_forested_swamp = new Layer(ModBiomes.FEN,  ModBiomes.FORESTED_FEN).withCategories(GenerationCategory.RAINFOREST);
	
	public static final Layer cool_plains_dry = new Layer(ModBiomes.STEPPE,  ModBiomes.STEPPE,  ModBiomes.STEPPE,  Biomes.WOODED_MOUNTAINS).withCategories(GenerationCategory.PLAINS);
	public static final Layer cool_forest_dry = new Layer(Biomes.TAIGA,  Biomes.TAIGA_HILLS,  Biomes.TAIGA_MOUNTAINS,  Biomes.TAIGA).withCategories(GenerationCategory.WOODLAND);
	
	public static final Layer cool_humid_foothills = new Layer(Biomes.TAIGA,  Biomes.WOODED_MOUNTAINS,  ModBiomes.TUNDRA,  ModBiomes.TUNDRA).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer cool_dry_foothills = new Layer(Biomes.MOUNTAIN_EDGE,  Biomes.MOUNTAIN_EDGE,  Biomes.MOUNTAINS,  Biomes.WOODED_MOUNTAINS).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer cool_humid_mountains = new Layer(ModBiomes.WOODED_MOUNTAIN_PEAKS,  ModBiomes.MOUNTAIN_PEAKS,  ModBiomes.MOOR,  ModBiomes.MOOR).withCategories(GenerationCategory.MOUNTAIN);
	public static final Layer cool_dry_mountains = new Layer(ModBiomes.WOODED_MOUNTAIN_PEAKS,  ModBiomes.MOUNTAIN_PEAKS,  ModBiomes.HIGHLAND,  ModBiomes.HIGHLAND).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer cool_swamp_mountains = new Layer(ModBiomes.MOOR).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer cool_forest_humid = new Layer(Biomes.TAIGA,  Biomes.TAIGA_HILLS,  ModBiomes.SHIELD,  ModBiomes.SHIELD).withCategories(GenerationCategory.WOODLAND);
	public static final Layer cool_plains_humid = new Layer(ModBiomes.GRASSLAND).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer cool_boreal_plains = new Layer(ModBiomes.TUNDRA,  ModBiomes.TUNDRA,  ModBiomes.TUNDRA,  Biomes.MOUNTAINS).withCategories(GenerationCategory.BOREAL);
	public static final Layer cool_boreal_forest = new Layer(ModBiomes.SHIELD,  ModBiomes.SHIELD,  Biomes.MOUNTAIN_EDGE,  Biomes.MOUNTAINS).withCategories(GenerationCategory.BOREAL);
	
	public static final Layer cool_swamp = new Layer(ModBiomes.MARSH).withCategories(GenerationCategory.PLAINS);
	public static final Layer cool_forested_swamp = new Layer(ModBiomes.MIRE,  ModBiomes.MIRE,  ModBiomes.FEN,  ModBiomes.FORESTED_FEN).withCategories(GenerationCategory.WOODLAND);
	
	//TODO Ice spikes as modification
	public static final Layer frozen_plains_dry = new Layer(Biomes.SNOWY_TUNDRA,  Biomes.SNOWY_MOUNTAINS,  Biomes.SNOWY_TUNDRA,  Biomes.ICE_SPIKES).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer frozen_foothills = new Layer(ModBiomes.ALPS_EDGE).withCategories(GenerationCategory.FOOTHILLS);
	public static final Layer frozen_mountains = new Layer(ModBiomes.ALPS).withCategories(GenerationCategory.MOUNTAIN);
	
	public static final Layer frozen_forest = new Layer(Biomes.SNOWY_TAIGA,  Biomes.SNOWY_TAIGA_HILLS,  Biomes.SNOWY_TAIGA_MOUNTAINS,  Biomes.SNOWY_TAIGA).withCategories(GenerationCategory.WOODLAND);
	public static final Layer frozen_plains_humid = new Layer(ModBiomes.ICE_PLAINS,  Biomes.SNOWY_TAIGA,  ModBiomes.ICE_PLAINS,  ModBiomes.GLACIER).withCategories(GenerationCategory.PLAINS);
	
	public static final Layer mesa_0 = new Layer(Biomes.BADLANDS_PLATEAU,  Biomes.BADLANDS,  Biomes.MODIFIED_BADLANDS_PLATEAU,  Biomes.BADLANDS);
	public static final Layer mesa_1 = new Layer(Biomes.BADLANDS_PLATEAU,  Biomes.BADLANDS_PLATEAU,  Biomes.MODIFIED_BADLANDS_PLATEAU,  Biomes.MODIFIED_BADLANDS_PLATEAU);
	public static final Layer mesa_2 = new Layer(Biomes.BADLANDS,  Biomes.BADLANDS_PLATEAU,  Biomes.BADLANDS,  Biomes.MODIFIED_BADLANDS_PLATEAU);
}