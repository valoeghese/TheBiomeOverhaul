package valoeghese.biomeoverhaul.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class LargeSwampTreeFeature extends AbstractTreeFeature<DefaultFeatureConfig>
{
   private static final BlockState LOG;
   private static final BlockState LEAVES;

   public LargeSwampTreeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config)
   {
      super(config, false);
   }

   public boolean generate(Set<BlockPos> positions, ModifiableTestableWorld world, Random rand, BlockPos pos, MutableIntBoundingBox bb)
   {
      int height = rand.nextInt(7) + 5;
      pos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos);
      boolean shouldContinue = true;
      if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256) {
         int i;
         int j;
         int k;
         for(i = pos.getY(); i <= pos.getY() + 1 + height; ++i) {
            int placeHeight = 1;
            if (i == pos.getY()) {
               placeHeight = 0;
            }

            if (i >= pos.getY() + 1 + height - 2) {
               placeHeight = 3;
            }

            BlockPos.Mutable mutablePos = new BlockPos.Mutable();

            for(j = pos.getX() - placeHeight; j <= pos.getX() + placeHeight && shouldContinue; ++j) {
               for(k = pos.getZ() - placeHeight; k <= pos.getZ() + placeHeight && shouldContinue; ++k) {
                  if (i >= 0 && i < 256) {
                     mutablePos.set(j, i, k);
                     if (!isAirOrLeaves(world, mutablePos)) {
                        if (!isWater(world, mutablePos)) {
                           shouldContinue = false;
                        }
                     }
                  } else {
                     shouldContinue = false;
                  }
               }
            }
         }

         if (!shouldContinue) {
            return false;
         } else if (isNaturalDirtOrGrass(world, pos.down()) && pos.getY() < 256 - height - 1) {
            this.setToDirt(world, pos.down());

            int l;
            BlockPos eastVines;
            int offsetY;
            int offset;
            for(i = pos.getY() - 3 + height; i <= pos.getY() + height; ++i) {
               offsetY = i - (pos.getY() + height);
               offset = 2 - offsetY / 2;

               for(j = pos.getX() - offset; j <= pos.getX() + offset; ++j) {
                  k = j - pos.getX();

                  for(l = pos.getZ() - offset; l <= pos.getZ() + offset; ++l) {
                     int offsetZ = l - pos.getZ();
                     if (Math.abs(k) != offset || Math.abs(offsetZ) != offset || rand.nextInt(2) != 0 && offsetY != 0) {
                        eastVines = new BlockPos(j, i, l);
                        if (isAirOrLeaves(world, eastVines) || isReplaceablePlant(world, eastVines)) {
                           this.setBlockState(world, eastVines, LEAVES);
                        }
                     }
                  }
               }
            }

            for(i = 0; i < height; ++i) {
               BlockPos blockPos_3 = pos.up(i);
               if (isAirOrLeaves(world, blockPos_3) || isWater(world, blockPos_3)) {
                  this.setBlockState(positions, world, blockPos_3, LOG, bb);
               }
            }

            for(i = pos.getY() - 3 + height; i <= pos.getY() + height; ++i) {
               offsetY = i - (pos.getY() + height);
               offset = 2 - offsetY / 2;
               BlockPos.Mutable vinePos = new BlockPos.Mutable();

               for(k = pos.getX() - offset; k <= pos.getX() + offset; ++k) {
                  for(l = pos.getZ() - offset; l <= pos.getZ() + offset; ++l) {
                     vinePos.set(k, i, l);
                     if (isLeaves(world, vinePos)) {
                        BlockPos westVines = vinePos.west();
                        eastVines = vinePos.east();
                        BlockPos northVines = vinePos.north();
                        BlockPos southVines = vinePos.south();
                        if (rand.nextInt(4) == 0 && isAir(world, westVines)) {
                           this.makeVines(world, westVines, VineBlock.EAST);
                        }

                        if (rand.nextInt(4) == 0 && isAir(world, eastVines)) {
                           this.makeVines(world, eastVines, VineBlock.WEST);
                        }

                        if (rand.nextInt(4) == 0 && isAir(world, northVines)) {
                           this.makeVines(world, northVines, VineBlock.SOUTH);
                        }

                        if (rand.nextInt(4) == 0 && isAir(world, southVines)) {
                           this.makeVines(world, southVines, VineBlock.NORTH);
                        }
                     }
                  }
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void makeVines(ModifiableTestableWorld world, BlockPos pos, BooleanProperty property) {
      BlockState state = Blocks.VINE.getDefaultState().with(property, true);
      this.setBlockState(world, pos, state);
      int vineLength = 4;

      for(pos = pos.down(); isAir(world, pos) && vineLength > 0; --vineLength) {
         this.setBlockState(world, pos, state);
         pos = pos.down();
      }

   }

   static {
      LOG = Blocks.OAK_LOG.getDefaultState();
      LEAVES = Blocks.OAK_LEAVES.getDefaultState();
   }
}
