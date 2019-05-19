package valoeghese.biomeoverhaul.api.enums;

public enum GenerationCategory
{
	/**
	 * The default generation. Denotes plains-style biomes.
	 */
	PLAINS,
	/**
	 * Mountain ranges that generate on a two-octave noise basis
	 */
	MOUNTAIN,
	/**
	 * Edges of a mountain range
	 */
	FOOTHILLS,
	/**
	 * Islands in the sea. None of the current default biomes use this, but it generates similarly to MOUNTAIN
	 */
	ISLAND,
	/**
	 * Only in temperate (2) climate. Meditteranean region.
	 */
	MEDITERRANEAN,
	/**
	 * In cool (1) and frozen (0) climates. "Boreal" style region. I'm mostly referring to colder sub-arctic regions by this.
	 */
	BOREAL,
	/**
	 * Woodland and Forest style generation
	 */
	WOODLAND,
	/**
	 * Rainforest areas
	 */
	RAINFOREST,
	/**
	 *  Meadow areas (Untested)
	 */
	MEADOW,
	/**
	 *  Badlands areas.
	 */
	BADLANDS,
	/**
	 *  Bluff generation: cliffs by the sea.
	 */
	BLUFF,
	/**
	 * Forested areas with large canopy trees
	 */
	CANOPY,
	/**
	 * Estuary
	 */
	ESTUARY;
}
