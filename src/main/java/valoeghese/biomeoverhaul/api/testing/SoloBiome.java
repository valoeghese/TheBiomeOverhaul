package valoeghese.biomeoverhaul.api.testing;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class SoloBiome
{
	private static boolean isActive = false;
	private static int biome = Registry.BIOME.getRawId(Biomes.PLAINS);
	
	public static void setSingleBiome(boolean active)
	{
		isActive = active;
	}
	
	public static void setBiome(Biome soloBiome)
	{
		biome = Registry.BIOME.getRawId(soloBiome);
	}
	
	public static int getBiome() 
	{
		return biome;
	}

	public static boolean isActive()
	{
		return isActive;
	}
}
