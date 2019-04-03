package valoeghese.biomeoverhaul;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import valoeghese.biomeoverhaul.api.BiomeModifier;
import valoeghese.biomeoverhaul.util.OceanManipulation;
import valoeghese.biomeoverhaul.util.noise.OpenSimplexNoise;
import valoeghese.biomeoverhaul.world.layer.BiomeLayersFunctions;

public class Main implements ModInitializer
{

	@Override
	public void onInitialize()
	{

		System.out.println("TheBiomeOverhaul has been enabled!");

		ModBiomes.injectBiomes();

		//Biome Modifiers
		BiomeModifier.addBiomeModifier(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;
				
				if (random.nextInt(8) > 0)
				if (biome == Registry.BIOME.getRawId(Biomes.TAIGA) || biome == Registry.BIOME.getRawId(Biomes.TAIGA_HILLS) || biome == Registry.BIOME.getRawId(Biomes.TAIGA_MOUNTAINS))
				{
					OpenSimplexNoise noise = BiomeLayersFunctions.NOISE_GENERATION_CATEGORY;
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

		}, BiomeModifier.ModifierPriority.STANDARD);
		BiomeModifier.addBiomeModifier(new BiomeModifier() {
			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.BADLANDS))
				{
					if (random.nextInt(8) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.ERODED_BADLANDS);
				};
				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU))
				{
					if (random.nextInt(4) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.BADLANDS);
					if (random.nextInt(4) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.WOODED_BADLANDS_PLATEAU);
				};
				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.MODIFIED_BADLANDS_PLATEAU))
				{
					if (random.nextInt(4) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU);
				};

				return biome_1;
			}

		}, BiomeModifier.ModifierPriority.STANDARD);
		BiomeModifier.addBiomeModifier(new BiomeModifier() {

			@Override
			public int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature,
					boolean mutation, boolean hills) {

				int biome_1 = biome;

				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.JUNGLE))
				{
					if (random.nextInt(5) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.BAMBOO_JUNGLE);
				};
				if (unmodifiedBiome == Registry.BIOME.getRawId(Biomes.JUNGLE_HILLS))
				{
					if (random.nextInt(5) == 0) biome_1 = Registry.BIOME.getRawId(Biomes.BAMBOO_JUNGLE_HILLS);
				};

				return biome_1;
			}

		}, BiomeModifier.ModifierPriority.STANDARD);
		BiomeModifier.addBiomeModifier(new BiomeModifier() {

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

		}, BiomeModifier.ModifierPriority.STANDARD);
	}
}
