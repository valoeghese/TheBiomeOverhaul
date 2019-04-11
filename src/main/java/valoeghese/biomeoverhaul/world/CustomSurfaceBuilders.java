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
import valoeghese.biomeoverhaul.util.noise.OpenSimplexNoise;

public class CustomSurfaceBuilders
{
	public static final SurfaceBuilder<TernarySurfaceConfig> SHIELD_BUILDER;
	public static final SurfaceBuilder<TernarySurfaceConfig> TUNDRA_BUILDER;
	public static final SurfaceBuilder<TernarySurfaceConfig> GROVE_BUILDER;
	public static final SurfaceBuilder<TernarySurfaceConfig> RAINFOREST_BUILDER;
	public static final SurfaceBuilder<TernarySurfaceConfig> GLACIER_BUILDER;
	
	public static final TernarySurfaceConfig ALPS_CONFIG;
	public static final TernarySurfaceConfig ICY_CONFIG;
	public static final TernarySurfaceConfig ICY_SNOWY_CONFIG;
	public static final TernarySurfaceConfig TERRACOTTA_RED_CONFIG;
	public static final TernarySurfaceConfig TERRACOTTA_ORANGE_CONFIG;
	public static final TernarySurfaceConfig TERRACOTTA_YELLOW_CONFIG;
	public static final TernarySurfaceConfig TERRACOTTA_CONFIG;
	public static final TernarySurfaceConfig CLAY_CONFIG;
	public static final TernarySurfaceConfig RAINFOREST_CONFIG;
	
	private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> SurfaceBuilder<C> register(String string1, F surfaceBuilder1)
	{
		return (SurfaceBuilder<C>)Registry.register(Registry.SURFACE_BUILDER, (String)string1, surfaceBuilder1);
	}

	static
	{
		ALPS_CONFIG = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState());
		ICY_CONFIG = new TernarySurfaceConfig(Blocks.BLUE_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState());
		ICY_SNOWY_CONFIG = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState());
		TERRACOTTA_RED_CONFIG = new TernarySurfaceConfig(Blocks.RED_TERRACOTTA.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState());
		TERRACOTTA_ORANGE_CONFIG = new TernarySurfaceConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		TERRACOTTA_YELLOW_CONFIG = new TernarySurfaceConfig(Blocks.YELLOW_TERRACOTTA.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		TERRACOTTA_CONFIG = new TernarySurfaceConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		RAINFOREST_CONFIG = new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		CLAY_CONFIG = new TernarySurfaceConfig(Blocks.CLAY.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		
		SHIELD_BUILDER = register("tbo:valoeghese_shield", new ShieldSurfaceBuilder(TernarySurfaceConfig::deserialize));
		TUNDRA_BUILDER = register("tbo:valoeghese_tundra", new TundraSurfaceBuilder(TernarySurfaceConfig::deserialize));
		GROVE_BUILDER = register("tbo:valoeghese_grove", new GroveSurfaceBuilder(TernarySurfaceConfig::deserialize));
		RAINFOREST_BUILDER = register("tbo:valoeghese_rainforest", new RainforestSurfaceBuilder(TernarySurfaceConfig::deserialize));
		GLACIER_BUILDER = register("tbo:valoeghese_glacier", new GlacierBuilder(TernarySurfaceConfig::deserialize));
	}

	public static class ShieldSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public ShieldSurfaceBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int worldHeight, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (noiseVal > 3.25D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, worldHeight, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.STONE_CONFIG);
			}
			else if (noiseVal > -1.85D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, worldHeight, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.GRASS_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, worldHeight, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.STONE_CONFIG);
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
	public static class GlacierBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public GlacierBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int seaLevel, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (noiseVal > 3.1D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, ALPS_CONFIG);
			}
			else if (noiseVal > 1.4D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, ICY_SNOWY_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, ICY_CONFIG);
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
	public static class RainforestSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public RainforestSurfaceBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int seaLevel, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long seed, TernarySurfaceConfig var14) {
			
			double x = int1;
			double z = int2;
			
			if (noiseVal > 2.4D && noiseVal < 3.1D)
			{
				OpenSimplexNoise noise = new OpenSimplexNoise(seed);
				
				TernarySurfaceConfig config = TERRACOTTA_CONFIG;
				
				if (noise.eval(x / 8D, z / 8D) > 0.6D) config = TERRACOTTA_RED_CONFIG;
				else if (random1.nextInt(20) == 0) config = TERRACOTTA_ORANGE_CONFIG;
				else if (random1.nextInt(24) == 0) config = TERRACOTTA_YELLOW_CONFIG;
				
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, seed, config);
			}
			else
			{
				OpenSimplexNoise noise = new OpenSimplexNoise(seed);
				
				double dampNoise = noise.eval(x / 20D, z / 20D, 6D);
				double clayNoise = noise.eval(x / 14D, z / 14D, 3D);
				TernarySurfaceConfig config = RAINFOREST_CONFIG;
				
				if (clayNoise < -0.5D && clayNoise > -0.8D) config = CLAY_CONFIG;
				else if (noise.eval(x / 18D, z / 18D, 6D) > 0.84D) config = SurfaceBuilder.STONE_CONFIG;
				else if (dampNoise < -0.23D && dampNoise > -0.28D) config = SurfaceBuilder.PODZOL_CONFIG;
				
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, seed, config);
			}
		}
	}
}
