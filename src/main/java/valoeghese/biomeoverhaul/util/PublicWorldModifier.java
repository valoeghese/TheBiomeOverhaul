package valoeghese.biomeoverhaul.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableWorld;

public interface PublicWorldModifier
{
	public void setWorldBlockState(ModifiableWorld world, BlockPos pos, BlockState state);
}
