package valoeghese.biomeoverhaul.api;

import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public abstract class BiomeModifier
{
	
	/**
	 * Cast to double, from int. These should be set before apply() and cancel() are called.
	 */
	protected double scaled_X, scaled_Z;
	
	public boolean cancel()
	{
		return false;
	}
	
	public BiomeModifier setScaledLocationCoordinates(int int_1, int int_2)
	{
		this.scaled_X = int_1;
		this.scaled_Z = int_2;
		
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
