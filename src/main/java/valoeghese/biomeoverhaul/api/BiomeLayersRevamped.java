package valoeghese.biomeoverhaul.api;

import java.util.ArrayList;
import java.util.List;

import valoeghese.biomeoverhaul.TheBiomeOverhaul;
import valoeghese.biomeoverhaul.api.enums.BiomeHumidity;
import valoeghese.biomeoverhaul.api.enums.BiomeTemperature;
import valoeghese.biomeoverhaul.api.layer.Layer;
import valoeghese.biomeoverhaul.world.layer.DefaultBiomeLayers;

public class BiomeLayersRevamped
{
	public static final List<Layer> mesaFeatureList = new ArrayList<>();
	
	public static final List<Layer> desertBiomesDry = new ArrayList<>();
	public static final List<Layer> tropicalBiomesDry = new ArrayList<>();
	public static final List<Layer> temperateBiomesDry = new ArrayList<>();
	public static final List<Layer> coolBiomesDry = new ArrayList<>();
	public static final List<Layer> frozenBiomesDry = new ArrayList<>();

	public static final List<Layer> desertBiomesWet = new ArrayList<>();
	public static final List<Layer> tropicalBiomesWet = new ArrayList<>();
	public static final List<Layer> temperateBiomesWet = new ArrayList<>();
	public static final List<Layer> coolBiomesWet = new ArrayList<>();
	public static final List<Layer> frozenBiomesWet = new ArrayList<>();
	
	public static final List<Layer> desertBiomesSwamp = new ArrayList<>();
	public static final List<Layer> tropicalBiomesSwamp = new ArrayList<>();
	public static final List<Layer> temperateBiomesSwamp = new ArrayList<>();
	public static final List<Layer> coolBiomesSwamp = new ArrayList<>();
	public static final List<Layer> frozenBiomesSwamp = new ArrayList<>();
	
	/**
	 * Adds a biome layer to the specific map.
	 * 
	 * @param temp
	 * @param humidity
	 * @param layer
	 */
	public static void addLayer(Layer layer, BiomeTemperature temp, BiomeHumidity humidity)
	{
		addLayer(layer, temp, humidity, false);
	}
	
	public static void addLayer(Layer layer, BiomeTemperature temp, BiomeHumidity humidity, boolean suppressWarnings)
	{
		if (layer.categories.isEmpty() && !suppressWarnings)
			TheBiomeOverhaul.getLogger().error("[BiomeOverhaul] WARNING: injected layer " + layer.toString() + " has not been set any GenerationCategories. If this is intentional, please call this method with boolean suppressWarnings set to FALSE");
		
		switch(temp.getId())
		{
		case 0:
			if (humidity == BiomeHumidity.DRY) BiomeLayersRevamped.frozenBiomesDry.add(layer);
			else if (humidity == BiomeHumidity.SWAMP) BiomeLayersRevamped.frozenBiomesSwamp.add(layer);
			else BiomeLayersRevamped.frozenBiomesWet.add(layer);
			break;
		case 1:
			if (humidity == BiomeHumidity.DRY) BiomeLayersRevamped.coolBiomesDry.add(layer);
			else if (humidity == BiomeHumidity.SWAMP) BiomeLayersRevamped.coolBiomesSwamp.add(layer);
			else BiomeLayersRevamped.coolBiomesWet.add(layer);
			break;
		case 2:
			if (humidity == BiomeHumidity.DRY) BiomeLayersRevamped.temperateBiomesDry.add(layer);
			else if (humidity == BiomeHumidity.SWAMP) BiomeLayersRevamped.temperateBiomesSwamp.add(layer);
			else BiomeLayersRevamped.temperateBiomesWet.add(layer);
			break;
		case 3:
			if (humidity == BiomeHumidity.DRY) BiomeLayersRevamped.tropicalBiomesDry.add(layer);
			else if (humidity == BiomeHumidity.SWAMP) BiomeLayersRevamped.tropicalBiomesSwamp.add(layer);
			else BiomeLayersRevamped.tropicalBiomesWet.add(layer);
			break;
		case 4:
			if (humidity == BiomeHumidity.DRY) BiomeLayersRevamped.desertBiomesDry.add(layer);
			else if (humidity == BiomeHumidity.SWAMP) BiomeLayersRevamped.desertBiomesSwamp.add(layer);
			else BiomeLayersRevamped.desertBiomesWet.add(layer);
			break;
		default:
			TheBiomeOverhaul.getLogger().error("There was an error in injecting a biomelayer into Temperature " + temp.toString() + ", humidity" + humidity.toString());
		}
	}

	static
	{
		//Adds default biomes
		
		mesaFeatureList.add(DefaultBiomeLayers.mesa_0);
		mesaFeatureList.add(DefaultBiomeLayers.mesa_1);
		mesaFeatureList.add(DefaultBiomeLayers.mesa_2);
		
		desertBiomesDry.add(DefaultBiomeLayers.desert_badlands);
		desertBiomesDry.add(DefaultBiomeLayers.desert_standard);
		desertBiomesDry.add(DefaultBiomeLayers.desert_dunes);
		
		desertBiomesWet.add(DefaultBiomeLayers.desert_humid);
		
		tropicalBiomesDry.add(DefaultBiomeLayers.tropical_savanna_forest);
		tropicalBiomesDry.add(DefaultBiomeLayers.tropical_savanna);
		tropicalBiomesDry.add(DefaultBiomeLayers.tropical_outback);
		
		tropicalBiomesDry.add(DefaultBiomeLayers.tropical_island);
		tropicalBiomesWet.add(DefaultBiomeLayers.tropical_island);
		
		tropicalBiomesWet.add(DefaultBiomeLayers.tropical_brushland);
		tropicalBiomesWet.add(DefaultBiomeLayers.tropical_jungle);
		tropicalBiomesWet.add(DefaultBiomeLayers.tropical_darkforest);
		tropicalBiomesWet.add(DefaultBiomeLayers.tropical_rainforest);
		
		tropicalBiomesWet.add(DefaultBiomeLayers.tropical_bog);
		
		tropicalBiomesSwamp.add(DefaultBiomeLayers.tropical_bayou);
		
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_plains_dry);
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_plains_plus);
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_forest);
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_dry_thicket);
		
		temperateBiomesDry.add(DefaultBiomeLayers.ocean_cliffs);
		temperateBiomesWet.add(DefaultBiomeLayers.ocean_cliffs);
		
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_meditteranean_plains);
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_meditteranean_forest);
		
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_plains_humid);
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_forest_humid);
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_forest);
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_redwoods);
		
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_spires);
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_subtropical_rainforest);
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_temperate_rainforest);
		
		//Mountains
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_foothills);
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_foothills);
		temperateBiomesWet.add(DefaultBiomeLayers.temperate_mountains);
		temperateBiomesDry.add(DefaultBiomeLayers.temperate_mountains);
		
		temperateBiomesSwamp.add(DefaultBiomeLayers.temperate_swamp);
		temperateBiomesSwamp.add(DefaultBiomeLayers.temperate_forested_swamp);
		
		coolBiomesDry.add(DefaultBiomeLayers.cool_plains_dry);
		coolBiomesDry.add(DefaultBiomeLayers.cool_forest_dry);
		coolBiomesDry.add(DefaultBiomeLayers.cool_boreal_plains);
		
		coolBiomesDry.add(DefaultBiomeLayers.ocean_cliffs);
		
		coolBiomesWet.add(DefaultBiomeLayers.cool_plains_humid);
		coolBiomesWet.add(DefaultBiomeLayers.cool_forest_humid);
		coolBiomesWet.add(DefaultBiomeLayers.cool_boreal_forest);
		
		//Mountains
		coolBiomesDry.add(DefaultBiomeLayers.cool_dry_foothills);
		coolBiomesWet.add(DefaultBiomeLayers.cool_humid_foothills);
		coolBiomesDry.add(DefaultBiomeLayers.cool_dry_mountains);
		coolBiomesWet.add(DefaultBiomeLayers.cool_humid_mountains);
		
		coolBiomesSwamp.add(DefaultBiomeLayers.cool_swamp);
		coolBiomesSwamp.add(DefaultBiomeLayers.cool_forested_swamp);
		coolBiomesSwamp.add(DefaultBiomeLayers.cool_swamp_mountains);
		
		frozenBiomesDry.add(DefaultBiomeLayers.frozen_plains_dry);
		
		frozenBiomesWet.add(DefaultBiomeLayers.frozen_forest);
		frozenBiomesWet.add(DefaultBiomeLayers.frozen_plains_humid);
		
		//Mountains
		frozenBiomesDry.add(DefaultBiomeLayers.frozen_mountains);
		frozenBiomesWet.add(DefaultBiomeLayers.frozen_mountains);
		frozenBiomesDry.add(DefaultBiomeLayers.frozen_foothills);
		frozenBiomesWet.add(DefaultBiomeLayers.frozen_foothills);
	}

}
