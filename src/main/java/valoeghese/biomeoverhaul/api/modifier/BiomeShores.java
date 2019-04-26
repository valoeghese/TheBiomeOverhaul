package valoeghese.biomeoverhaul.api.modifier;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.util.math.Tuple;

public class BiomeShores
{
	private static List<Tuple<Integer, Integer>> set = new ArrayList<>();
	
	/**
	 * Make sure the biomes are registered first!
	 * @param biome
	 * @param shore
	 */
	public static void setBiomeShore(Biome biome, int shore_id)
	{
		set.add(new Tuple<Integer, Integer>(Registry.BIOME.getRawId(biome), shore_id));
	}
	
	public static List<Tuple<Integer, Integer>> getShoreSet()
	{
		return set;
	}
}
