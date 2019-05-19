package valoeghese.biomeoverhaul.world;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.BadlandsSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import valoeghese.biomeoverhaul.TheBiomeOverhaul;
import valoeghese.biomeoverhaul.util.noise.OpenSimplexNoise;

public class CustomSurfaceBuilders
{
	public static SurfaceBuilder<TernarySurfaceConfig> SHIELD_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> TUNDRA_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> GROVE_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> RAINFOREST_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> GLACIER_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> OUTBACK_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> PEAT_BOG_BUILDER;
	public static SurfaceBuilder<TernarySurfaceConfig> FORESTED_SPIRES_BUILDER;

	public static TernarySurfaceConfig SNOWY_CONFIG;
	public static TernarySurfaceConfig ICY_CONFIG;
	public static TernarySurfaceConfig ICY_SNOWY_CONFIG;
	public static TernarySurfaceConfig TERRACOTTA_RED_CONFIG;
	public static TernarySurfaceConfig TERRACOTTA_ORANGE_CONFIG;
	public static TernarySurfaceConfig TERRACOTTA_YELLOW_CONFIG;
	public static TernarySurfaceConfig TERRACOTTA_CONFIG;
	public static TernarySurfaceConfig CLAY_CONFIG;
	public static TernarySurfaceConfig RAINFOREST_CONFIG;
	public static TernarySurfaceConfig OUTBACK_CONFIG;

	private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> SurfaceBuilder<C> register(String string1, F surfaceBuilder1)
	{
		return (SurfaceBuilder<C>)Registry.register(Registry.SURFACE_BUILDER, (String)string1, surfaceBuilder1);
	}

	public static void init()
	{
		SNOWY_CONFIG = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState());
		ICY_CONFIG = new TernarySurfaceConfig(Blocks.BLUE_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState());
		ICY_SNOWY_CONFIG = new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.PACKED_ICE.getDefaultState(), Blocks.BLUE_ICE.getDefaultState());
		TERRACOTTA_RED_CONFIG = new TernarySurfaceConfig(Blocks.RED_TERRACOTTA.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState());
		TERRACOTTA_ORANGE_CONFIG = new TernarySurfaceConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		TERRACOTTA_YELLOW_CONFIG = new TernarySurfaceConfig(Blocks.YELLOW_TERRACOTTA.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		TERRACOTTA_CONFIG = new TernarySurfaceConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		RAINFOREST_CONFIG = new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		CLAY_CONFIG = new TernarySurfaceConfig(Blocks.CLAY.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState());
		OUTBACK_CONFIG = new TernarySurfaceConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), Blocks.GRAVEL.getDefaultState());

		SHIELD_BUILDER = register("tbo:valoeghese_shield", new ShieldSurfaceBuilder(TernarySurfaceConfig::deserialize));
		TUNDRA_BUILDER = register("tbo:valoeghese_tundra", new TundraSurfaceBuilder(TernarySurfaceConfig::deserialize));
		GROVE_BUILDER = register("tbo:valoeghese_grove", new GroveSurfaceBuilder(TernarySurfaceConfig::deserialize));
		RAINFOREST_BUILDER = register("tbo:valoeghese_rainforest", new RainforestSurfaceBuilder(TernarySurfaceConfig::deserialize));
		GLACIER_BUILDER = register("tbo:valoeghese_glacier", new GlacierBuilder(TernarySurfaceConfig::deserialize));
		OUTBACK_BUILDER = register("tbo:valoeghese_outback", new OutbackBuilder(TernarySurfaceConfig::deserialize));
		PEAT_BOG_BUILDER = register("tbo:valoeghese_bog", new PeatBogBuilder(TernarySurfaceConfig::deserialize));
		FORESTED_SPIRES_BUILDER = register("tbo:valoeghese_spires", new SpiresBuilder(TernarySurfaceConfig::deserialize));

		TheBiomeOverhaul.getLogger().debug("Registered Surface Builders!");
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
	public static class SpiresBuilder extends BadlandsSurfaceBuilder
	{
		private static final BlockState GRASS = Blocks.GRASS_BLOCK.getDefaultState();
		public SpiresBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random_1, Chunk chunk_1, Biome biome_1,
				int int_1, int int_2, int int_3,
				double double_1, BlockState blockState_1, BlockState blockState_2,
				int int_4, long long_1, TernarySurfaceConfig ternarySurfaceConfig_1)
		{
			double double_2 = 0.0D;
			double double_3 = Math.min(Math.abs(double_1), this.field_15623.sample((double)int_1 * 0.25D, (double)int_2 * 0.25D));
			if (double_3 > 0.0D) {
				double double_5 = Math.abs(this.field_15618.sample((double)int_1 * 0.001953125D, (double)int_2 * 0.001953125D));
				double_2 = double_3 * double_3 * 2.5D;
				double double_6 = Math.ceil(double_5 * 50.0D) + 14.0D;
				if (double_2 > double_6) {
					double_2 = double_6;
				}

				double_2 += 64.0D;
			}

			int int_5 = int_1 & 15;
			int int_6 = int_2 & 15;
			BlockState blockState_3 = DIRT; //correct
			BlockState blockState_4 = biome_1.getSurfaceConfig().getUnderMaterial();
			int int_7 = (int)(double_1 / 3.0D + 3.0D + random_1.nextDouble() * 0.25D);
			int int_8 = -1;
			boolean boolean_2 = false;
			BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();

			for(int int_9 = Math.max(int_3, (int)double_2 + 1); int_9 >= 0; --int_9) {
				blockPos$Mutable_1.set(int_5, int_9, int_6);
				if (chunk_1.getBlockState(blockPos$Mutable_1).isAir() && int_9 < (int)double_2) {
					chunk_1.setBlockState(blockPos$Mutable_1, blockState_1, false);
				}

				BlockState blockState_5 = chunk_1.getBlockState(blockPos$Mutable_1);
				if (blockState_5.isAir()) {
					int_8 = -1;
				} else if (blockState_5.getBlock() == blockState_1.getBlock()) {
					if (int_8 == -1) {
						boolean_2 = false;
						if (int_7 <= 0) {
							blockState_3 = Blocks.AIR.getDefaultState();
							blockState_4 = blockState_1;
						} else if (int_9 >= int_4 - 4 && int_9 <= int_4 + 1) {
							blockState_3 = GRASS;
							blockState_4 = biome_1.getSurfaceConfig().getUnderMaterial();
						}

						if (int_9 < int_4 && (blockState_3 == null || blockState_3.isAir())) {
							blockState_3 = blockState_2;
						}

						int_8 = int_7 + Math.max(0, int_9 - int_4);
						if (int_9 >= int_4 - 1) {
							if (int_9 <= int_4 + 3 + int_7) {
								chunk_1.setBlockState(blockPos$Mutable_1, biome_1.getSurfaceConfig().getTopMaterial(), false);
								boolean_2 = true;
							} else {
								
								chunk_1.setBlockState(blockPos$Mutable_1, GRASS, false);
							}
						} else {
							Block block_1 = blockState_4.getBlock();
							if (block_1 == Blocks.GRASS || block_1 == Blocks.COARSE_DIRT || block_1 == Blocks.DIRT)
							{
								chunk_1.setBlockState(blockPos$Mutable_1, COARSE_DIRT, false);
							}
							else
							{
								chunk_1.setBlockState(blockPos$Mutable_1, blockState_4, false);
							}
						}
					} else if (int_8 > 0) {
						--int_8;
						if (boolean_2) {
							chunk_1.setBlockState(blockPos$Mutable_1, GRASS, false);
						} else {
							chunk_1.setBlockState(blockPos$Mutable_1, DIRT, false);
						}
					}
				}
			}
		}
	}
	public static class PeatBogBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public PeatBogBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int worldHeight, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (noiseVal > 0D)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, worldHeight, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.COARSE_DIRT_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, worldHeight, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.PODZOL_CONFIG);
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
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SNOWY_CONFIG);
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
	public static class OutbackBuilder extends SurfaceBuilder<TernarySurfaceConfig>
	{
		public OutbackBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function1)
		{
			super(function1);
		}

		@Override
		public void generate(Random random1, Chunk chunk1, Biome biome1, int int1, int int2, int seaLevel, double noiseVal,
				BlockState blockState1, BlockState blockState_2, int int_4, long long1, TernarySurfaceConfig var14) {
			if (random1.nextInt(3) == 0)
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, SurfaceBuilder.GRASS_CONFIG);
			}
			else
			{
				SurfaceBuilder.DEFAULT.generate(random1, chunk1, biome1, int1, int2, seaLevel, noiseVal, blockState1, blockState_2, int_4, long1, OUTBACK_CONFIG);
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
