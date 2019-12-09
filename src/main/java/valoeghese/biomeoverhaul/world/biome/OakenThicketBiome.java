package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import valoeghese.biomeoverhaul.world.feature.TBOFeatures;

public class OakenThicketBiome extends TBOBiome {
	public OakenThicketBiome() {
		super(BiomeFactory.create(0.4F, 0.2F, Biome.Category.FOREST).setTemperatureDownfall(0.6F, 0.7F));
		this.theBiomeFactory.addDefaultGeneration();
		DefaultBiomeFeatures.addDefaultLakes(this);
		this.theBiomeFactory.addDefaultMineables();
		
		DefaultBiomeFeatures.addMossyRocks(this);
		
		this.theBiomePopulator.addTreeFeature(Feature.NORMAL_TREE, DefaultBiomeFeatures.OAK_TREE_WITH_BEEHIVES_CONFIG, 1F);
		this.theBiomePopulator.addTreeFeature(Feature.FANCY_TREE, DefaultBiomeFeatures.FANCY_TREE_WITH_BEEHIVES_CONFIG, 0.4F);
		this.theBiomePopulator.addTreeFeature(TBOFeatures.LARGE_SHRUB, FeatureConfig.DEFAULT, 0.3F);
		
		this.theBiomePopulator.treesPerChunk = 20;
		this.theBiomePopulator.buildTreeFeatures();
		DefaultBiomeFeatures.addDefaultGrass(this);
		DefaultBiomeFeatures.addPlainsTallGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}
}
