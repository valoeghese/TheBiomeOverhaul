package valoeghese.biomeoverhaul.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import valoeghese.biomeoverhaul.api.SpawnBiomes;

@Mixin(BiomeSource.class)
public class SpawnBiomesMixin 
{
	@Shadow
	@Final
	private static List<Biome> SPAWN_BIOMES;
	
	@Inject(at = @At("HEAD"), cancellable = true, method = "getSpawnBiomes")
	private void getSpawnBiomes(CallbackInfoReturnable<List<Biome>> info)
	{
		List<Biome> toReturn = new ArrayList<>();
		for (Biome biome : SPAWN_BIOMES)
			toReturn.add(biome);
		for (Biome biome : SpawnBiomes.getModdedSpawnBiomes())
			if (!toReturn.contains(biome))
				toReturn.add(biome);
		
		info.setReturnValue(toReturn);
	}
}
