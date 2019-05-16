package valoeghese.biomeoverhaul.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.layer.ApplyOceanTemperatureLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.biome.layer.LayerSampler;
import valoeghese.biomeoverhaul.util.OceanManipulation;

@Mixin(ApplyOceanTemperatureLayer.class)
public class OceanTemperatureMixin
{

	@Inject(at = @At(value = "HEAD"), method = "sample", cancellable = true)
	private void addSample(LayerRandomnessSource rand, LayerSampler sampler_1, LayerSampler sampler_2, int x, int z,
			CallbackInfoReturnable<Integer> info)
	{
		int biome = sampler_1.sample(ApplyOceanTemperatureLayer.INSTANCE.transformX(x), ApplyOceanTemperatureLayer.INSTANCE.transformZ(z));

		int[] samples = new int[4];

		if (isShallowOceanBiome(biome))
		{
			samples[0] = sampler_1.sample(ApplyOceanTemperatureLayer.INSTANCE.transformX(x + 1), ApplyOceanTemperatureLayer.INSTANCE.transformZ(z));
			samples[1] = sampler_1.sample(ApplyOceanTemperatureLayer.INSTANCE.transformX(x), ApplyOceanTemperatureLayer.INSTANCE.transformZ(z + 1));
			samples[2] = sampler_1.sample(ApplyOceanTemperatureLayer.INSTANCE.transformX(x - 1), ApplyOceanTemperatureLayer.INSTANCE.transformZ(z));
			samples[3] = sampler_1.sample(ApplyOceanTemperatureLayer.INSTANCE.transformX(x), ApplyOceanTemperatureLayer.INSTANCE.transformZ(z - 1));

			int counter = 0;

			for (int i : samples)
			{
				if (isShallowOceanBiome(i))
				{
					++counter;
				}
			}

			if (counter > 3)
			{
				if (rand.nextInt(10) == 0)
				{
					if (biome == WARM_OCEAN_ID)
					{
						biome = DEEP_WARM_OCEAN_ID;
					}
					else if (biome == LUKEWARM_OCEAN_ID)
					{
						biome = DEEP_LUKEWARM_OCEAN_ID;
					}
					else if (biome == OCEAN_ID)
					{
						biome = DEEP_OCEAN_ID;
					}
					else if (biome == FROZEN_OCEAN_ID)
					{
						biome = DEEP_FROZEN_OCEAN_ID;
					}
					else if (biome == COLD_OCEAN_ID)
					{
						biome = DEEP_COLD_OCEAN_ID;
					}
				}
			}
		}
		info.setReturnValue(biome);
	}

	private static boolean isShallowOceanBiome(int int_1) {
		return int_1 == WARM_OCEAN_ID || int_1 == LUKEWARM_OCEAN_ID || int_1 == OCEAN_ID || int_1 == COLD_OCEAN_ID || int_1 == FROZEN_OCEAN_ID;
	}
	
	private static final int WARM_OCEAN_ID = OceanManipulation.WARM_OCEAN_ID;
	private static final int LUKEWARM_OCEAN_ID = OceanManipulation.LUKEWARM_OCEAN_ID;;
	private static final int OCEAN_ID = OceanManipulation.OCEAN_ID;;
	private static final int COLD_OCEAN_ID = OceanManipulation.COLD_OCEAN_ID;;
	private static final int FROZEN_OCEAN_ID = OceanManipulation.FROZEN_OCEAN_ID;;
	private static final int DEEP_WARM_OCEAN_ID = OceanManipulation.DEEP_WARM_OCEAN_ID;;
	private static final int DEEP_LUKEWARM_OCEAN_ID = OceanManipulation.DEEP_LUKEWARM_OCEAN_ID;;
	private static final int DEEP_OCEAN_ID = OceanManipulation.DEEP_OCEAN_ID;;
	private static final int DEEP_COLD_OCEAN_ID = OceanManipulation.DEEP_COLD_OCEAN_ID;;
	private static final int DEEP_FROZEN_OCEAN_ID = OceanManipulation.DEEP_FROZEN_OCEAN_ID;;
}
