package valoeghese.biomeoverhaul.api.layer;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.world.layer.Categories;

public class Layer
{
	private final Biome biome;
	private final Biome biomemut;
	private final Biome hill;
	private final Biome hillmut;
	
	public List<GenerationCategory> categories = new ArrayList<GenerationCategory>();
	
	public Layer(Biome biome)
	{
		this(biome, biome, biome, biome);
	}
	public Layer(Biome biome, Biome hill)
	{
		this(biome, hill, biome, hill);
	}

	public Layer(Biome biome, Biome hill, Biome biomeMut, Biome hillMut)
	{
		this.biome = biome;
		this.hill = hill;
		this.biomemut = biomeMut;
		this.hillmut = hillMut;
	}
	
	public Layer withCategories(GenerationCategory...categories)
	{
		for (GenerationCategory c : categories)
		{
			this.categories.add(c);
			Categories.getListForCategory(c).add(this);
		}
		
		return this;
	}
	
	public int biome()
	{
		return idOf(biome);
	}
	public int hills()
	{
		return idOf(hill);
	}
	public int mut()
	{
		return idOf(biomemut);
	}
	public int hillsmut()
	{
		return idOf(hillmut);
	}
	
	private int idOf(Biome b)
	{
		return Registry.BIOME.getRawId(b);
	}
}
