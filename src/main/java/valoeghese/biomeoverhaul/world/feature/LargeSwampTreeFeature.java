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
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class LargeSwampTreeFeature extends AbstractTreeFeature<DefaultFeatureConfig>
{
   private static final BlockState LOG;
   private static final BlockState LEAVES;

   public LargeSwampTreeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1)
   {
      super(function_1, false);
   }

   public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld modifiableTestableWorld_1, Random random_1, BlockPos blockPos_1)
   {
      int height = random_1.nextInt(7) + 5;
      blockPos_1 = modifiableTestableWorld_1.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);
      boolean boolean_1 = true;
      if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256) {
         int int_14;
         int int_9;
         int int_17;
         for(int_14 = blockPos_1.getY(); int_14 <= blockPos_1.getY() + 1 + height; ++int_14) {
            int int_3 = 1;
            if (int_14 == blockPos_1.getY()) {
               int_3 = 0;
            }

            if (int_14 >= blockPos_1.getY() + 1 + height - 2) {
               int_3 = 3;
            }

            BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();

            for(int_9 = blockPos_1.getX() - int_3; int_9 <= blockPos_1.getX() + int_3 && boolean_1; ++int_9) {
               for(int_17 = blockPos_1.getZ() - int_3; int_17 <= blockPos_1.getZ() + int_3 && boolean_1; ++int_17) {
                  if (int_14 >= 0 && int_14 < 256) {
                     blockPos$Mutable_1.set(int_9, int_14, int_17);
                     if (!isAirOrLeaves(modifiableTestableWorld_1, blockPos$Mutable_1)) {
                        if (!isWater(modifiableTestableWorld_1, blockPos$Mutable_1)) {
                           boolean_1 = false;
                        }
                     }
                  } else {
                     boolean_1 = false;
                  }
               }
            }
         }

         if (!boolean_1) {
            return false;
         } else if (isNaturalDirtOrGrass(modifiableTestableWorld_1, blockPos_1.down()) && blockPos_1.getY() < 256 - height - 1) {
            this.setToDirt(modifiableTestableWorld_1, blockPos_1.down());

            int int_18;
            BlockPos blockPos_5;
            int int_7;
            int int_16;
            for(int_14 = blockPos_1.getY() - 3 + height; int_14 <= blockPos_1.getY() + height; ++int_14) {
               int_7 = int_14 - (blockPos_1.getY() + height);
               int_16 = 2 - int_7 / 2;

               for(int_9 = blockPos_1.getX() - int_16; int_9 <= blockPos_1.getX() + int_16; ++int_9) {
                  int_17 = int_9 - blockPos_1.getX();

                  for(int_18 = blockPos_1.getZ() - int_16; int_18 <= blockPos_1.getZ() + int_16; ++int_18) {
                     int int_12 = int_18 - blockPos_1.getZ();
                     if (Math.abs(int_17) != int_16 || Math.abs(int_12) != int_16 || random_1.nextInt(2) != 0 && int_7 != 0) {
                        blockPos_5 = new BlockPos(int_9, int_14, int_18);
                        if (isAirOrLeaves(modifiableTestableWorld_1, blockPos_5) || isReplaceablePlant(modifiableTestableWorld_1, blockPos_5)) {
                           this.setBlockState(modifiableTestableWorld_1, blockPos_5, LEAVES);
                        }
                     }
                  }
               }
            }

            for(int_14 = 0; int_14 < height; ++int_14) {
               BlockPos blockPos_3 = blockPos_1.up(int_14);
               if (isAirOrLeaves(modifiableTestableWorld_1, blockPos_3) || isWater(modifiableTestableWorld_1, blockPos_3)) {
                  this.setBlockState(set_1, modifiableTestableWorld_1, blockPos_3, LOG);
               }
            }

            for(int_14 = blockPos_1.getY() - 3 + height; int_14 <= blockPos_1.getY() + height; ++int_14) {
               int_7 = int_14 - (blockPos_1.getY() + height);
               int_16 = 2 - int_7 / 2;
               BlockPos.Mutable blockPos$Mutable_2 = new BlockPos.Mutable();

               for(int_17 = blockPos_1.getX() - int_16; int_17 <= blockPos_1.getX() + int_16; ++int_17) {
                  for(int_18 = blockPos_1.getZ() - int_16; int_18 <= blockPos_1.getZ() + int_16; ++int_18) {
                     blockPos$Mutable_2.set(int_17, int_14, int_18);
                     if (isLeaves(modifiableTestableWorld_1, blockPos$Mutable_2)) {
                        BlockPos blockPos_4 = blockPos$Mutable_2.west();
                        blockPos_5 = blockPos$Mutable_2.east();
                        BlockPos blockPos_6 = blockPos$Mutable_2.north();
                        BlockPos blockPos_7 = blockPos$Mutable_2.south();
                        if (random_1.nextInt(4) == 0 && isAir(modifiableTestableWorld_1, blockPos_4)) {
                           this.makeVines(modifiableTestableWorld_1, blockPos_4, VineBlock.EAST);
                        }

                        if (random_1.nextInt(4) == 0 && isAir(modifiableTestableWorld_1, blockPos_5)) {
                           this.makeVines(modifiableTestableWorld_1, blockPos_5, VineBlock.WEST);
                        }

                        if (random_1.nextInt(4) == 0 && isAir(modifiableTestableWorld_1, blockPos_6)) {
                           this.makeVines(modifiableTestableWorld_1, blockPos_6, VineBlock.SOUTH);
                        }

                        if (random_1.nextInt(4) == 0 && isAir(modifiableTestableWorld_1, blockPos_7)) {
                           this.makeVines(modifiableTestableWorld_1, blockPos_7, VineBlock.NORTH);
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

   private void makeVines(ModifiableTestableWorld modifiableTestableWorld_1, BlockPos blockPos_1, BooleanProperty booleanProperty_1) {
      BlockState blockState_1 = (BlockState)Blocks.VINE.getDefaultState().with(booleanProperty_1, true);
      this.setBlockState(modifiableTestableWorld_1, blockPos_1, blockState_1);
      int int_1 = 4;

      for(blockPos_1 = blockPos_1.down(); isAir(modifiableTestableWorld_1, blockPos_1) && int_1 > 0; --int_1) {
         this.setBlockState(modifiableTestableWorld_1, blockPos_1, blockState_1);
         blockPos_1 = blockPos_1.down();
      }

   }

   static {
      LOG = Blocks.OAK_LOG.getDefaultState();
      LEAVES = Blocks.OAK_LEAVES.getDefaultState();
   }
}
