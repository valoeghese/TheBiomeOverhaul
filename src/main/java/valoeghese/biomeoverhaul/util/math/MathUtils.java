package valoeghese.biomeoverhaul.util.math;

public class MathUtils
{
	/**
	 * MathHelper.fastFloor, but for all sides: both client and server
	 * 
	 * @param input
	 * @return int, floor
	 */
	public static int fastFloor(double input)
	{
		return (int)(input + 1024.0D) - 1024;
	}
}
