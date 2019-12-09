package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import valoeghese.biomeoverhaul.api.modifier.RiverType;
import valoeghese.biomeoverhaul.world.pseudo.PillagerOutpostFeatureConfig;

public class OutbackUluruBiome extends TBOBiome {
	public OutbackUluruBiome() {
		super(BiomeFactory.create(1.9F, 0.18F, Biome.Precipitation.NONE, Biome.Category.SAVANNA).setTemperatureDownfall(1.8F, 0.2F).setRiverType(RiverType.NONE).setSpawnChance(0.03F));
		
		this.setTopBlock(Blocks.RED_SANDSTONE.getDefaultState());
		this.setFillerBlock(Blocks.RED_SANDSTONE.getDefaultState());
		this.setUnderwaterBlock(Blocks.RED_SAND.getDefaultState());
		
		this.addStructureFeature(Feature.PILLAGER_OUTPOST, new PillagerOutpostFeatureConfig(0.012D));
		
		this.theBiomeFactory.addDefaultGeneration();
		DefaultBiomeFeatures.addSavannaTallGrass(this);
		this.theBiomeFactory.addDefaultMineables();
		DefaultBiomeFeatures.addSavannaGrass(this);
		DefaultBiomeFeatures.addDesertDeadBushes(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.RABBIT, 10, 4, 4));
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
