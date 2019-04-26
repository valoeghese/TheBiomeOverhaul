package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PillagerOutpostFeatureConfig;
import net.minecraft.world.gen.feature.VillageFeatureConfig;
import valoeghese.biomeoverhaul.world.CustomBiomeFeatures;
import valoeghese.biomeoverhaul.world.CustomSurfaceBuilders;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.RiverType;

public class OutbackBiome extends TBOBiome
{

	public OutbackBiome()
	{
		super(BiomeFactory.create(0.125F, 0.05F, Biome.Precipitation.NONE, Biome.Category.SAVANNA).setSurfaceBuilder(CustomSurfaceBuilders.OUTBACK_BUILDER).setTemperatureDownfall(1.8F, 0.3F).setRiverType(RiverType.NONE).setSpawnChance(0.03F));

		this.addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/savanna/town_centers", 3));
		this.addStructureFeature(Feature.PILLAGER_OUTPOST, new PillagerOutpostFeatureConfig(0.004D));
		this.theBiomeFactory.addDefaultGeneration();
		DefaultBiomeFeatures.addDesertLakes(this);
		DefaultBiomeFeatures.addSavannaTallGrass(this);
		this.theBiomeFactory.addDefaultMineables();
		CustomBiomeFeatures.addChapparalShrubs(this);
		DefaultBiomeFeatures.addSavannaGrass(this);
		DefaultBiomeFeatures.addDesertDeadBushes(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.RABBIT, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.HORSE, 1, 1, 1));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.HUSK, 50, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 45, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}

}
