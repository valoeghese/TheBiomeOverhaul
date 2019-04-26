package valoeghese.biomeoverhaul.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import valoeghese.biomeoverhaul.world.biome.BiomeFactory.RiverType;

public class AlpsBiome extends TBOBiome
{
	public AlpsBiome()
	{
		super(BiomeFactory.create(3.8F, 0.12F, Biome.Precipitation.SNOW, Biome.Category.EXTREME_HILLS).setTemperatureDownfall(-0.5F, 0.4F).setRiverType(RiverType.NONE).setSpawnChance(0.07F));
		
		this.setTopBlock(Blocks.SNOW_BLOCK.getDefaultState());
		this.setFillerBlock(Blocks.SNOW_BLOCK.getDefaultState());
		this.setUnderwaterBlock(Blocks.STONE.getDefaultState());
		
		this.theBiomeFactory.addDefaultGeneration();
		this.theBiomeFactory.addDefaultMineables();
		
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 30, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 2, 1, 4));
		
	}
}
