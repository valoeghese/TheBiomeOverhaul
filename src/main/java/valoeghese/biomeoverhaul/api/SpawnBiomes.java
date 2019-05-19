package valoeghese.biomeoverhaul.api;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.world.biome.Biome;

public class SpawnBiomes
{
	private static final Set<Biome> SPAWN_BIOMES = new HashSet<>();
	
	public static Set<Biome> getModdedSpawnBiomes()
	{
		return SPAWN_BIOMES;
	}
	
	public static Biome addSpawnBiomes(Biome biome, Biome...otherBiomes)
	{
		SPAWN_BIOMES.add(biome);
		for (Biome b : otherBiomes)
			SPAWN_BIOMES.add(b);
		
		return biome;
	}
}
