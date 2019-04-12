package valoeghese.biomeoverhaul.api;

import net.minecraft.world.biome.layer.LayerRandomnessSource;

public abstract class BiomeModifier
{
	
	/**
	 * Cast to double, from int. These should be set before apply() and cancel() are called.
	 */
	protected double int_1, int_2;
	
	public boolean cancel()
	{
		return false;
	}
	
	public BiomeModifier setInts(int int_1, int int_2)
	{
		this.int_1 = int_1;
		this.int_2 = int_2;
		
		return this;
	}
	
	/**
	 * 
	 * @param random Minecraft layer randomness, provided by the biome generation code
	 * @param biome The biome that would otherwise be returned
	 * @param unmodifiedBiome The biome, unmodified by other BiomeModifiers
	 * @param temperature
	 * @param mutation
	 * @return Biome to generate at chunk. If the function does not modify the biome, it will return the "biome" parameter.
	 */
	public abstract int apply(LayerRandomnessSource random, int biome, int unmodifiedBiome, int temperature, boolean mutation, boolean hills);
}
