package valoeghese.biomeoverhaul.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.AddEdgeBiomesLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import valoeghese.biomeoverhaul.ModBiomes;
import valoeghese.biomeoverhaul.api.modifier.BiomeShores;
import valoeghese.biomeoverhaul.util.OceanManipulation;
import valoeghese.biomeoverhaul.util.math.Tuple;

@Mixin(AddEdgeBiomesLayer.class)
public class ShoreMixin
{
	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void addSample(LayerRandomnessSource rand, int int_1, int int_2, int int_3, int int_4, int int_5,
			CallbackInfoReturnable<Integer> info)
	{
		
		List<Tuple<Integer, Integer>> shoreSet = BiomeShores.getShoreSet();
		
		if (int_5 == Registry.BIOME.getRawId(ModBiomes.TROPICAL_ISLAND))
		{
	         if (isShoreToGenerate(int_1, int_2, int_3, int_4))
	         {
	            info.setReturnValue(Registry.BIOME.getRawId(ModBiomes.TROPICAL_ISLAND_SHORE));
	         }
		}
		
		for (Tuple<Integer, Integer> pair : shoreSet)
		{
			if (int_5 == pair.getA())
			{
				if (isShoreToGenerate(int_1, int_2, int_3, int_4))
				{
					info.setReturnValue(pair.getB());
					break;
				}
			}
		}
		
	}

	private boolean isShoreToGenerate(int int_1, int int_2, int int_3, int int_4)
	{
		return OceanManipulation.isOceanBiome(int_1) || OceanManipulation.isOceanBiome(int_2) || OceanManipulation.isOceanBiome(int_3) || OceanManipulation.isOceanBiome(int_4);
	}
}
