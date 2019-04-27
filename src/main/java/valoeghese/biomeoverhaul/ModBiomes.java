package valoeghese.biomeoverhaul;

import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.api.BiomeRegistry;
import valoeghese.biomeoverhaul.world.biome.AlpsBiome;
import valoeghese.biomeoverhaul.world.biome.AlpsEdgeBiome;
import valoeghese.biomeoverhaul.world.biome.BayouBiome;
import valoeghese.biomeoverhaul.world.biome.BayouHillsBiome;
import valoeghese.biomeoverhaul.world.biome.BrushlandBiome;
import valoeghese.biomeoverhaul.world.biome.ChaparralBiome;
import valoeghese.biomeoverhaul.world.biome.CliffsBiome;
import valoeghese.biomeoverhaul.world.biome.FenBiome;
import valoeghese.biomeoverhaul.world.biome.ForestedFenBiome;
import valoeghese.biomeoverhaul.world.biome.GlacierBiome;
import valoeghese.biomeoverhaul.world.biome.GrasslandBiome;
import valoeghese.biomeoverhaul.world.biome.GravellyMountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.GroveBiome;
import valoeghese.biomeoverhaul.world.biome.IcePlainsBiome;
import valoeghese.biomeoverhaul.world.biome.MarshBiome;
import valoeghese.biomeoverhaul.world.biome.MireBiome;
import valoeghese.biomeoverhaul.world.biome.MoorBiome;
import valoeghese.biomeoverhaul.world.biome.MountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.OakenThicketBiome;
import valoeghese.biomeoverhaul.world.biome.OasisBiome;
import valoeghese.biomeoverhaul.world.biome.OutbackBiome;
import valoeghese.biomeoverhaul.world.biome.OutbackUluruBiome;
import valoeghese.biomeoverhaul.world.biome.RainforestBiome;
import valoeghese.biomeoverhaul.world.biome.RainforestMountainsBiome;
import valoeghese.biomeoverhaul.world.biome.RedwoodsBiome;
import valoeghese.biomeoverhaul.world.biome.ShieldBiome;
import valoeghese.biomeoverhaul.world.biome.ShrublandBiome;
import valoeghese.biomeoverhaul.world.biome.SteppeBiome;
import valoeghese.biomeoverhaul.world.biome.SubtropicalRainforestBiome;
import valoeghese.biomeoverhaul.world.biome.TemperateRainforestBiome;
import valoeghese.biomeoverhaul.world.biome.TropicalIslandBiome;
import valoeghese.biomeoverhaul.world.biome.TropicalIslandShoreBiome;
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
	public static Biome CLIFFS;
	//TODO public static final Biome ENCHANTED_MEADOWS; //GenerationCategory MAGICAL
	//TODO public static final Biome ESTUARY; //Temperate
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
	public static Biome OAKEN_THICKET;
	public static Biome OASIS;
	public static Biome OUTBACK;
	public static Biome OUTBACK_ULURU;
	//TODO public static final Biome PEAT_BOG; //Tropical Estuary?
	//TODO public static final Biome PRAIRIE; //Meadow Gen, Temperate;
	public static Biome RAINFOREST;
	public static Biome RAINFOREST_MOUNTAINS;
	public static Biome REDWOODS; //3x3 trees
	public static Biome SHIELD;
	public static Biome SHRUBLAND;
	//TODO public static final Biome SPRINGS;
	public static Biome STEPPE;
	public static Biome SUBTROPICAL_RAINFOREST;
	public static Biome TEMPERATE_RAINFOREST;
	public static Biome TUNDRA;
	public static Biome TROPICAL_ISLAND;
	public static Biome TROPICAL_ISLAND_SHORE;
	public static Biome WOODED_MOUNTAIN_PEAKS;

	public static void init()
	{
		ALPS = BiomeRegistry.register(new AlpsBiome(), "tbo:alps");
		BAYOU = BiomeRegistry.register(new BayouBiome(), "tbo:bayou");
		BRUSHLAND = BiomeRegistry.register(new BrushlandBiome(), "tbo:brushland");
		CHAPARRAL = BiomeRegistry.register(new ChaparralBiome(), "tbo:chaparral");
		CLIFFS = BiomeRegistry.register(new CliffsBiome(), "tbo:cliffs");
		GLACIER = BiomeRegistry.register(new GlacierBiome(), "tbo:glacier");
		GRASSLAND = BiomeRegistry.register(new GrasslandBiome(0.2F, 0.3F), "tbo:grassland");
		GROVE = BiomeRegistry.register(new GroveBiome(), "tbo:grove");
		FEN = BiomeRegistry.register(new FenBiome(), "tbo:fen");
		HIGHLAND = BiomeRegistry.register(new GrasslandBiome(2.75F, 0.36F), "tbo:highland");
		ICE_PLAINS = BiomeRegistry.register(new IcePlainsBiome(), "tbo:ice_plains");
		MARSH = BiomeRegistry.register(new MarshBiome(), "tbo:marsh");
		MIRE = BiomeRegistry.register(new MireBiome(), "tbo:mire");
		MOOR = BiomeRegistry.register(new MoorBiome(), "tbo:moor");
		OASIS = BiomeRegistry.register(new OasisBiome(), "tbo:oasis");
		OAKEN_THICKET = BiomeRegistry.register(new OakenThicketBiome(), "tbo:oaken_thicket");
		OUTBACK = BiomeRegistry.register(new OutbackBiome(), "tbo:outback");
		RAINFOREST = BiomeRegistry.register(new RainforestBiome(), "tbo:rainforest");
		REDWOODS = BiomeRegistry.register(new RedwoodsBiome(), "tbo:redwoods");
		SHIELD = BiomeRegistry.register(new ShieldBiome(), "tbo:shield");
		SHRUBLAND = BiomeRegistry.register(new ShrublandBiome(), "tbo:shrubland");
		STEPPE = BiomeRegistry.register(new SteppeBiome(), "tbo:steppe");
		SUBTROPICAL_RAINFOREST = BiomeRegistry.register(new SubtropicalRainforestBiome(), "tbo:subtropical_rainforest");
		TEMPERATE_RAINFOREST = BiomeRegistry.register(new TemperateRainforestBiome(), "tbo:temperate_rainforest");
		TUNDRA = BiomeRegistry.register(new TundraBiome(), "tbo:tundra");
		TROPICAL_ISLAND = BiomeRegistry.register(new TropicalIslandBiome(), "tbo:tropical_island");
		TROPICAL_ISLAND_SHORE = BiomeRegistry.register(new TropicalIslandShoreBiome(), "tbo:tropical_island_shore");
		
		//SubBiomes
		ALPS_EDGE = BiomeRegistry.register(new AlpsEdgeBiome(), "tbo:alps_edge");
		BAYOU_HILLS = BiomeRegistry.register(new BayouHillsBiome(), "tbo:bayou_hills");
		GRAVELLY_MOUNTAIN_PEAKS = BiomeRegistry.register(new GravellyMountainPeaksBiome(), "tbo:gravelly_mountain_peaks");
		FORESTED_FEN = BiomeRegistry.register(new ForestedFenBiome(), "tbo:forested_fen");
		MOUNTAIN_PEAKS = BiomeRegistry.register(new MountainPeaksBiome(), "tbo:mountain_peaks");
		OUTBACK_ULURU = BiomeRegistry.register(new OutbackUluruBiome(), "tbo:modified_outback");
		RAINFOREST_MOUNTAINS = BiomeRegistry.register(new RainforestMountainsBiome(), "tbo:modified_rainforest");
		WOODED_MOUNTAIN_PEAKS = BiomeRegistry.register(new WoodedMountainPeaksBiome(), "tbo:wooded_mountain_peaks");

		TheBiomeOverhaul.getLogger().debug("Registered Biomes");
	}
}