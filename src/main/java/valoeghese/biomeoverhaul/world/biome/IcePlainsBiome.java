package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.VillageFeatureConfig;
import valoeghese.biomeoverhaul.api.modifier.RiverType;
import valoeghese.biomeoverhaul.world.pseudo.PillagerOutpostFeatureConfig;

public class IcePlainsBiome extends TBOBiome {
	public IcePlainsBiome() {
		super(BiomeFactory.create(0.122F, 0.07F, Biome.Precipitation.SNOW, Biome.Category.ICY).setRiverType(RiverType.ICY).setTemperatureDownfall(-0.2F, 0.7F).setSpawnChance(0.08F));
		this.addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/snowy/town_centers", 6));
		this.addStructureFeature(Feature.IGLOO, FeatureConfig.DEFAULT);
		this.addStructureFeature(Feature.PILLAGER_OUTPOST, new PillagerOutpostFeatureConfig(0.002D));
		this.theBiomeFactory.addDefaultGeneration();
		DefaultBiomeFeatures.addDesertLakes(this);
		this.theBiomeFactory.addDefaultMineables();
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addSprings(this);	
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.RABBIT, 10, 2, 3));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.POLAR_BEAR, 1, 1, 2));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 20, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.STRAY, 80, 4, 4));
	}

}
