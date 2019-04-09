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
import valoeghese.biomeoverhaul.api.Layer;
import valoeghese.biomeoverhaul.api.enums.BiomeHumidity;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.util.math.MathUtils;
import valoeghese.biomeoverhaul.world.layer.BiomeLayersFunctions;

@Mixin(value = AddHillsLayer.class)
public class BiomesMixin
{

	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void addSample(LayerRandomnessSource layerRandomnessSource_1, LayerSampler layerSampler_1, LayerSampler layerSampler_2, int int_1, int int_2,
			CallbackInfoReturnable<Integer> info)
	{
		int int_3 = this.coreSample(layerRandomnessSource_1, layerSampler_1, layerSampler_2, int_1, int_2);
		
		info.setReturnValue(int_3);
	}

	public int coreSample(LayerRandomnessSource rand, LayerSampler layerSampler_1, LayerSampler layerSampler_2, int int_1, int int_2)
	{
		BiomeLayersFunctions.initNoise(MathUtils.fastFloor(3218731280712L * rand.getNoiseSampler().originX + 64207987541L * rand.getNoiseSampler().originZ), rand.getNoiseSampler().originZ);
		
		//Get information of biome gen at position
		int temp = BiomeLayersFunctions.getTemperatureAtPos(int_1, int_2);
		BiomeHumidity humidity = BiomeLayersFunctions.getHumidityAtPos(int_1, int_2, rand);
		
		boolean isOceanBiome = BiomeLayersFunctions.isOcean(int_1, int_2);
		
		GenerationCategory category = BiomeLayersFunctions.getCategoryAtPos(int_1, int_2, isOceanBiome, temp);
		
		Layer layer;
		
		//Test for ocean first
		if (isOceanBiome)
		{
			layer = BiomeLayersFunctions.addOcean(temp);
		}
		else
		{
			List<Layer> biomes = BiomeLayersFunctions.getListForClimateCategory(temp, humidity, category);

			if (BiomeLayersFunctions.isSwamp(int_1, int_2))
				biomes = BiomeLayersFunctions.addSwamp(temp, biomes, rand);
			
			if (BiomeLayersFunctions.isBadlands(temp, int_1, int_2))
				biomes = BiomeLayersRevamped.mesaFeatureList;

			layer = (Layer) biomes.toArray()[rand.nextInt(biomes.size())];
		}
		
		double hillsNoise = BiomeLayersFunctions.hills(int_1, int_2);
		double mutationNoise = BiomeLayersFunctions.mutation(int_1, int_2);

		if (hillsNoise > 0.51D || hillsNoise < -0.51D)
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
		
		for (BiomeModifier b : BiomeModifier.initial_modifiers)
		{
			biome_1 = b.setInts(int_1, int_2).apply(rand, biome_1, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
		for (BiomeModifier b : BiomeModifier.standard_modifiers)
		{
			biome_1 = b.setInts(int_1, int_2).apply(rand, biome_1, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
		for (BiomeModifier b : BiomeModifier.final_modifiers)
		{
			biome_1 = b.setInts(int_1, int_2).apply(rand, biome_1, biome, temperature, mutation, hills);
			if (b.cancel()) break;
		}
			
		return biome_1;
	}
}
