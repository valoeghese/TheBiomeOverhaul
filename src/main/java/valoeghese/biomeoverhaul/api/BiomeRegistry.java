package valoeghese.biomeoverhaul.api;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeRegistry
{
	//Mostly just to initialise MC biomes before custom biomes
	public static final Biome defaultBiome = Biomes.PLAINS;
	
	public static Biome register(Biome biome, String ID)
	{
		
		Registry.register(Registry.BIOME, ID, biome);
		
		if (biome.hasParent())
		{
			Biome.PARENT_BIOME_ID_MAP.set(biome, Registry.BIOME.getRawId(Registry.BIOME.get(new Identifier(biome.getParent()))));
		}
		
		return biome;
	}
	
	public static boolean isIdTaken(int id)
	{
		return !(Registry.BIOME.get(id) == null);
	}
}
