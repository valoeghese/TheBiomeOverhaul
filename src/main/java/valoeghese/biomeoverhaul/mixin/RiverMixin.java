package valoeghese.biomeoverhaul.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.AddRiversLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.biome.layer.LayerSampler;
import valoeghese.biomeoverhaul.util.OceanManipulation;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.RiverType;
import valoeghese.biomeoverhaul.world.biome.TBOBiome;

@Mixin(AddRiversLayer.class)
public class RiverMixin
{
	
	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource rand, LayerSampler sampler_1, LayerSampler sampler_2, int x, int z,
			CallbackInfoReturnable<Integer> info)
	{
		int biome_id = sampler_1.sample(x, z);
		Biome biome = Registry.BIOME.get(biome_id);
		
		if (biome instanceof TBOBiome)
		{
			RiverType riverType = ((TBOBiome) biome).theBiomeFactory.getRiverType();
			
			if (riverType == RiverType.NONE)
				info.setReturnValue(biome_id);
			else if (riverType == RiverType.ICY)
				info.setReturnValue(OceanManipulation.FROZEN_RIVER_ID);
		}
	}
}
