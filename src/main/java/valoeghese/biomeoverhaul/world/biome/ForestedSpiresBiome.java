package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import valoeghese.biomeoverhaul.world.CustomSurfaceBuilders;
import valoeghese.biomeoverhaul.world.feature.TBOFeatures;

public class ForestedSpiresBiome extends TBOBiome
{

	public ForestedSpiresBiome()
	{
		super(BiomeFactory.create(0.2F, 0.12F, Category.FOREST).setSurfaceBuilder(CustomSurfaceBuilders.FORESTED_SPIRES_BUILDER).setTemperatureDownfall(0.64F, 0.6F));
		
		this.theBiomeFactory.addDefaultGeneration();
		this.theBiomeFactory.addDefaultMineables();
		
		this.theBiomePopulator.treesPerChunk = 18;
		
		this.theBiomePopulator.addTreeFeature(TBOFeatures.LARGE_SHRUB, 3);
		this.theBiomePopulator.addTreeFeature(Feature.JUNGLE_TREE, 3);
		this.theBiomePopulator.addTreeFeature(Feature.NORMAL_TREE, 3);
		this.theBiomePopulator.addTreeFeature(Feature.FANCY_TREE, 2);
		this.theBiomePopulator.addTreeFeature(Feature.DARK_OAK_TREE, 0.1F);
		
		this.theBiomePopulator.buildTreeFeatures();
		
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		DefaultBiomeFeatures.addJungleGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.COW, 3, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.SLIME, 1, 1, 2));
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
