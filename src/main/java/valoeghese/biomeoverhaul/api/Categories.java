package valoeghese.biomeoverhaul.api;

import java.util.ArrayList;
import java.util.List;

import valoeghese.biomeoverhaul.world.layer.GenerationCategory;

public class Categories {
	public static final List<Layer> bDEFAULT = new ArrayList<>();

	public static final List<Layer> bMOUNTAIN = new ArrayList<>();
	public static final List<Layer> bISLAND = new ArrayList<>();
	public static final List<Layer> bMEDITERRANEAN = new ArrayList<>();
	public static final List<Layer> bBOREAL = new ArrayList<>();
	
	public static List<Layer> getListForCategory(GenerationCategory category)
	{
		switch(category)
		{
		case ISLAND:
			return bISLAND;
		case MEDITERRANEAN:
			return bMEDITERRANEAN;
		case MOUNTAIN:
			return bMOUNTAIN;
		case BOREAL:
			return bBOREAL;
		default:
			return bDEFAULT;
		}
	}
}
