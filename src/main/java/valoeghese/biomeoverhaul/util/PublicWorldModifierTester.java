package valoeghese.biomeoverhaul.util;

import java.util.Set;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.ModifiableTestableWorld;

public interface PublicWorldModifierTester extends PublicWorldModifier
{
	public void setWorldBlockState(Set<BlockPos> set, ModifiableTestableWorld world, BlockPos pos, BlockState state, MutableIntBoundingBox mibb);
}