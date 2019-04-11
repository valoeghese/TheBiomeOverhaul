package valoeghese.biomeoverhaul;

import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.api.BiomeRegistry;
import valoeghese.biomeoverhaul.world.biome.AlpsBiome;
import valoeghese.biomeoverhaul.world.biome.AlpsEdgeBiome;
import valoeghese.biomeoverhaul.world.biome.BayouBiome;
import valoeghese.biomeoverhaul.world.biome.BayouHillsBiome;
import valoeghese.biomeoverhaul.world.biome.BrushlandBiome;
import valoeghese.biomeoverhaul.world.biome.ChaparralBiome;
import valoeghese.biomeoverhaul.world.biome.FenBiome;
import valoeghese.biomeoverhaul.world.biome.ForestedFenBiome;
import valoeghese.biomeoverhaul.world.biome.GlacierBiome;
import valoeghese.biomeoverhaul.world.biome.GrasslandBiome;
import valoeghese.biomeoverhaul.world.biome.GravellyMountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.GroveBiome;
import valoeghese.biomeoverhaul.world.biome.IcePlainsBiome;
import valoeghese.biomeoverhaul.world.biome.MarshBiome;
import valoeghese.biomeoverhaul.world.biome.MireBiome;
import valoeghese.biomeoverhaul.world.biome.MountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.OasisBiome;
import valoeghese.biomeoverhaul.world.biome.RainforestBiome;
import valoeghese.biomeoverhaul.world.biome.RainforestMountainsBiome;
import valoeghese.biomeoverhaul.world.biome.ShieldBiome;
import valoeghese.biomeoverhaul.world.biome.ShrublandBiome;
import valoeghese.biomeoverhaul.world.biome.SteppeBiome;
import valoeghese.biomeoverhaul.world.biome.SubtropicalRainforestBiome;
import valoeghese.biomeoverhaul.world.biome.TemperateRainforestBiome;
import valoeghese.biomeoverhaul.world.biome.TundraBiome;
import valoeghese.biomeoverhaul.world.biome.WoodedMountainPeaksBiome;

public class ModBiomes
{
	public static Biome ALPS;
	public static Biome ALPS_EDGE;
	public static Biome BAYOU;
	public static Biome BAYOU_HILLS;
	public static Biome BRUSHLAND;
	public static Biome CHAPARRAL;
	public static Biome FEN;
	public static Biome FORESTED_FEN;
	public static Biome GLACIER;
	public static Biome GRASSLAND;
	public static Biome GRAVELLY_MOUNTAIN_PEAKS;
	public static Biome GROVE;
	public static Biome HIGHLAND;
	public static Biome ICE_PLAINS;
	public static Biome MARSH;
	public static Biome MIRE;
	public static Biome MOOR;
	public static Biome MOUNTAIN_PEAKS;
	public static Biome OASIS;
	public static Biome RAINFOREST;
	public static Biome RAINFOREST_MOUNTAINS;
	public static Biome SHIELD;
	public static Biome SHRUBLAND;
	public static Biome STEPPE;
	public static Biome SUBTROPICAL_RAINFOREST;
	public static Biome TEMPERATE_RAINFOREST;
	public static Biome TUNDRA;
	public static Biome WOODED_MOUNTAIN_PEAKS;
	
	public static void injectBiomes()
	{
		ALPS = BiomeRegistry.register(new AlpsBiome(), "tbo:alps");
		BAYOU = BiomeRegistry.register(new BayouBiome(), "tbo:bayou");
		BRUSHLAND = BiomeRegistry.register(new BrushlandBiome(), "tbo:brushland");
		CHAPARRAL = BiomeRegistry.register(new ChaparralBiome(), "tbo:chaparral");
		GLACIER = BiomeRegistry.register(new GlacierBiome(), "tbo:glacier");
		GRASSLAND = BiomeRegistry.register(new GrasslandBiome(0.2F, 0.3F, false), "tbo:grassland");
		GROVE = BiomeRegistry.register(new GroveBiome(), "tbo:grove");
		FEN = BiomeRegistry.register(new FenBiome(), "tbo:fen");
		HIGHLAND = BiomeRegistry.register(new GrasslandBiome(2.75F, 0.36F, false), "tbo:highland");
		ICE_PLAINS = BiomeRegistry.register(new IcePlainsBiome(), "tbo:ice_plains");
		MARSH = BiomeRegistry.register(new MarshBiome(), "tbo:marsh");
		MIRE = BiomeRegistry.register(new MireBiome(), "tbo:mire");
		MOOR = BiomeRegistry.register(new GrasslandBiome(2.4F, 0.33F, true), "tbo:moor");
		OASIS = BiomeRegistry.register(new OasisBiome(), "tbo:oasis");
		RAINFOREST = BiomeRegistry.register(new RainforestBiome(), "tbo:rainforest");
		SHIELD = BiomeRegistry.register(new ShieldBiome(), "tbo:shield");
		SHRUBLAND = BiomeRegistry.register(new ShrublandBiome(), "tbo:shrubland");
		STEPPE = BiomeRegistry.register(new SteppeBiome(), "tbo:steppe");
		SUBTROPICAL_RAINFOREST = BiomeRegistry.register(new SubtropicalRainforestBiome(), "tbo:subtropical_rainforest");
		TEMPERATE_RAINFOREST = BiomeRegistry.register(new TemperateRainforestBiome(), "tbo:temperate_rainforest");
		TUNDRA = BiomeRegistry.register(new TundraBiome(), "tbo:tundra");
		
		//SubBiomes
		ALPS_EDGE = BiomeRegistry.register(new AlpsEdgeBiome(), "tbo:alps_edge");
		BAYOU_HILLS = BiomeRegistry.register(new BayouHillsBiome(), "tbo:bayou_hills");
		GRAVELLY_MOUNTAIN_PEAKS = BiomeRegistry.register(new GravellyMountainPeaksBiome(), "tbo:gravelly_mountain_peaks");
		FORESTED_FEN = BiomeRegistry.register(new ForestedFenBiome(), "tbo:forested_fen");
		MOUNTAIN_PEAKS = BiomeRegistry.register(new MountainPeaksBiome(), "tbo:mountain_peaks");
		RAINFOREST_MOUNTAINS = BiomeRegistry.register(new RainforestMountainsBiome(), "tbo:modified_rainforest");
		WOODED_MOUNTAIN_PEAKS = BiomeRegistry.register(new WoodedMountainPeaksBiome(), "tbo:wooded_mountain_peaks");
	}
}
