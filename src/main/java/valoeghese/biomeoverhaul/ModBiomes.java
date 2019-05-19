package valoeghese.biomeoverhaul;

import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.api.BiomeRegistry;
import valoeghese.biomeoverhaul.api.SpawnBiomes;
import valoeghese.biomeoverhaul.world.biome.AlpsBiome;
import valoeghese.biomeoverhaul.world.biome.AlpsEdgeBiome;
import valoeghese.biomeoverhaul.world.biome.BayouBiome;
import valoeghese.biomeoverhaul.world.biome.BayouHillsBiome;
import valoeghese.biomeoverhaul.world.biome.BrushlandBiome;
import valoeghese.biomeoverhaul.world.biome.ChaparralBiome;
import valoeghese.biomeoverhaul.world.biome.CliffsBiome;
import valoeghese.biomeoverhaul.world.biome.DunesBiome;
import valoeghese.biomeoverhaul.world.biome.FenBiome;
import valoeghese.biomeoverhaul.world.biome.FlowerFieldBiome;
import valoeghese.biomeoverhaul.world.biome.ForestedFenBiome;
import valoeghese.biomeoverhaul.world.biome.ForestedSpiresBiome;
import valoeghese.biomeoverhaul.world.biome.GlacierBiome;
import valoeghese.biomeoverhaul.world.biome.GrasslandBiome;
import valoeghese.biomeoverhaul.world.biome.GravellyMountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.GroveBiome;
import valoeghese.biomeoverhaul.world.biome.IcePlainsBiome;
import valoeghese.biomeoverhaul.world.biome.MarshBiome;
import valoeghese.biomeoverhaul.world.biome.MireBiome;
import valoeghese.biomeoverhaul.world.biome.MoorBiome;
import valoeghese.biomeoverhaul.world.biome.MountainPeaksBiome;
import valoeghese.biomeoverhaul.world.biome.MurkyBayouBiome;
import valoeghese.biomeoverhaul.world.biome.OakenThicketBiome;
import valoeghese.biomeoverhaul.world.biome.OasisBiome;
import valoeghese.biomeoverhaul.world.biome.OutbackBiome;
import valoeghese.biomeoverhaul.world.biome.OutbackUluruBiome;
import valoeghese.biomeoverhaul.world.biome.PeatBogBiome;
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
	//TODO public static Biome BOREAL_WOODS;
	public static Biome BRUSHLAND;
	public static Biome CHAPARRAL;
	public static Biome CLIFFS;
	//TODO public static Biome CRAG;
	//TODO public static Biome DECIDUOUS_FOREST;
	public static Biome DUNES;
	//TODO public static Biome ENCHANTED_MEADOWS; //GenerationCategory MAGICAL
	//TODO public static Biome ESTUARY; //Temperate
	public static Biome FEN;
	//TODO public static Biome FIELD;
	public static Biome FLOWER_FIELD;
	public static Biome FORESTED_FEN;
	public static Biome FORESTED_SPIRES;
	public static Biome GLACIER;
	public static Biome GRASSLAND;
	public static Biome GRAVELLY_MOUNTAIN_PEAKS;
	public static Biome GROVE;
	public static Biome HIGHLAND;
	public static Biome ICE_PLAINS;
	public static Biome MARSH;
	public static Biome MIRE;
	public static Biome MURKY_BAYOU;
	public static Biome MOOR;
	public static Biome MOUNTAIN_PEAKS;
	public static Biome OAKEN_THICKET;
	public static Biome OASIS;
	public static Biome OUTBACK;
	public static Biome OUTBACK_ULURU;
	public static Biome PEAT_BOG; //Tropical Estuary?
	//TODO public static Biome PRAIRIE; //Meadow Gen, Temperate;
	public static Biome RAINFOREST;
	public static Biome RAINFOREST_MOUNTAINS;
	public static Biome REDWOODS; //3x3 trees
	//TODO public static biome RED_DUNES;
	public static Biome SHIELD;
	public static Biome SHRUBLAND;
	//TODO public static final Biome SPRINGS;
	public static Biome STEPPE;
	public static Biome SUBTROPICAL_RAINFOREST;
	public static Biome TEMPERATE_RAINFOREST;
	public static Biome TUNDRA;
	public static Biome TROPICAL_ISLAND;
	public static Biome TROPICAL_ISLAND_SHORE;
	//TODO public static Biome WASTELAND_EAST
	//TODO public static Biome WASTELAND_WEST
	public static Biome WOODED_MOUNTAIN_PEAKS;

	public static void init()
	{
		//pre 1.2.0
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
		
		//SubBiomes (pre 1.2.0)
		ALPS_EDGE = BiomeRegistry.register(new AlpsEdgeBiome(), "tbo:alps_edge");
		BAYOU_HILLS = BiomeRegistry.register(new BayouHillsBiome(), "tbo:bayou_hills");
		GRAVELLY_MOUNTAIN_PEAKS = BiomeRegistry.register(new GravellyMountainPeaksBiome(), "tbo:gravelly_mountain_peaks");
		FORESTED_FEN = BiomeRegistry.register(new ForestedFenBiome(), "tbo:forested_fen");
		MOUNTAIN_PEAKS = BiomeRegistry.register(new MountainPeaksBiome(), "tbo:mountain_peaks");
		OUTBACK_ULURU = BiomeRegistry.register(new OutbackUluruBiome(), "tbo:modified_outback");
		RAINFOREST_MOUNTAINS = BiomeRegistry.register(new RainforestMountainsBiome(), "tbo:modified_rainforest");
		WOODED_MOUNTAIN_PEAKS = BiomeRegistry.register(new WoodedMountainPeaksBiome(), "tbo:wooded_mountain_peaks");
		
		//===================================================================================
		
		//1.2.0
		DUNES = BiomeRegistry.register(new DunesBiome(), "tbo:dunes");
		FLOWER_FIELD = BiomeRegistry.register(new FlowerFieldBiome(), "tbo:flower_field");
		FORESTED_SPIRES = BiomeRegistry.register(new ForestedSpiresBiome(), "tbo:forested_spires");
		PEAT_BOG = BiomeRegistry.register(new PeatBogBiome(), "tbo:peat_bog");
		
		MURKY_BAYOU = BiomeRegistry.register(new MurkyBayouBiome(), "tbo:murky_bayou");
		
		TheBiomeOverhaul.getLogger().debug("Registered Biomes");
		
		//Players cannot spawn in Alps, Mountain Peaks biomes, Mire, Murky Bayou, Oasis, Uluru, and Wasteland biomes
		SpawnBiomes.addSpawnBiomes(
		  ALPS_EDGE,
		  BAYOU, BAYOU_HILLS, BRUSHLAND,
		  CHAPARRAL, CLIFFS,
		  DUNES,
		  FEN, FLOWER_FIELD, FORESTED_FEN, FORESTED_SPIRES,
		  GLACIER, GRASSLAND, GROVE,
		  HIGHLAND,
		  ICE_PLAINS,
		  MARSH, MOOR,
		  OAKEN_THICKET, OUTBACK,
		  PEAT_BOG,
		  RAINFOREST, RAINFOREST_MOUNTAINS, REDWOODS,
		  SHIELD, SHRUBLAND, STEPPE, SUBTROPICAL_RAINFOREST,
		  TEMPERATE_RAINFOREST, TUNDRA, TROPICAL_ISLAND, TROPICAL_ISLAND_SHORE
		);
		
		TheBiomeOverhaul.getLogger().debug("Added Spawn Biomes");
	}
}