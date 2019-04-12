package valoeghese.biomeoverhaul.api.layer;


import java.util.ArrayList;
import java.util.List;

import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.world.layer.Categories;

public class Layer
{
	public final int biome;
	public final int biomemut;
	public final int hill;
	public final int hillmut;
	
	public List<GenerationCategory> categories = new ArrayList<GenerationCategory>();
	
	public Layer(int biomeID)
	{
		this(biomeID, biomeID, biomeID, biomeID);
	}
	public Layer(int biomeID, int hillID)
	{
		this(biomeID, hillID, biomeID, hillID);
	}

	public Layer(int biomeID, int hillID, int biomeMutID, int hillMutID)
	{
		this.biome = biomeID;
		this.hill = hillID;
		this.biomemut = biomeMutID;
		this.hillmut = hillMutID;
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
}
