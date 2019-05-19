package valoeghese.biomeoverhaul.world.layer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.layer.LayerRandomnessSource;
import valoeghese.biomeoverhaul.TheBiomeOverhaul;
import valoeghese.biomeoverhaul.api.BiomeLayersRevamped;
import valoeghese.biomeoverhaul.api.enums.BiomeHumidity;
import valoeghese.biomeoverhaul.api.enums.BiomeTemperature;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.api.layer.Layer;
import valoeghese.biomeoverhaul.config.OverhaulSettings;
import valoeghese.biomeoverhaul.util.noise.OpenSimplexNoise;

public class BiomeLayersFunctions
{
	public static OpenSimplexNoise NOISE_1;
	public static OpenSimplexNoise NOISE_2;
	public static OpenSimplexNoise NOISE_OCEAN;
	public static OpenSimplexNoise NOISE_CLIMATE_FEATURE;
	public static OpenSimplexNoise NOISE_GENERATION_CATEGORY_A;
	public static OpenSimplexNoise NOISE_GENERATION_CATEGORY_B;
	public static OpenSimplexNoise NOISE_GENERATION_CATEGORY_C;

	public static double temperatureOffset;

	public static void initNoise(long seed, double temperatureOffset_)
	{
		temperatureOffset = temperatureOffset_;

		NOISE_1 = new OpenSimplexNoise(seed);
		NOISE_2 = new OpenSimplexNoise(seed + 1);
		NOISE_OCEAN = new OpenSimplexNoise(seed + 2);
		NOISE_CLIMATE_FEATURE = new OpenSimplexNoise(seed + 3);
		NOISE_GENERATION_CATEGORY_A = new OpenSimplexNoise(seed + 4);

		NOISE_GENERATION_CATEGORY_B = new OpenSimplexNoise(seed - 1);
		NOISE_GENERATION_CATEGORY_C = new OpenSimplexNoise(seed - 12);
	}
	
	//Many of these are replaced with config values
	
	public static final double HILLS_SCALE = 0.06D;
	public static final double SPECIAL_SCALE = 4.5D;
	//public static final double SWAMP_SCALE = 9D;
	//public static final double HUMIDITY_SCALE = 15D;
	//public static final double OCEAN_SIZE = 17D;
	//public static final double CLIMATE_SIZE = 27.5D; //The input is already scaled in some way, so this doesn't need to be super large.
	
	/**
	 * 
	 * @param x
	 * @param z
	 * @return int from 0 - 4. Represents temperature (0 = frozen; 4 = desert)
	 */
	public static int getTemperatureAtPos(double x, double z)
	{
		double val = NOISE_1.eval((x / OverhaulSettings.SETTINGS.climate_scale) - temperatureOffset, (z / OverhaulSettings.SETTINGS.climate_scale) - temperatureOffset);
		
		if (val > OverhaulSettings.SETTINGS.desert_cutoff) return 4;
		else if (val > OverhaulSettings.SETTINGS.tropical_cutoff) return 3;
		else if (val > OverhaulSettings.SETTINGS.cool_cutoff) return 2;
		else if (val > OverhaulSettings.SETTINGS.frozen_cutoff) return 1;
		else return 0; // */
	}

	public static boolean isOcean(double noise)
	{
		if (noise > OverhaulSettings.SETTINGS.ocean_cutoff)
			return true;
		else
			return false;
	}
	
	public static boolean isBluff(double noise, double int_1, double int_2)
	{
		double bluffNoise = 0.83 * NOISE_OCEAN.eval(int_1 / 6D, int_2 / 6D) + 0.17 * NOISE_2.eval(int_1 / 4D, int_2 / 4D);

		if (noise > OverhaulSettings.SETTINGS.ocean_bluff_cutoff && noise <= OverhaulSettings.SETTINGS.ocean_cutoff && bluffNoise > 0.24D)
			return true;
		else
			return false;
	}
	
	public static boolean isEstuary(double noise, double int_1, double int_2)
	{
		double bluffNoise = 0.83 * NOISE_OCEAN.eval(int_1 / 6D, int_2 / 6D) + 0.17 * NOISE_2.eval(int_1 / 4D, int_2 / 4D);

		if (noise > (OverhaulSettings.SETTINGS.ocean_cutoff - 0.06D) && noise <= OverhaulSettings.SETTINGS.ocean_cutoff && bluffNoise < -0.3D)
			return true;
		else
			return false;
	}

	public static double oceanNoise(double int_1, double int_2)
	{
		OpenSimplexNoise n = NOISE_OCEAN;

		return 0.8D * n.eval(int_1 / OverhaulSettings.SETTINGS.ocean_scale, int_2 / OverhaulSettings.SETTINGS.ocean_scale) + 0.14D * n.eval(int_1 / (OverhaulSettings.SETTINGS.ocean_scale / 2), int_2 / (OverhaulSettings.SETTINGS.ocean_scale / 2))+ 0.06D * n.eval(int_1 / (OverhaulSettings.SETTINGS.ocean_scale / 4), int_2 / (OverhaulSettings.SETTINGS.ocean_scale / 4));
	}

	public static Layer addOcean(int temperature, boolean island, LayerRandomnessSource rand, List<Layer> baseList, double oceanNoise)
	{
		Layer layer;
		switch (temperature)
		{
		case 0:
			layer = DefaultBiomeLayers.ocean_frozen;
			break;
		case 1:
			layer = DefaultBiomeLayers.ocean_cool;
			break;
		case 2:
			layer = DefaultBiomeLayers.ocean_temperate;
			break;
		case 3:
			layer = DefaultBiomeLayers.ocean_warm;
			break;
		case 4:
			layer = DefaultBiomeLayers.ocean_warm;
			break;
		default:
			layer = DefaultBiomeLayers.ocean_temperate;
			break;
		}

		if (oceanNoise > 0.5)
		{
			switch (temperature)
			{
			case 0:
				layer = DefaultBiomeLayers.deep_ocean_frozen;
				break;
			case 1:
				layer = DefaultBiomeLayers.deep_ocean_cool;
				break;
			case 2:
				layer = DefaultBiomeLayers.deep_ocean_temperate;
				break;
			case 3:
				layer = DefaultBiomeLayers.deep_ocean_warm;
				break;
			case 4:
				layer = DefaultBiomeLayers.deep_ocean_warm;
				break;
			default:
				layer = DefaultBiomeLayers.deep_ocean_temperate;
				break;
			}
		}

		if (!island) return layer;

		List<Layer> fallBack = Arrays.asList(layer);

		List<Layer> returns = getListOf(getUncheckedListForClimateCategory(Categories.bISLAND, baseList), fallBack);
		return returns.get(rand.nextInt(returns.size()));
	}

	public static List<Layer> getListForClimateCategory(int temperature, BiomeHumidity humidity, GenerationCategory category, int int_1, int int_2, double oceanNoise)
	{
		List<Layer> baseList = getListForClimate(temperature, humidity);
		List<Layer> bluffList = getUncheckedListForClimateCategory(Categories.bBLUFF, baseList);
		List<Layer> estuaryList = getUncheckedListForClimateCategory(Categories.bESTUARY, baseList);
		
		if (isBluff(oceanNoise, int_1, int_2) && !bluffList.isEmpty()) return bluffList;
		if (isEstuary(oceanNoise, int_1, int_2) && !estuaryList.isEmpty()) return estuaryList;
		
		List<Layer> categoryList = Categories.getListForCategory(category);

		return getListForClimateCategory(temperature, humidity, categoryList, baseList);
	}
	
	private static List<Layer> getListForClimateCategory(int temperature, BiomeHumidity humidity, List<Layer> categoryList, List<Layer> baseList)
	{
		List<Layer> list_1 = getUncheckedListForClimateCategory(categoryList, baseList);

		if (list_1.isEmpty())
		{
			if (categoryList == Categories.bPLAINS)
			{
				TheBiomeOverhaul.getLogger().error("[BiomeOverhaul] ERROR: no default PLAINS layers for temperature " + String.valueOf(temperature) + ", humidity " + humidity.toString() + ". Returning list of all layers in that temperature and humidity.");
				return baseList;
			}
			else return getListForClimateCategory(temperature, humidity, Categories.bPLAINS, baseList);
		}
		else return list_1;
	}

	public static List<Layer> getUncheckedListForClimateCategory(List<Layer> categoryList, List<Layer> baseList)
	{
		List<Layer> list_1 = new ArrayList<Layer>();

		for (Layer l : baseList)
			if (categoryList.contains(l)) list_1.add(l);

		return list_1;
	}

	public static GenerationCategory getCategoryAtPos(double int_1, double int_2, double oceanNoise, int temperature)
	{
		OpenSimplexNoise n = NOISE_GENERATION_CATEGORY_A;
		OpenSimplexNoise m = NOISE_GENERATION_CATEGORY_B;
		OpenSimplexNoise o = NOISE_GENERATION_CATEGORY_C;
		
		double height_noise;

		double forest_noise = 0.9D * n.eval(int_1 / 6.5D, int_2 / 6.5D) + 0.1D * n.eval(int_1, int_2, -2D);
		double canopy_noise = 0.88D * o.eval(int_1 / 7.5D, int_2 / 7.5D) + 0.12D * n.eval(int_1 / 2D, int_2 / 2D, -2D);
		double generation_noise_1 = 0.9D * n.eval(int_1 / 8D, int_2 / 8D) + 0.1D * n.eval(int_1 / 4.5D, int_2 / 4.5D);
		double generation_noise_2 = 0.9D * m.eval(int_1 / 8.2D, int_2 / 8.2D) + 0.1D * m.eval(int_1 / 4.3D, int_2 / 4.3D);
		double generation_noise_3 = 0.9D * m.eval(int_1 / 11.5D, int_2 / 11.5D) + 0.1D * n.eval(int_1 / 6D, int_2 / 5D);

		if (!isOcean(oceanNoise))
		{
			height_noise = OverhaulSettings.SETTINGS.mountain_main_scale_multiplier * n.eval(int_1 / 21.5D, int_2 / 21.5D) + 0.24D * n.eval(int_1 / 16D, int_2 / 16D) + 0.03D * n.eval(int_1 / 4D, int_2 / 4D, 2D);

			if (height_noise > 0.23D && height_noise < 0.32D)
				return GenerationCategory.MOUNTAIN;
			else if (height_noise > 0.17D && height_noise < 0.38D)
				return GenerationCategory.FOOTHILLS;

			if (temperature == 2)
			{
				if (generation_noise_1 > 0.3)
					return GenerationCategory.MEDITERRANEAN;
			}
			else if (temperature < 2)
			{
				if (generation_noise_1 < -0.32D)
					return GenerationCategory.BOREAL;
			}

			if (generation_noise_2 > OverhaulSettings.SETTINGS.rainforest_cutoff)
				return GenerationCategory.RAINFOREST;

			if (forest_noise > OverhaulSettings.SETTINGS.forest_cutoff)
			{
				if (canopy_noise > OverhaulSettings.SETTINGS.canopy_cutoff)
					return GenerationCategory.CANOPY;
				else return GenerationCategory.WOODLAND;
			}

			if (height_noise > -0.25D && forest_noise < -0.36D)
			{
				return GenerationCategory.BADLANDS;
			}

			if (forest_noise > -0.2D && generation_noise_3 > 0.3D)
			{
				return GenerationCategory.MEADOW;
			}
		}
		else
		{
			height_noise = 0.8 * n.eval(int_1 / 8D, int_2 / 8D) + 0.2 * n.eval(int_1 / 4D, int_2 / 4D, (int_1 + int_2) / 2D);

			Random rand = new Random((long) (int_1 * 5329 + int_2 * 2943));

			boolean generateIsland = (height_noise > 0.27D && height_noise < 0.29D);

			if (generateIsland)
				generateIsland = rand.nextInt(15) != 0;
			else
				generateIsland = rand.nextInt(25) == 0;

			if (generateIsland)
				return GenerationCategory.ISLAND;
		}

		return GenerationCategory.PLAINS;
	}

	/**
	 * 
	 * @param temperature
	 * @param humidity
	 * @return the list for the climate given. SWAMP humidity will be treated as WET.
	 */
	public static List<Layer> getListForClimate(int temperature, BiomeHumidity humidity)
	{

		switch (temperature)
		{
		case 0:
			if (humidity == BiomeHumidity.DRY) return BiomeLayersRevamped.frozenBiomesDry;
			else return BiomeLayersRevamped.frozenBiomesWet;
		case 1:
			if (humidity == BiomeHumidity.DRY) return BiomeLayersRevamped.coolBiomesDry;
			else return BiomeLayersRevamped.coolBiomesWet;
		case 2:
			if (humidity == BiomeHumidity.DRY) return BiomeLayersRevamped.temperateBiomesDry;
			else return BiomeLayersRevamped.temperateBiomesWet;
		case 3:
			if (humidity == BiomeHumidity.DRY) return BiomeLayersRevamped.tropicalBiomesDry;
			else return BiomeLayersRevamped.tropicalBiomesWet;
		case 4:
			if (humidity == BiomeHumidity.DRY) return BiomeLayersRevamped.desertBiomesDry;
			else return BiomeLayersRevamped.desertBiomesWet;
		default:
			return BiomeLayersRevamped.temperateBiomesDry;
		}

	}

	public static List<Layer> addSwamp(int temperature, List<Layer> fallback)
	{

		switch (temperature)
		{
		case 0:
			return getListOf(BiomeLayersRevamped.frozenBiomesSwamp, fallback);
		case 1:
			return getListOf(BiomeLayersRevamped.coolBiomesSwamp, fallback);
		case 2:
			return getListOf(BiomeLayersRevamped.temperateBiomesSwamp, fallback);
		case 3:
			return getListOf(BiomeLayersRevamped.tropicalBiomesSwamp, fallback);
		case 4:
			return getListOf(BiomeLayersRevamped.desertBiomesSwamp, fallback);
		default:
			return fallback;
		}
	}

	private static List<Layer> getListOf(List<Layer> returns, List<Layer> fallback)
	{
		if (returns.isEmpty()) return fallback;
		else return returns;
	}

	public static double mutation(double int_1, double int_2)
	{
		return NOISE_2.eval(int_1 / SPECIAL_SCALE, int_2 / SPECIAL_SCALE);
	}
	public static double hills(double int_1, double int_2)
	{
		return NOISE_1.eval(int_1 / HILLS_SCALE, int_2 / HILLS_SCALE);
	}

	public static boolean isSwamp(double int_1, double int_2)
	{
		double val = NOISE_CLIMATE_FEATURE.eval(int_1 / OverhaulSettings.SETTINGS.swamp_scale, int_2 / OverhaulSettings.SETTINGS.swamp_scale);

		return val > 0.334D;
	}
	public static boolean isBadlands(int temperature, double x, double z)
	{
		if (temperature != BiomeTemperature.DESERT.getId())
			return false;

		double val = NOISE_CLIMATE_FEATURE.eval(x / OverhaulSettings.SETTINGS.swamp_scale, z / OverhaulSettings.SETTINGS.swamp_scale);

		return val < -0.32D;
	}

	public static BiomeHumidity getHumidityAtPos(double x, double z, LayerRandomnessSource random)
	{
		double val =  NOISE_2.eval(x / OverhaulSettings.SETTINGS.humidity_scale, z / OverhaulSettings.SETTINGS.humidity_scale);

		if (val > 0.2) return BiomeHumidity.DRY;
		else if (val < -0.2) return BiomeHumidity.WET;
		else if (val > 0)
		{
			if (random.nextInt(4) == 0) return BiomeHumidity.WET;
			else return BiomeHumidity.DRY;
		}
		else
		{
			if (random.nextInt(4) == 0) return BiomeHumidity.DRY;
			else return BiomeHumidity.WET;
		}
	}
}
