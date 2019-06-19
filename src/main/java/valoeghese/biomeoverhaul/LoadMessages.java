package valoeghese.biomeoverhaul;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoadMessages
{
	private static final List<String> a, b, c;
	
	static
	{
		a = Arrays.asList(
				"TheBiomeOverhaul has been initialised!",
				"Deleting 1.12.2...",
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
		
		c = Arrays.asList(
				"yeet",
				"Deleting Traverse API... Permanently >:)"
		);
	}
	
	private static String e(Random d, String f)
	{
		return d.nextInt(c.size() + 1) == 0 ? "There is a 1 in " + String.valueOf((c.size() + 1) * 100) + " chance that you will see this message!" : f;
	}
	
	public static void b(Random d)
	{
		TheBiomeOverhaul.getLogger().info("[TheBiomeOverhaul] " + c(d));
	}
	
	private static String c(Random d)
	{
		return d.nextInt(10) == 0 ? ( d.nextInt(10) == 0 ? e(d, c.get(d.nextInt(c.size()))) : b.get(d.nextInt(b.size())) ) : a.get(d.nextInt(a.size()));
	}
}
