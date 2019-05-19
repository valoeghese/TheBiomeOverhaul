package valoeghese.biomeoverhaul.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.biome.layer.SetBaseBiomesLayer;

@Mixin(SetBaseBiomesLayer.class)
public interface AccessorMixin
{
	@Accessor(value = "SNOWY_BIOMES")
	public int[] getSnowyBiomes();
	
	@Accessor(value = "COOL_BIOMES")
	public int[] getCoolBiomes();
	
	@Accessor(value = "TEMPERATE_BIOMES")
	public int[] getTemperateBiomes();
	
	@Accessor(value = "DRY_BIOMES")
	public int[] getDryBiomes();
}
