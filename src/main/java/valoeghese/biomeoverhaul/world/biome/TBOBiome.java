package valoeghese.biomeoverhaul.world.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.BiomePopulator;

public abstract class TBOBiome extends Biome
{
	//TODO decoration/population features. In progress.
	
	public void setTopBlock(BlockState top)
	{
		this.theBiomeFactory.surfaceConfig.setTopMaterial(top);
	}
	public void setFillerBlock(BlockState under)
	{
		this.theBiomeFactory.surfaceConfig.setUnderMaterial(under);
	}
	public void setUnderwaterBlock(BlockState underwater)
	{
		this.theBiomeFactory.surfaceConfig.setUnderwaterMaterial(underwater);
	}
	
	public final BiomeFactory theBiomeFactory;
	public final BiomePopulator theBiomePopulator;
	
	protected TBOBiome(BiomeFactory factory)
	{
		super(factory.build());
		
		factory.setParent(this);
		theBiomeFactory = factory;
		theBiomePopulator = factory.createPopulator();
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public int getGrassColorAt(BlockPos pos)
	{
		return this.hasCustomColours() ? this.theBiomeFactory.getGrassColour() : super.getGrassColorAt(pos);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public int getFoliageColorAt(BlockPos pos)
	{
		return this.hasCustomColours() ? this.theBiomeFactory.getFoliageColour() : super.getFoliageColorAt(pos);
	}
	
	@Override
	public float getMaxSpawnLimit()
	{
		return this.theBiomeFactory.getSpawnChance();
	}
	
	public boolean hasCustomColours()
	{
		return this.theBiomeFactory.hasCustomColours();
	}
	
	//============================================================================//
	
	public static class TBOSurfaceConfig extends TernarySurfaceConfig implements Cloneable
	{
		private BlockState top;
		private BlockState under;
		private BlockState waterfloor;
		
		public TBOSurfaceConfig(BlockState top, BlockState under, BlockState underwater)
		{
			super(top, under, underwater);
			
			this.top = top;
			this.under = under;
			this.waterfloor = underwater;
		}

		@Override
		public BlockState getTopMaterial()
		{
			return this.top;
		}
		@Override
		public BlockState getUnderMaterial()
		{
			return this.under;
		}
		@Override
		public BlockState getUnderwaterMaterial()
		{
			return this.waterfloor;
		}
		
		public TBOSurfaceConfig setTopMaterial(BlockState top)
		{
			this.top = top;
			return this;
		}
		public TBOSurfaceConfig setUnderMaterial(BlockState under)
		{
			this.under = under;
			return this;
		}
		public TBOSurfaceConfig setUnderwaterMaterial(BlockState waterfloor)
		{
			this.waterfloor = waterfloor;
			return this;
		}
		
		@Override
		public TBOSurfaceConfig clone()
		{
			return new TBOSurfaceConfig(this.top, this.under, this.waterfloor);
		}

	}
}
