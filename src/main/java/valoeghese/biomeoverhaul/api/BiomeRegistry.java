package valoeghese.biomeoverhaul.api;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeRegistry
{
	private static int nextID = 0;
	
	//Mostly just to initialise MC biomes before custom biomes
	public static final Biome defaultBiome = Biomes.PLAINS;
	
	private static Map<String, Integer> customBiomeIDMap = new HashMap<String, Integer>();
	
	public static Biome register(Biome biome, String ID, int specifiedID)
	{
		
		customBiomeIDMap.put(ID, specifiedID);
		
		Registry.register(Registry.BIOME, specifiedID, ID, biome);
		if (biome.hasParent()) {
			Biome.PARENT_BIOME_ID_MAP.set(biome, Registry.BIOME.getRawId(Registry.BIOME.get(new Identifier(biome.getParent()))));
		}

		return biome;
	}
	
	public static Biome register(Biome biome, String ID)
	{
		int thisId = getNextId();
		
		return register(biome, ID, thisId);
	}
	
	/**
	 * 
	 * @param biome
	 * @return custom biome ID. Null if it does not exist.
	 */
	public static int getCustomBiomeID(String biomeNameID)
	{
		return customBiomeIDMap.get(biomeNameID);
	}
	private static int getNextId()
	{
		++nextID;
		while (customBiomeIDMap.containsValue(nextID) || isIdTaken(nextID)) ++nextID;
		
		return nextID;
	}
	
	private static boolean isIdTaken(int id)
	{
		return !(Registry.BIOME.get(id) == null);
	}
}
