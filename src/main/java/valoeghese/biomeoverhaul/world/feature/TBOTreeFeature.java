package valoeghese.biomeoverhaul.world.feature;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.Structure;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.BitSetVoxelSet;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.world.IWorld;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

// basically just code stolen from 1.14.4 so I don't have to change all my custom tree code
public abstract class TBOTreeFeature<T extends FeatureConfig> extends Feature<T> {
	public TBOTreeFeature(Function<Dynamic<?>, ? extends T> configDeserializer, boolean emitNeighbourBlockUpdates) {
		super(configDeserializer);

		this.doNeighbourBlockUpdates = emitNeighbourBlockUpdates;
	}

	protected static boolean canTreeReplace(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			Block block = blockState.getBlock();
			return blockState.isAir() || blockState.matches(BlockTags.LEAVES) || block == Blocks.GRASS_BLOCK || isNaturalDirt(block) || block.matches(BlockTags.LOGS) || block.matches(BlockTags.SAPLINGS) || block == Blocks.VINE;
		});
	}

	protected void setToDirt(ModifiableTestableWorld world, BlockPos pos) {
		if (!isNaturalDirt(world, pos)) {
			this.setBlockState(world, pos, Blocks.DIRT.getDefaultState());
		}
	}

	protected static boolean isReplaceablePlant(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			Material material = blockState.getMaterial();
			return material == Material.REPLACEABLE_PLANT;
		});
	}

	protected static boolean isWater(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			return blockState.getBlock() == Blocks.WATER;
		});
	}

	protected static boolean isNaturalDirt(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			return isNaturalDirt(blockState.getBlock());
		});
	}

	protected static boolean isAir(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			return blockState.isAir();
		});
	}

	protected static boolean isAirOrLeaves(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			return blockState.isAir() || blockState.matches(BlockTags.LEAVES);
		});
	}

	protected static boolean isLeaves(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			return blockState.matches(BlockTags.LEAVES);
		});
	}

	public static boolean isNaturalDirt(Block block) {
		return block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL;
	}

	private final boolean doNeighbourBlockUpdates;

	public static boolean isNaturalDirtOrGrass(TestableWorld world, BlockPos pos) {
		return world.testBlockState(pos, (blockState) -> {
			return isDirt(blockState.getBlock());
		});
	}

	private void setBlockStateWithoutUpdatingNeighbors(ModifiableWorld modifiableWorld, BlockPos blockPos, BlockState blockState) {
		if (this.doNeighbourBlockUpdates) {
			modifiableWorld.setBlockState(blockPos, blockState, 19);
		} else {
			modifiableWorld.setBlockState(blockPos, blockState, 18);
		}
	}


	protected static boolean isDirt(Block block) {
		return block == Blocks.DIRT || block == Blocks.GRASS_BLOCK || block == Blocks.PODZOL || block == Blocks.COARSE_DIRT || block == Blocks.MYCELIUM;
	}

	// Proudly stolen from Minecraft 1.14.4 code
	@Override
	public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, T config) {
		Set<BlockPos> set = Sets.newHashSet();
		BlockBox mibb = BlockBox.empty();
		boolean bl = this.generate(set, world, random, pos, mibb);
		if (mibb.minX > mibb.maxX) {
			return false;
		} else {
			List<Set<BlockPos>> list = Lists.newArrayList();
			int i = 6;

			for(int j = 0; j < i; ++j) {
				list.add(Sets.newHashSet());
			}

			VoxelSet voxelSet = new BitSetVoxelSet(mibb.getBlockCountX(), mibb.getBlockCountY(), mibb.getBlockCountZ());
			BlockPos.PooledMutable pooledMutable = BlockPos.PooledMutable.get();
			Throwable var13 = null;

			try {
				if (bl && !set.isEmpty()) {
					Iterator<BlockPos> var14 = Lists.newArrayList(set).iterator();

					while(var14.hasNext()) {
						BlockPos blockPos = (BlockPos)var14.next();
						if (mibb.contains(blockPos)) {
							voxelSet.set(blockPos.getX() - mibb.minX, blockPos.getY() - mibb.minY, blockPos.getZ() - mibb.minZ, true, true);
						}

						Direction[] var16 = Direction.values();
						int var17 = var16.length;

						for(int var18 = 0; var18 < var17; ++var18) {
							Direction direction = var16[var18];
							pooledMutable.set(blockPos).setOffset(direction);
							if (!set.contains(pooledMutable)) {
								BlockState blockState = world.getBlockState(pooledMutable);
								if (blockState.contains(Properties.DISTANCE_1_7)) {
									list.get(0).add(pooledMutable.toImmutable());
									this.setBlockStateWithoutUpdatingNeighbors(world, pooledMutable, (BlockState)blockState.with(Properties.DISTANCE_1_7, 1));
									if (mibb.contains(pooledMutable)) {
										voxelSet.set(pooledMutable.getX() - mibb.minX, pooledMutable.getY() - mibb.minY, pooledMutable.getZ() - mibb.minZ, true, true);
									}
								}
							}
						}
					}
				}

				for(int k = 1; k < 6; ++k) {
					Set<BlockPos> set2 = list.get(k - 1);
					Set<BlockPos> set3 = list.get(k);
					Iterator<BlockPos> var39 = set2.iterator();

					while(var39.hasNext()) {
						BlockPos blockPos2 = (BlockPos)var39.next();
						if (mibb.contains(blockPos2)) {
							voxelSet.set(blockPos2.getX() - mibb.minX, blockPos2.getY() - mibb.minY, blockPos2.getZ() - mibb.minZ, true, true);
						}

						Direction[] var41 = Direction.values();
						int var42 = var41.length;

						for(int var21 = 0; var21 < var42; ++var21) {
							Direction direction2 = var41[var21];
							pooledMutable.set(blockPos2).setOffset(direction2);
							if (!set2.contains(pooledMutable) && !set3.contains(pooledMutable)) {
								BlockState blockState2 = world.getBlockState(pooledMutable);
								if (blockState2.contains(Properties.DISTANCE_1_7)) {
									int l = (Integer)blockState2.get(Properties.DISTANCE_1_7);
									if (l > k + 1) {
										BlockState blockState3 = (BlockState)blockState2.with(Properties.DISTANCE_1_7, k + 1);
										this.setBlockStateWithoutUpdatingNeighbors(world, pooledMutable, blockState3);
										if (mibb.contains(pooledMutable)) {
											voxelSet.set(pooledMutable.getX() - mibb.minX, pooledMutable.getY() - mibb.minY, pooledMutable.getZ() - mibb.minZ, true, true);
										}

										set3.add(pooledMutable.toImmutable());
									}
								}
							}
						}
					}
				}
			} catch (Throwable var33) {
				var13 = var33;
				throw var33;
			} finally {
				if (pooledMutable != null) {
					if (var13 != null) {
						try {
							pooledMutable.close();
						} catch (Throwable var32) {
							var13.addSuppressed(var32);
						}
					} else {
						pooledMutable.close();
					}
				}

			}

			Structure.method_20532(world, 3, voxelSet, mibb.minX, mibb.minY, mibb.minZ);
			return bl;
		}
	}

	public abstract boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random random_1, BlockPos blockPos_1, BlockBox mibb);

	// also stolen from 1.14.4
	protected final void setBlockState(Set<BlockPos> logPositions, ModifiableWorld world, BlockPos pos, BlockState state, BlockBox mibb) {
		this.setBlockStateWithoutUpdatingNeighbors(world, pos, state);
		mibb.encompass(new BlockBox(pos, pos));
		if (BlockTags.LOGS.contains(state.getBlock())) {
			logPositions.add(pos.toImmutable());
		}
	}
}
