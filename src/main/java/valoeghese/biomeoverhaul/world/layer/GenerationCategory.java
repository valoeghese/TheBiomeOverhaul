package valoeghese.biomeoverhaul.world.layer;

public enum GenerationCategory
{
	/**
	 * The default generation. Likely to be replaced in a future update with FOREST, SPARSE, etc.
	 */
	DEFAULT,
	/**
	 * Mountain ranges that generate on a two-octave noise basis
	 */
	MOUNTAIN,
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
	BOREAL;
}
