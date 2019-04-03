package valoeghese.biomeoverhaul.world.layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.layer.LayerRandomnessSource;
import valoeghese.biomeoverhaul.api.BiomeLayersRevamped;
import valoeghese.biomeoverhaul.api.Categories;
import valoeghese.biomeoverhaul.api.Layer;
import valoeghese.biomeoverhaul.util.noise.OpenSimplexNoise;

public class BiomeLayersFunctions
{
	public static OpenSimplexNoise NOISE_1;
	public static OpenSimplexNoise NOISE_2;
	public static OpenSimplexNoise NOISE_OCEAN;
	public static OpenSimplexNoise NOISE_CLIMATE_FEATURE;
	public static OpenSimplexNoise NOISE_GENERATION_CATEGORY;


	public static double temperatureOffset;

	public static void initNoise(long seed, double temperatureOffset_)
	{
		temperatureOffset = temperatureOffset_;

		NOISE_1 = new OpenSimplexNoise(seed);
		NOISE_2 = new OpenSimplexNoise(seed + 1);
		NOISE_OCEAN = new OpenSimplexNoise(seed + 2);
		NOISE_CLIMATE_FEATURE = new OpenSimplexNoise(seed + 3);
		NOISE_GENERATION_CATEGORY = new OpenSimplexNoise(seed + 4);
	}

	public static final double HILLS_SCALE = 0.03D;
	public static final double SPECIAL_SCALE = 4.5D;
	public static final double SWAMP_SCALE = 9D;
	public static final double HUMIDITY_SCALE = 15D;
	public static final double OCEAN_SIZE = 17.5D;
	public static final double CLIMATE_SIZE = 30D; //The input is already scaled in some way, so this doesn't need to be super large.


	/**
	 * 
	 * @param x
	 * @param z
	 * @return int from 0 - 4. Represents temperature (0 = frozen; 4 = desert)
	 */
	public static int getTemperatureAtPos(double x, double z)
	{

		double val = NOISE_1.eval((x / CLIMATE_SIZE) - temperatureOffset, (z / CLIMATE_SIZE) - temperatureOffset);
		
		if (val > 0.62D) return 4;
		else if (val > 0.28D) return 3;
		else if (val > -0.28D) return 2;
		else if (val > -0.62D) return 1;
		else return 0;
	}

	public static boolean isOcean(double int_1, double int_2)
	{
		OpenSimplexNoise n = NOISE_OCEAN;

		double noise = 0.8D * n.eval(OCEAN_SIZE, OCEAN_SIZE) + 0.14D * n.eval(OCEAN_SIZE / 2, OCEAN_SIZE / 2)+ 0.06D * n.eval(OCEAN_SIZE / 4, OCEAN_SIZE / 4);

		if (noise > 0.3D)
			return true;
		else
			return false;
	}

	public static Layer addOcean(int temperature)
	{
		switch (temperature)
		{
		case 0:
			return DefaultBiomeLayers.ocean_frozen;
		case 1:
			return DefaultBiomeLayers.ocean_cool;
		case 2:
			return DefaultBiomeLayers.ocean_temperate;
		case 3:
			return DefaultBiomeLayers.ocean_warm;
		case 4:
			return DefaultBiomeLayers.ocean_warm;
		default:
			return DefaultBiomeLayers.ocean_temperate;
		}
	}

	public static List<Layer> getListForClimateCategory(int temperature, BiomeHumidity humidity, GenerationCategory category)
	{
		List<Layer> baseList = getListForClimate(temperature, humidity);

		return getListForClimateCategory(temperature, humidity, category, baseList);
	}
	
	private static List<Layer> getListForClimateCategory(int temperature, BiomeHumidity humidity, GenerationCategory category, List<Layer> baseList)
	{
		List<Layer> categoryList = Categories.getListForCategory(category);

		List<Layer> list_1 = new ArrayList<Layer>();

		for (Layer l : baseList)
			if (categoryList.contains(l)) list_1.add(l);

		if (list_1.isEmpty())
		{
			if (category == GenerationCategory.DEFAULT)
			{
				System.out.println("[BiomeOverhaul] ERROR: no DEFAULT layers for temperature " + String.valueOf(temperature) + ", humidity " + humidity.toString() + ". Returning list of all layers in that temperature and humidity.");
				return baseList;
			}
			else return getListForClimateCategory(temperature, humidity, GenerationCategory.DEFAULT, baseList);
		}
		else return list_1;
	}
	
	public static GenerationCategory getCategoryAtPos(double int_1, double int_2, boolean isOcean, int temperature)
	{
		OpenSimplexNoise n = NOISE_GENERATION_CATEGORY;
		double height_noise;
		
		double generation_noise_1 = 0.9D * n.eval(int_1 / 8D, int_2 / 8D) + 0.1D * n.eval(int_1 / 4.5D, int_2 / 4.5D);
		
		if (!isOcean)
		{
			height_noise = 0.76D * n.eval(int_1 / 12.5D, int_2 / 12.5D) + 0.21D * n.eval(int_1 / 8.7D, int_2 / 8.7D) + 0.03D * n.eval(int_1 / 2D, int_2 / 2D, 2D);
			
			if (height_noise > 0.25D && height_noise < 0.32D)
				return GenerationCategory.MOUNTAIN;
			
			if (temperature == 2)
			{
				if (generation_noise_1 > 0.28)
					return GenerationCategory.MEDITERRANEAN;
			}
			else if (temperature < 2)
			{
				if (generation_noise_1 < -0.32)
					return GenerationCategory.BOREAL;
			}
					
		}
		else
		{
			height_noise = 0.76D * n.eval(int_1 / 24.5D, int_2 / 24.5D) + 0.21D * n.eval(int_1 / 6.7D, int_2 / 6.7D) + 0.03D * n.eval(int_1 / 3D, int_2 / 3D, 2D);
			
			Random rand = new Random((long) (int_1 * 5329 + int_2 * 2943));
			
			boolean generateIsland = (height_noise > 0.27D && height_noise < 0.29D);
			
			if (generateIsland)
				generateIsland = !(rand.nextInt(15) == 0);
			else
				generateIsland = rand.nextInt(25) == 0;
			
			if (generateIsland)
				return GenerationCategory.ISLAND;
		}

		return GenerationCategory.DEFAULT;
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

	public static List<Layer> addSwamp(int temperature, List<Layer> fallback, LayerRandomnessSource rand)
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
	public static double hills(double int_1, double z)
	{
		return NOISE_1.eval(int_1 / HILLS_SCALE, z / HILLS_SCALE);
	}

	public static boolean isSwamp(double int_1, double int_2)
	{
		double val = NOISE_CLIMATE_FEATURE.eval(int_1 / SWAMP_SCALE, int_2 / SWAMP_SCALE);

		return val > 0.31D;
	}
	public static boolean isBadlands(int temperature, BiomeHumidity humidity, double x, double z)
	{
		if (temperature != 4 || humidity != BiomeHumidity.DRY)
			return false;

		double val = NOISE_CLIMATE_FEATURE.eval(x / SWAMP_SCALE, x / SWAMP_SCALE);

		return val < -0.3D;
	}

	public static BiomeHumidity getHumidityAtPos(double x, double z, LayerRandomnessSource random)
	{
		double val =  NOISE_2.eval(x / HUMIDITY_SCALE, z / HUMIDITY_SCALE);

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
