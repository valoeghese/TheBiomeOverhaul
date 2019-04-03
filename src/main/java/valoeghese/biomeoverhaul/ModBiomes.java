package valoeghese.biomeoverhaul;

import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.api.BiomeRegistry;
import valoeghese.biomeoverhaul.world.biome.BiomeAlps;
import valoeghese.biomeoverhaul.world.biome.BiomeBayou;
import valoeghese.biomeoverhaul.world.biome.BiomeChapparal;
import valoeghese.biomeoverhaul.world.biome.BiomeGrassland;
import valoeghese.biomeoverhaul.world.biome.BiomeGrove;
import valoeghese.biomeoverhaul.world.biome.BiomeIcePlains;
import valoeghese.biomeoverhaul.world.biome.BiomeShield;
import valoeghese.biomeoverhaul.world.biome.BiomeTundra;

public class ModBiomes
{
	public static Biome ALPS;
	public static Biome BAYOU;
	public static Biome BAYOU_HILLS;
	public static Biome CHAPARRAL;
	public static Biome GRASSLAND;
	public static Biome GROVE;
	public static Biome ICE_PLAINS;
	public static Biome MOOR;
	//TODO public static Biome OASIS;
	//TODO public static Biome RAINFOREST;
	public static Biome SHIELD;
	public static Biome TUNDRA;
	
	public static void injectBiomes()
	{
		ALPS = BiomeRegistry.register(new BiomeAlps(), "tbo:alps");
		BAYOU = BiomeRegistry.register(new BiomeBayou(0.1F), "tbo:bayou");
		BAYOU_HILLS = BiomeRegistry.register(new BiomeBayou(0.3F), "tbo:bayou_hills");
		CHAPARRAL = BiomeRegistry.register(new BiomeChapparal(), "tbo:chaparral");
		GRASSLAND = BiomeRegistry.register(new BiomeGrassland(0.2F, 0.3F, false), "tbo:grassland");
		GROVE = BiomeRegistry.register(new BiomeGrove(), "tbo:grove");
		ICE_PLAINS = BiomeRegistry.register(new BiomeIcePlains(), "tbo:ice_plains");
		MOOR = BiomeRegistry.register(new BiomeGrassland(2.4F, 0.33F, true), "tbo:moor");
		SHIELD = BiomeRegistry.register(new BiomeShield(), "tbo:shield");
		TUNDRA = BiomeRegistry.register(new BiomeTundra(), "tbo:tundra");
	}
}
