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
import valoeghese.biomeoverhaul.compat.TraverseVanillaInjectionCompat;
import valoeghese.biomeoverhaul.util.math.MathUtils;
import valoeghese.biomeoverhaul.world.layer.BiomeLayersFunctions;

@Mixin(value = AddHillsLayer.class)
public class BiomesMixin
{
	//Is the Traverse and other vanilla-biome mod injection compat loaded
	private static boolean _isLoaded = false;
	
	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void addSample(LayerRandomnessSource layerRandomnessSource_1, LayerSampler layerSampler_1, LayerSampler layerSampler_2, int int_1, int int_2,
			CallbackInfoReturnable<Integer> info)
	{
		if (!_isLoaded)
		{
			TraverseVanillaInjectionCompat.injectModdedBiomes();
			_isLoaded = true;
		}
		
		int int_3;
		
		if (SoloBiome.isActive())
			int_3 = SoloBiome.getBiome();
		else
			int_3 = this.coreSample(layerRandomnessSource_1, layerSampler_1, layerSampler_2, int_1, int_2);
		
		info.setReturnValue(int_3);
	}

	public int coreSample(LayerRandomnessSource rand, LayerSampler layerSampler_1, LayerSampler layerSampler_2, int int_1, int int_2)
	{
		BiomeLayersFunctions.initNoise(MathUtils.fastFloor(3218731280712L * rand.getNoiseSampler().originX + 64207987541L * rand.getNoiseSampler().originZ), rand.getNoiseSampler().originZ);

		//Get possible applied test modules
		TestModule moduleInUse = TestModuleApplier.getModule();
		int temp = BiomeLayersFunctions.getTemperatureAtPos(int_1, int_2);
		
		Layer layer;
		
		if (!moduleInUse.isEnabled())
		{
			//Get further information of biome gen at position
			BiomeHumidity humidity = BiomeLayersFunctions.getHumidityAtPos(int_1, int_2, rand);
			
			double oceanNoise = BiomeLayersFunctions.oceanNoise(int_1, int_2);
			boolean isOceanBiome = BiomeLayersFunctions.isOcean(oceanNoise);

			GenerationCategory category = BiomeLayersFunctions.getCategoryAtPos(int_1, int_2, oceanNoise, temp);

			//Test for ocean first
			if (isOceanBiome)
			{
				layer = BiomeLayersFunctions.addOcean(temp, category == GenerationCategory.ISLAND, rand, BiomeLayersFunctions.getListForClimate(temp, humidity), oceanNoise);
			}
			else
			{
				List<Layer> biomes = BiomeLayersFunctions.getListForClimateCategory(temp, humidity, category, int_1, int_2, oceanNoise);
				
				if (BiomeLayersFunctions.isSwamp(int_1, int_2))
					biomes = BiomeLayersFunctions.addSwamp(temp, biomes);
				
				if (BiomeLayersFunctions.isBadlands(temp, int_1, int_2))
					biomes = BiomeLayersRevamped.mesaFeatureList;
				
				layer = (Layer) biomes.toArray()[rand.nextInt(biomes.size())];
			}
		}
		else
		{
			layer = moduleInUse.getTestBiomeLayer(rand, int_1, int_2);
		}
		
		double hillsNoise = BiomeLayersFunctions.hills(int_1, int_2);
		double mutationNoise = BiomeLayersFunctions.mutation(int_1, int_2);

		if (hillsNoise > 0.54D || hillsNoise < -0.54D)
		{
			if (mutationNoise > 0.55 || rand.nextInt(16) == 0) return this.returnBiome(layer.hillmut, rand, temp, true, true, int_1, int_2);
			else return this.returnBiome(layer.hill, rand, temp, false, true, int_1, int_2);
		}
		else
		{
			if (mutationNoise > 0.5 || rand.nextInt(16) == 0) return this.returnBiome(layer.biomemut, rand, temp, true, false, int_1, int_2);
			else return this.returnBiome(layer.biome, rand, temp, false, false, int_1, int_2);
		}
	}

	private int returnBiome(int biome, LayerRandomnessSource rand, int temperature, boolean mutation, boolean hills, int int_1, int int_2)
	{
		int biome_1 = biome;
		
		if (!TestModuleApplier.areModifiersEnabled()) return biome;
		
		for (BiomeModifier b : BiomeModifiers.initial_modifiers)
		{
			biome_1 = b.setScaledLocationCoordinates(int_1, int_2).apply(rand, biome_1, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
		for (BiomeModifier b : BiomeModifiers.standard_modifiers)
		{
			biome_1 = b.setScaledLocationCoordinates(int_1, int_2).apply(rand, biome_1, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
		for (BiomeModifier b : BiomeModifiers.final_modifiers)
		{
			biome_1 = b.setScaledLocationCoordinates(int_1, int_2).apply(rand, biome_1, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}

		return biome_1;
	}
}
