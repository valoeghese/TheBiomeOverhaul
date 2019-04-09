package valoeghese.biomeoverhaul;

import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.api.BiomeRegistry;
import valoeghese.biomeoverhaul.world.biome.AlpsBiome;
import valoeghese.biomeoverhaul.world.biome.BayouBiome;
import valoeghese.biomeoverhaul.world.biome.BayouHillsBiome;
import valoeghese.biomeoverhaul.world.biome.ChaparralBiome;
import valoeghese.biomeoverhaul.world.biome.GrasslandBiome;
import valoeghese.biomeoverhaul.world.biome.GravellyMountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.GroveBiome;
import valoeghese.biomeoverhaul.world.biome.IcePlainsBiome;
import valoeghese.biomeoverhaul.world.biome.MountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.OasisBiome;
import valoeghese.biomeoverhaul.world.biome.RainforestBiome;
import valoeghese.biomeoverhaul.world.biome.RainforestMountainsBiome;
import valoeghese.biomeoverhaul.world.biome.ShieldBiome;
import valoeghese.biomeoverhaul.world.biome.ShrublandBiome;
import valoeghese.biomeoverhaul.world.biome.SteppeBiome;
import valoeghese.biomeoverhaul.world.biome.SubtropicalRainforestBiome;
import valoeghese.biomeoverhaul.world.biome.TundraBiome;
import valoeghese.biomeoverhaul.world.biome.WoodedMountainPeaksBiome;

public class ModBiomes
{
	public static Biome ALPS;
	public static Biome BAYOU;
	public static Biome BAYOU_HILLS;
	//TODO public static Biome BRUSHLAND;
	public static Biome CHAPARRAL;
	//TODO public static Biome FEN
	public static Biome GRASSLAND;
	public static Biome GRAVELLY_MOUNTAIN_PEAKS;
	public static Biome GROVE;
	public static Biome HIGHLAND;
	public static Biome ICE_PLAINS;
	//TODO public static Biome MARSH;
	//TODO public static Biome MIRE;
	public static Biome MOOR;
	public static Biome MOUNTAIN_PEAKS;
	public static Biome OASIS;
	public static Biome RAINFOREST;
	public static Biome RAINFOREST_MOUNTAINS;
	public static Biome SHIELD;
	public static Biome SHRUBLAND;
	public static Biome STEPPE;
	public static Biome SUBTROPICAL_RAINFOREST;
	//TODO public static Biome TEMPERATE_RAINFOREST;
	public static Biome TUNDRA;
	public static Biome WOODED_MOUNTAIN_PEAKS;
	
	public static void injectBiomes()
	{
		ALPS = BiomeRegistry.register(new AlpsBiome(), "tbo:alps");
		BAYOU = BiomeRegistry.register(new BayouBiome(), "tbo:bayou");
		BAYOU_HILLS = BiomeRegistry.register(new BayouHillsBiome(), "tbo:bayou_hills");
		CHAPARRAL = BiomeRegistry.register(new ChaparralBiome(), "tbo:chaparral");
		GRASSLAND = BiomeRegistry.register(new GrasslandBiome(0.2F, 0.3F, false), "tbo:grassland");
		GRAVELLY_MOUNTAIN_PEAKS = BiomeRegistry.register(new GravellyMountainPeaksBiome(), "tbo:gravelly_mountain_peaks");
		GROVE = BiomeRegistry.register(new GroveBiome(), "tbo:grove");
		HIGHLAND = BiomeRegistry.register(new GrasslandBiome(2.75F, 0.36F, false), "tbo:highland");
		ICE_PLAINS = BiomeRegistry.register(new IcePlainsBiome(), "tbo:ice_plains");
		MOOR = BiomeRegistry.register(new GrasslandBiome(2.4F, 0.33F, true), "tbo:moor");
		MOUNTAIN_PEAKS = BiomeRegistry.register(new MountainPeaksBiome(), "tbo:mountain_peaks");
		OASIS = BiomeRegistry.register(new OasisBiome(), "tbo:oasis");
		RAINFOREST = BiomeRegistry.register(new RainforestBiome(), "tbo:rainforest");
		RAINFOREST_MOUNTAINS = BiomeRegistry.register(new RainforestMountainsBiome(), "tbo:modified_rainforest");
		SHIELD = BiomeRegistry.register(new ShieldBiome(), "tbo:shield");
		SHRUBLAND = BiomeRegistry.register(new ShrublandBiome(), "tbo:shrubland");
		STEPPE = BiomeRegistry.register(new SteppeBiome(), "tbo:steppe");
		SUBTROPICAL_RAINFOREST = BiomeRegistry.register(new SubtropicalRainforestBiome(), "tbo:subtropical_rainforest");
		TUNDRA = BiomeRegistry.register(new TundraBiome(), "tbo:tundra");
		WOODED_MOUNTAIN_PEAKS = BiomeRegistry.register(new WoodedMountainPeaksBiome(), "tbo:wooded_mountain_peaks");
	}
}
