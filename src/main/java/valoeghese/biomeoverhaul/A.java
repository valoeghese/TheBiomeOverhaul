package valoeghese.biomeoverhaul;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class A
{
	private static final List<String> a, b;
	
	static
	{
		a = Arrays.asList(
				"TheBiomeOverhaul has been initialised!",
				"Deleting 1.12...",
				"Also try Lil' Tater!",
				"The first fabric biomes mod :)",
				"TheBiomeOverhaul has been enabled!"
		);
		
		b = Arrays.asList(
				"*hugs tree*",
				"Deleting TheBiomeUnderhaul...",
				"Not TheBiomeUnderhaul!",
				"smaller > bigger - asie"
		);
	}
	
	public static void b(Random d)
	{
		TheBiomeOverhaul.getLogger().info("[TheBiomeOverhaul] " + c(d));
	}
	
	private static String c(Random d)
	{
		return d.nextInt(10) == 0 ? b.get(d.nextInt(b.size())) : a.get(d.nextInt(a.size()));
	}
}
