package valoeghese.biomeoverhaul.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.layer.AddHillsLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.biome.layer.LayerSampler;
import valoeghese.biomeoverhaul.api.BiomeLayersRevamped;
import valoeghese.biomeoverhaul.api.BiomeModifier;
import valoeghese.biomeoverhaul.api.enums.BiomeHumidity;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.api.layer.Layer;
import valoeghese.biomeoverhaul.api.modifier.BiomeModifiers;
import valoeghese.biomeoverhaul.api.testing.SoloBiome;
import valoeghese.biomeoverhaul.api.testing.TestModule;
import valoeghese.biomeoverhaul.api.testing.TestModuleApplier;
import valoeghese.biomeoverhaul.util.math.MathUtils;
import valoeghese.biomeoverhaul.world.layer.BiomeLayersFunctions;

@Mixin(value = AddHillsLayer.class)
public class BiomesMixin
{

	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void addSample(LayerRandomnessSource rand, LayerSampler sampler_1, LayerSampler sampler_2, int x, int z,
			CallbackInfoReturnable<Integer> info)
	{
		int int_3;
		
		if (SoloBiome.isActive())
			int_3 = SoloBiome.getBiome();
		else
			int_3 = this.coreSample(rand, sampler_1, sampler_2, x, z);
		
		info.setReturnValue(int_3);
	}

	public int coreSample(LayerRandomnessSource rand, LayerSampler sampler_1, LayerSampler sampler_2, int x, int z)
	{
		BiomeLayersFunctions.initNoise(MathUtils.fastFloor(3218731280712L * rand.getNoiseSampler().originX + 64207987541L * rand.getNoiseSampler().originZ), rand.getNoiseSampler().originZ);

		//Get possible applied test modules
		TestModule moduleInUse = TestModuleApplier.getModule();
		int temp = BiomeLayersFunctions.getTemperatureAtPos(x, z);
		
		Layer layer;
		
		if (!moduleInUse.isEnabled())
		{
			//Get further information of biome gen at position
			BiomeHumidity humidity = BiomeLayersFunctions.getHumidityAtPos(x, z, rand);
			
			double oceanNoise = BiomeLayersFunctions.oceanNoise(x, z);
			boolean isOceanBiome = BiomeLayersFunctions.isOcean(oceanNoise);

			GenerationCategory category = BiomeLayersFunctions.getCategoryAtPos(x, z, oceanNoise, temp);

			//Test for ocean first
			if (isOceanBiome)
			{
				layer = BiomeLayersFunctions.addOcean(temp, category == GenerationCategory.ISLAND, rand, BiomeLayersFunctions.getListForClimate(temp, humidity), oceanNoise);
			}
			else
			{
				List<Layer> biomes = BiomeLayersFunctions.getListForClimateCategory(temp, humidity, category, x, z, oceanNoise);
				
				if (BiomeLayersFunctions.isSwamp(x, z))
					biomes = BiomeLayersFunctions.addSwamp(temp, biomes);
				
				if (BiomeLayersFunctions.isBadlands(temp, x, z))
					biomes = BiomeLayersRevamped.mesaFeatureList;
				
				layer = (Layer) biomes.toArray()[rand.nextInt(biomes.size())];
			}
		}
		else
		{
			layer = moduleInUse.getTestBiomeLayer(rand, x, z);
		}
		
		double hillsNoise = BiomeLayersFunctions.hills(x, z);
		double mutationNoise = BiomeLayersFunctions.mutation(x, z);

		if (hillsNoise > 0.54D || hillsNoise < -0.54D)
		{
			if (mutationNoise > 0.55 || rand.nextInt(16) == 0) return this.returnBiome(layer.hillmut, rand, temp, true, true, x, z);
			else return this.returnBiome(layer.hill, rand, temp, false, true, x, z);
		}
		else
		{
			if (mutationNoise > 0.5 || rand.nextInt(16) == 0) return this.returnBiome(layer.biomemut, rand, temp, true, false, x, z);
			else return this.returnBiome(layer.biome, rand, temp, false, false, x, z);
		}
	}

	private int returnBiome(int biome, LayerRandomnessSource rand, int temperature, boolean mutation, boolean hills, int x, int z)
	{
		int moddedBiome = biome;
		
		if (!TestModuleApplier.areModifiersEnabled()) return biome;
		
		for (BiomeModifier b : BiomeModifiers.initial_modifiers)
		{
			moddedBiome = b.setInts(x, z).apply(rand, moddedBiome, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
		for (BiomeModifier b : BiomeModifiers.standard_modifiers)
		{
			moddedBiome = b.setInts(x, z).apply(rand, moddedBiome, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
		for (BiomeModifier b : BiomeModifiers.final_modifiers)
		{
			moddedBiome = b.setInts(x, z).apply(rand, moddedBiome, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}

		return moddedBiome;
	}
}
