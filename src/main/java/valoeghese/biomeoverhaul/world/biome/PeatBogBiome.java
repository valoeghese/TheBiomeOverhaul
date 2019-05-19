package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import valoeghese.biomeoverhaul.world.CustomBiomeFeatures;
import valoeghese.biomeoverhaul.world.CustomSurfaceBuilders;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.RiverType;
import valoeghese.biomeoverhaul.world.feature.TBOFeatures;

public class PeatBogBiome extends TBOBiome
{

	public PeatBogBiome()
	{
		//0.04/0.02 seems to stop at y=64, thus not descending below sea level
		super(BiomeFactory.create(0.0F, 0.02F, Biome.Category.SWAMP).setSurfaceBuilder(CustomSurfaceBuilders.PEAT_BOG_BUILDER).setSpawnChance(0.1F).setTemperatureDownfall(1.4F, 0.6F).setRiverType(RiverType.NONE).setWaterProperties(0xaf9d54, 0xafae4b).setCustomSkyColour(0xc1b170));
		
		this.addStructureFeature(Feature.SWAMP_HUT, FeatureConfig.DEFAULT);
		
		this.theBiomeFactory.addDefaultGeneration();
		CustomBiomeFeatures.addIncreasedWaterLakes(this);
		this.theBiomeFactory.addDefaultMineables();
		this.theBiomePopulator.extraTreeChance = 0.2F;
		
		this.theBiomePopulator.addTreeFeature(TBOFeatures.LARGE_SHRUB, 0.7F);
		this.theBiomePopulator.addTreeFeature(TBOFeatures.DEAD_TREE_FEATURE, 1);
		
		this.theBiomePopulator.buildTreeFeatures();
		
		DefaultBiomeFeatures.addFrozenTopLayer(this);
	}

}
