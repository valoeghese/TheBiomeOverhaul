package valoeghese.biomeoverhaul;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import valoeghese.biomeoverhaul.api.BiomeModifier;
import valoeghese.biomeoverhaul.api.modifier.BiomeModifiers;
import valoeghese.biomeoverhaul.util.OceanManipulation;
import valoeghese.biomeoverhaul.util.event.GenerationEventHandler;
import valoeghese.biomeoverhaul.util.noise.OpenSimplexNoise;
import valoeghese.biomeoverhaul.world.CustomSurfaceBuilders;
import valoeghese.biomeoverhaul.world.layer.BiomeLayersFunctions;

public class TheBiomeOverhaul implements ModInitializer
{
	private static Logger logger = LogManager.getLogger("TheBiomeOverhaul");
	
	public static final int PLAINS = Registry.BIOME.getRawId(Biomes.PLAINS);
	public static final int FOREST = Registry.BIOME.getRawId(Biomes.FOREST);

	public static Logger getLogger()
	{
		return logger;
	}

	@Override
	public void onInitialize()
	{
		//Initialize
		CustomSurfaceBuilders.init();
		ModBiomes.init();

		//Biome Modifiers
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (random.nextInt(8) > 0)
					if (biome == Registry.BIOME.getRawId(Biomes.TAIGA) || biome == Registry.BIOME.getRawId(Biomes.TAIGA_HILLS) || biome == Registry.BIOME.getRawId(Biomes.TAIGA_MOUNTAINS))
					{
						OpenSimplexNoise noise = BiomeLayersFunctions.NOISE_GENERATION_CATEGORY_A;
						double eval = 0.82D*noise.eval(this.int_1 / 10D, this.int_2 / 10D) + 0.18D*noise.eval(this.int_1 / 6.5D, this.int_2 / 6.5D, 1D);

						if (eval > 0.37D)
						{
							if (hills)
							{
								biome_1 = mutation ? Registry.BIOME.getRawId(Biomes.GIANT_SPRUCE_TAIGA_HILLS) : Registry.BIOME.getRawId(Biomes.GIANT_TREE_TAIGA_HILLS);
							}
							else
							{
								biome_1 = mutation ? Registry.BIOME.getRawId(Biomes.GIANT_SPRUCE_TAIGA) : Registry.BIOME.getRawId(Biomes.GIANT_TREE_TAIGA);
							}
						}
					}

				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {
			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.BADLANDS))
				{
					if (random.nextInt(8) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.ERODED_BADLANDS);
				}
				else if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU))
				{
					if (random.nextInt(4) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.BADLANDS);
					if (random.nextInt(4) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.WOODED_BADLANDS_PLATEAU);
				}
				else if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.MODIFIED_BADLANDS_PLATEAU))
				{
					if (random.nextInt(4) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU);
				}
				else if (unmodifiedBiome == Registry.BIOME.getRawId(ModBiomes.OUTBACK))
				{
					if (random.nextInt(75) == 0) biome_1 = Registry.BIOME.getRawId(ModBiomes.OUTBACK_ULURU);
				};
				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				boolean alter = random.nextInt(5) == 0;

				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.JUNGLE))
				{
					if (alter) biome_1 = Registry.BIOME.getRawId(Biomes.BAMBOO_JUNGLE);
				};
				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.JUNGLE_HILLS))
				{
					if (alter) biome_1 = Registry.BIOME.getRawId(Biomes.BAMBOO_JUNGLE_HILLS);
				};

				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				boolean alter = random.nextInt(10) == 0;

				if (unmodifiedBiome == Registry.BIOME.getRawId(ModBiomes.FEN))
				{
					if (alter) biome_1 = Registry.BIOME.getRawId(ModBiomes.FORESTED_FEN);
				};

				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (biome == Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS))
				{
					if (random.nextInt(8) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.BAMBOO_JUNGLE);
				};

				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (OceanManipulation.isShallowOceanBiome(biome))
				{
					if (random.nextInt(100) == 0)
					{
						biome_1 = Registry.BIOME.getRawId(Biomes.MUSHROOM_FIELDS);
					}
				}
				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (biome == Registry.BIOME.getRawId(Biomes.DESERT_LAKES))
				{
					if (random.nextInt(30) == 0)
					{
						biome_1 = Registry.BIOME.getRawId(ModBiomes.OASIS);
					}
				}
				else if (biome == Registry.BIOME.getRawId(ModBiomes.WOODED_MOUNTAIN_PEAKS))
				{
					if (random.nextInt(30) == 0)
					{
						biome_1 = Registry.BIOME.getRawId(ModBiomes.MOUNTAIN_PEAKS);
					}
				}
				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		BiomeModifiers.INSTANCE.add(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (biome == Registry.BIOME.getRawId(Biomes.DESERT))
				{
					if (random.nextInt(50) == 0)
					{
						biome_1 = Registry.BIOME.getRawId(ModBiomes.OASIS);
					}
				}
				return biome_1;
			}

		}, GenerationEventHandler.ModifierPriority.STANDARD);
		
		Biomes.GIANT_TREE_TAIGA.addStructureFeature(Feature.WOODLAND_MANSION, FeatureConfig.DEFAULT);

		A.b(new Random());
	}
}
