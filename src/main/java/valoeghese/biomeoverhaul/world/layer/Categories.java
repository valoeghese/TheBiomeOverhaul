package valoeghese.biomeoverhaul.world.layer;

import java.util.ArrayList;
import java.util.List;

import valoeghese.biomeoverhaul.api.enums.GenerationCategory;
import valoeghese.biomeoverhaul.api.layer.Layer;

public class Categories
{
	public static final List<Layer> bPLAINS = new ArrayList<>();
	
	public static final List<Layer> bMOUNTAIN = new ArrayList<>();
	public static final List<Layer> bISLAND = new ArrayList<>();
	public static final List<Layer> bMEDITERRANEAN = new ArrayList<>();
	public static final List<Layer> bBOREAL = new ArrayList<>();
	public static final List<Layer> bWOODLAND = new ArrayList<>();
	public static final List<Layer> bRAINFOREST = new ArrayList<>();
	public static final List<Layer> bFOOTHILLS = new ArrayList<>();
	public static final List<Layer> bMEADOW = new ArrayList<>();
	public static final List<Layer> bBADLANDS = new ArrayList<>();
	public static final List<Layer> bBLUFF = new ArrayList<>();
	public static final List<Layer> bCANOPY = new ArrayList<>();
	public static final List<Layer> bESTUARY = new ArrayList<>();
	
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
		case WOODLAND:
			return bWOODLAND;
		case RAINFOREST:
			return bRAINFOREST;
		case FOOTHILLS:
			return bFOOTHILLS;
		case MEADOW:
			return bMEADOW;
		case BADLANDS:
			return bBADLANDS;
		case BLUFF:
			return bBLUFF;
		case CANOPY:
			return bCANOPY;
		case ESTUARY:
			return bESTUARY;
		default:
			return bPLAINS;
		}
	}
}
