package valoeghese.biomeoverhaul.world.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import valoeghese.biomeoverhaul.config.OverhaulSettings;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.BiomePopulator;

public abstract class TBOBiome extends Biome
{	
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
	public int getSkyColor()
	{
		if (OverhaulSettings.SETTINGS.client_tinted_skies && this.theBiomeFactory.hasCustomSkyColour())
			return this.theBiomeFactory.getCustomSkyColour();
		else
			return super.getSkyColor();
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getGrassColorAt(double x, double z)
	{
		return this.theBiomeFactory.hasCustomGrassColour ? this.theBiomeFactory.getGrassColour() : super.getGrassColorAt(x, z);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getFoliageColorAt()
	{
		return this.theBiomeFactory.hasCustomFoliageColour ? this.theBiomeFactory.getFoliageColour() : super.getFoliageColorAt();
	}

	@Override
	public float getMaxSpawnLimit()
	{
		return this.theBiomeFactory.getSpawnChance();
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

	// Redirecting methods to mimic 1.14 behaviour
	public static <T extends FeatureConfig, U extends DecoratorConfig> ConfiguredFeature<?, ?> configure(Feature<T> feature, T featureConfig, Decorator<U> decorator, U decoratorConfig) {
		return feature.configure(featureConfig).createDecoratedFeature(decorator.configure(decoratorConfig));
	}

	public <T extends FeatureConfig> void addStructureFeature(StructureFeature<T> feature, T config) {
		this.addStructureFeature(feature.configure(config));
	}
}
