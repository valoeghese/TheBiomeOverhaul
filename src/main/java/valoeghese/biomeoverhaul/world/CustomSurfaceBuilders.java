package valoeghese.biomeoverhaul.world;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class CustomSurfaceBuilders
{
	public static final SurfaceBuilder<TernarySurfaceConfig> SHIELD_BUILDER;
	public static final SurfaceBuilder<TernarySurfaceConfig> TUNDRA_BUILDER;
	public static final SurfaceBuilder<TernarySurfaceConfig> GROVE_BUILDER;
	public static final TernarySurfaceConfig ALPS_CONFIG;

	private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> SurfaceBuilder<C> register(String string1, F surfaceBuilder1)
	{
		return (SurfaceBuilder<C>)Registry.register(Registry.SURFACE_BUILDER, (String)string1, surfaceBuilder1);
	}

	static
	{
		ALPS_CONFIG = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState());
		SHIELD_BUILDER = register("tbo:valoeghese_shield", new ShieldSurfaceBuilder(TernarySurfaceConfig::deserialize));
		TUNDRA_BUILDER = register("tbo:valoeghese_tundra", new TundraSurfaceBuilder(TernarySurfaceConfig::deserialize));
		GROVE_BUILDER = register("tbo:valoeghese_grove", new GroveSurfaceBuilder(TernarySurfaceConfig::deserialize));
	}

	public static class ShieldSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public ShieldSurfaceBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int seaLevel, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (noiseVal > 3.25D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.STONE_CONFIG);
			}
			else if (noiseVal > -1.85D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.GRASS_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.STONE_CONFIG);
			}
		}
	}
	public static class TundraSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public TundraSurfaceBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int seaLevel, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (noiseVal > 1.4D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.COARSE_DIRT_CONFIG);
			}
			else if (noiseVal > -0.65D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.GRASS_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.COARSE_DIRT_CONFIG);
			}
		}
	}
	public static class GroveSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public GroveSurfaceBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int seaLevel, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (noiseVal > 2.8D || noiseVal < -2.8D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.STONE_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.GRASS_CONFIG);
			}
		}
	}
}
