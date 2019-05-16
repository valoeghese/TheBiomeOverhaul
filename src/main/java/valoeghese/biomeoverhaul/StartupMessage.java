package valoeghese.biomeoverhaul;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartupMessage
{
	private static final List<String> commonLogs, rareLogs;
	
	static
	{
		commonLogs = Arrays.asList(
				"TheBiomeOverhaul has been initialised!",
				"Deleting 1.12...",
				"Also try Lil' Tater!",
				"The first fabric biomes mod :)",
				"TheBiomeOverhaul has been enabled!"
		);
		
		rareLogs = Arrays.asList(
				"*hugs tree*",
				"Deleting TheBiomeUnderhaul...",
				"Not TheBiomeUnderhaul!",
				"smaller > bigger - asie"
		);
	}
	
	public static void printMessage(Random rand)
	{
		TheBiomeOverhaul.getLogger().info("[TheBiomeOverhaul] " + genMessage(rand));
	}
	
	private static String genMessage(Random rand)
	{
		return rand.nextInt(10) == 0 ? rareLogs.get(rand.nextInt(rareLogs.size())) : commonLogs.get(rand.nextInt(commonLogs.size()));
	}
}
