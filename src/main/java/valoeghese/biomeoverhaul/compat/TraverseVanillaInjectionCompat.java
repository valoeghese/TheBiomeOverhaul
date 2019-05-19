package valoeghese.biomeoverhaul.compat;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.SetBaseBiomesLayer;
import valoeghese.biomeoverhaul.api.enums.BiomeHumidity;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.api.layer.Layer;
import valoeghese.biomeoverhaul.mixin.AccessorMixin;
import valoeghese.biomeoverhaul.world.layer.BiomeLayersFunctions;

public class TraverseVanillaInjectionCompat
{
	private static final int FOREST_ID = Registry.BIOME.getRawId(Biomes.FOREST);
	private static final int PLAINS_ID = Registry.BIOME.getRawId(Biomes.PLAINS);
	private static final int TAIGA_ID = Registry.BIOME.getRawId(Biomes.TAIGA);
	private static final int SNOWY_TAIGA_ID = Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA);
	private static final int SNOWY_TUNDRA_ID = Registry.BIOME.getRawId(Biomes.SNOWY_TUNDRA);
	private static final int MOUNTAINS_ID = Registry.BIOME.getRawId(Biomes.MOUNTAINS);
	private static final int DARK_FOREST_ID = Registry.BIOME.getRawId(Biomes.DARK_FOREST);
	private static final int BIRCH_FOREST_ID = Registry.BIOME.getRawId(Biomes.BIRCH_FOREST);
	private static final int SWAMP_ID = Registry.BIOME.getRawId(Biomes.SWAMP);
	private static final int DESERT_ID = Registry.BIOME.getRawId(Biomes.DESERT);
	private static final int SAVANNA_ID = Registry.BIOME.getRawId(Biomes.SAVANNA);
	
	private static SetBaseBiomesLayer dummy = new SetBaseBiomesLayer(null, null);
	
	private static final List<Integer> default_snowy, default_cool, default_temp, default_dry;
	
	public static void injectModdedBiomes()
	{
		for (int b : ((AccessorMixin)dummy).getSnowyBiomes())
		{
			if (!default_snowy.contains(b))
			{
				Biome biome = Registry.BIOME.get(b);
				Biome.Category c = biome.getCategory();
				float humidity = biome.getRainfall();
				BiomeHumidity h = c == Biome.Category.SWAMP ? BiomeHumidity.SWAMP : (humidity >= 0.6F ? BiomeHumidity.WET : BiomeHumidity.DRY);
				
				BiomeLayersFunctions.getListForClimate(0, h).add(new Layer(b).withCategories(getCategoryFrom(c, biome)));
			}
		}
		for (int b : ((AccessorMixin)dummy).getCoolBiomes())
		{
			if (!default_cool.contains(b))
			{
				Biome biome = Registry.BIOME.get(b);
				Biome.Category c = biome.getCategory();
				float humidity = biome.getRainfall();
				BiomeHumidity h = c == Biome.Category.SWAMP ? BiomeHumidity.SWAMP : (humidity >= 0.6F ? BiomeHumidity.WET : BiomeHumidity.DRY);
				
				BiomeLayersFunctions.getListForClimate(1, h).add(new Layer(b).withCategories(getCategoryFrom(c, biome)));
			}
		}
		for (int b : ((AccessorMixin)dummy).getTemperateBiomes())
		{
			if (!default_temp.contains(b))
			{
				Biome biome = Registry.BIOME.get(b);
				Biome.Category c = biome.getCategory();
				float humidity = biome.getRainfall();
				BiomeHumidity h = c == Biome.Category.SWAMP ? BiomeHumidity.SWAMP : (humidity >= 0.6F ? BiomeHumidity.WET : BiomeHumidity.DRY);
				
				BiomeLayersFunctions.getListForClimate(2, h).add(new Layer(b).withCategories(getCategoryFrom(c, biome)));
			}
		}
		for (int b : ((AccessorMixin)dummy).getDryBiomes())
		{
			if (!default_dry.contains(b))
			{
				Biome biome = Registry.BIOME.get(b);
				Biome.Category c = biome.getCategory();
				float humidity = biome.getRainfall();
				BiomeHumidity h = c == Biome.Category.SWAMP ? BiomeHumidity.SWAMP : (humidity >= 0.6F ? BiomeHumidity.WET : BiomeHumidity.DRY);
				
				BiomeLayersFunctions.getListForClimate(c == Biome.Category.DESERT ? 4 : 3, h).add(new Layer(b).withCategories(c == Biome.Category.DESERT ? GenerationCategory.PLAINS : getCategoryFrom(c, biome)));
			}
		}
	}
	
	private static GenerationCategory getCategoryFrom(Biome.Category c, Biome b)
	{
		if (c == Biome.Category.EXTREME_HILLS)
			return GenerationCategory.MOUNTAIN;
		else if (c == Biome.Category.DESERT || c == Biome.Category.MESA || c == Biome.Category.NETHER)
			return GenerationCategory.BADLANDS;
		else if (c == Biome.Category.FOREST || c == Biome.Category.TAIGA)
			return GenerationCategory.WOODLAND;
		else if (c == Biome.Category.JUNGLE)
			return GenerationCategory.RAINFOREST;
		else if (c == Biome.Category.MUSHROOM || c == Biome.Category.OCEAN)
			return GenerationCategory.ISLAND;
		else if (c == Biome.Category.BEACH)
		{
			if (b.getDepth() > 0.9F)
				return GenerationCategory.BLUFF;
			else
				return GenerationCategory.PLAINS;
		}
		else
			return GenerationCategory.PLAINS;
	}
	
	static
	{
		default_cool = Arrays.asList(FOREST_ID, TAIGA_ID, MOUNTAINS_ID, PLAINS_ID);
		default_snowy = Arrays.asList(SNOWY_TUNDRA_ID, SNOWY_TAIGA_ID);
		default_temp = Arrays.asList(FOREST_ID, DARK_FOREST_ID, MOUNTAINS_ID, PLAINS_ID, BIRCH_FOREST_ID, SWAMP_ID);
		default_dry = Arrays.asList(DESERT_ID, SAVANNA_ID, PLAINS_ID);
	}
}
