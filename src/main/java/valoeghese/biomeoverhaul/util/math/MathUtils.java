package valoeghese.biomeoverhaul.util.math;

public class MathUtils
{
	/**
	 * MathHelper.fastFloor, but for all sides: both client and server
	 * 
	 * @param double_1
	 * @return int, floor
	 */
	public static int fastFloor(double double_1)
	{
		return (int)(double_1 + 1024.0D) - 1024;
	}
}
