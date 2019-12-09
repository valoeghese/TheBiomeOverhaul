package valoeghese.biomeoverhaul.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.AddRiversLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.biome.layer.util.LayerSampler;
import valoeghese.biomeoverhaul.util.OceanManipulation;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.RiverType;
import valoeghese.biomeoverhaul.world.biome.TBOBiome;

@Mixin(AddRiversLayer.class)
public class RiverMixin
{
	
	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource rand, LayerSampler biomes, LayerSampler noise, int int_1, int int_2,
			CallbackInfoReturnable<Integer> info)
	{
		int biome_id = biomes.sample(int_1, int_2);
		Biome biome = Registry.BIOME.get(biome_id);
		
		if (biome instanceof TBOBiome && noise.sample(int_1, int_2) == OceanManipulation.RIVER_ID)
		{
			RiverType riverType = ((TBOBiome) biome).theBiomeFactory.getRiverType();
			
			if (riverType == RiverType.NONE)
				info.setReturnValue(biome_id);
			else if (riverType == RiverType.ICY)
				info.setReturnValue(OceanManipulation.FROZEN_RIVER_ID);
		}
	}
}
