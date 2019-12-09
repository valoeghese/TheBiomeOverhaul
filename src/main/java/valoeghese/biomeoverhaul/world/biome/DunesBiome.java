package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import valoeghese.biomeoverhaul.api.modifier.RiverType;

public class DunesBiome extends TBOBiome
{
	public DunesBiome()
	{
		super(BiomeFactory.create(1.2F, 0.32F, Biome.Precipitation.NONE, Biome.Category.DESERT).setTemperatureDownfall(2.0F, 0.1F).setRiverType(RiverType.NONE).setSpawnChance(0.02F));
		
		this.setTopBlock(Blocks.SAND.getDefaultState());
		this.setFillerBlock(Blocks.SAND.getDefaultState());
		this.setUnderwaterBlock(Blocks.SANDSTONE.getDefaultState());
		
		this.theBiomeFactory.addDefaultGeneration();
		this.theBiomeFactory.addDefaultMineables();
		
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.HUSK, 80, 4, 6));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 28, 2, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 2, 2, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 30, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 2, 1, 4));
		
	}
}
