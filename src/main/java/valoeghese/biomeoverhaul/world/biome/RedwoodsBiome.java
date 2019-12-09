package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import valoeghese.biomeoverhaul.world.feature.TBOFeatures;

public class RedwoodsBiome extends TBOBiome
{

	public RedwoodsBiome()
	{
		super(BiomeFactory.create(0.2F, 0.14F, Category.FOREST).setSurfaceBuilder(SurfaceBuilder.GIANT_TREE_TAIGA).setTemperatureDownfall(0.4F, 0.4F).setSpawnChance(0.23F).setBaseBiome("tbo:rainforest"));
		
		this.addStructureFeature(Feature.WOODLAND_MANSION, FeatureConfig.DEFAULT);
		this.theBiomeFactory.addDefaultGeneration();
		DefaultBiomeFeatures.addDefaultLakes(this);
		this.theBiomeFactory.addDefaultMineables();
		
		this.theBiomePopulator.treesPerChunk = 30;
		
		this.theBiomePopulator.addTreeFeature(TBOFeatures.REDWOOD, FeatureConfig.DEFAULT, 0.2F);
		this.theBiomePopulator.addTreeFeature(TBOFeatures.LARGE_SHRUB, FeatureConfig.DEFAULT, 1.5F);
		this.theBiomePopulator.addTreeFeature(TBOFeatures.SMALL_REDWOOD, FeatureConfig.DEFAULT, 2);
		this.theBiomePopulator.addTreeFeature(Feature.NORMAL_TREE, DefaultBiomeFeatures.PINE_TREE_CONFIG, 1);
		this.theBiomePopulator.addTreeFeature(Feature.DARK_OAK_TREE, DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG, 0.4F);
		
		this.theBiomePopulator.buildTreeFeatures();
		
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		DefaultBiomeFeatures.addSavannaGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.SHEEP, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.WOLF, 1, 3, 8));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 85, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}
}