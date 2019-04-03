package valoeghese.biomeoverhaul.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.biome.layer.LayerRandomnessSource;

public abstract class BiomeModifier
{
	public static enum ModifierPriority
	{
		HIGH, STANDARD, LOW;
	}
	
	public static final List<BiomeModifier> initial_modifiers = new ArrayList<BiomeModifier>();
	public static final List<BiomeModifier> standard_modifiers = new ArrayList<BiomeModifier>();
	public static final List<BiomeModifier> final_modifiers = new ArrayList<BiomeModifier>();
	
	/**
	 * Cast to double, from int. These should be set before apply() and cancel() are called.
	 */
	protected double int_1, int_2;
	
	public static void addBiomeModifier(BiomeModifier modifier, ModifierPriority priority)
	{
		switch(priority)
		{
		case HIGH:
			initial_modifiers.add(modifier);
		case STANDARD:
			standard_modifiers.add(modifier);
		case LOW:
			final_modifiers.add(modifier);
		}
	}
	
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
