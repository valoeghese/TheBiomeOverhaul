package valoeghese.biomeoverhaul.util;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;

public class OceanManipulation
{
	public static final int WARM_OCEAN_ID;
	public static final int LUKEWARM_OCEAN_ID;
	public static final int OCEAN_ID;
	public static final int COLD_OCEAN_ID;
	public static final int FROZEN_OCEAN_ID;
	public static final int DEEP_WARM_OCEAN_ID;
	public static final int DEEP_LUKEWARM_OCEAN_ID;
	public static final int DEEP_OCEAN_ID;
	public static final int DEEP_COLD_OCEAN_ID;
	public static final int DEEP_FROZEN_OCEAN_ID;
	
	public static final int FROZEN_RIVER_ID;
	
	static {
		WARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.WARM_OCEAN);
		LUKEWARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.LUKEWARM_OCEAN);
		OCEAN_ID = Registry.BIOME.getRawId(Biomes.OCEAN);
		COLD_OCEAN_ID = Registry.BIOME.getRawId(Biomes.COLD_OCEAN);
		FROZEN_OCEAN_ID = Registry.BIOME.getRawId(Biomes.FROZEN_OCEAN);
		DEEP_WARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_WARM_OCEAN);
		DEEP_LUKEWARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_LUKEWARM_OCEAN);
		DEEP_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_OCEAN);
		DEEP_COLD_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_COLD_OCEAN);
		DEEP_FROZEN_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_FROZEN_OCEAN);
		
		FROZEN_RIVER_ID = Registry.BIOME.getRawId(Biomes.FROZEN_RIVER);
	}
	
	public static boolean isOceanBiome(int int_1) {
		return int_1 == WARM_OCEAN_ID || int_1 == LUKEWARM_OCEAN_ID || int_1 == OCEAN_ID || int_1 == COLD_OCEAN_ID || int_1 == FROZEN_OCEAN_ID || int_1 == DEEP_WARM_OCEAN_ID || int_1 == DEEP_LUKEWARM_OCEAN_ID || int_1 == DEEP_OCEAN_ID || int_1 == DEEP_COLD_OCEAN_ID || int_1 == DEEP_FROZEN_OCEAN_ID;
	}

	public static boolean isShallowOceanBiome(int int_1) {
		return int_1 == WARM_OCEAN_ID || int_1 == LUKEWARM_OCEAN_ID || int_1 == OCEAN_ID || int_1 == COLD_OCEAN_ID || int_1 == FROZEN_OCEAN_ID;
	}
}
