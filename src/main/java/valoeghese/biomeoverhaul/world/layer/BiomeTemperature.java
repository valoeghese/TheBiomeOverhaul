package valoeghese.biomeoverhaul.world.layer;

public enum BiomeTemperature
{
	FROZEN(0),
	COOL(1),
	TEMPERATE(2),
	TROPICAL(3),
	DESERT(4);
	
	private final int id;
	
	private BiomeTemperature(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
}
