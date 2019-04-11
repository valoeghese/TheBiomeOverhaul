package valoeghese.biomeoverhaul.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import valoeghese.biomeoverhaul.util.math.Triple;

public class BlockGenerator
{
	protected ModifiableTestableWorld world;
	protected boolean canGenerate = true;
	protected List<Triple<BlockPos, BlockState, Boolean>> gen = new ArrayList<>();

	public BlockGenerator(ModifiableTestableWorld world)
	{
		this.world = world;
	}

	public void setBlock(BlockPos pos, BlockState state, boolean ignore)
	{
		boolean replaceable = canTreeReplace(this.world, pos);
		
		if (!ignore) this.canGenerate = this.canGenerate && replaceable;

		this.gen.add(new Triple<BlockPos, BlockState, Boolean>(pos, state, replaceable || ignore));
	}

	public boolean generate(int flag)
	{
		return this.generate(false, flag);
	}

	public boolean generate(PublicWorldModifier generator)
	{
		return this.generate(false, generator);
	}

	public boolean generate(boolean forceGeneration, int flag)
	{
		if (this.canGenerate || forceGeneration)
		{
			for (Triple<BlockPos, BlockState, Boolean> pair : this.gen)
				if (pair.getC())
					world.setBlockState(pair.getA(), pair.getB(), flag);

			return true;
		}
		else return false;
	}

	public boolean generate(boolean forceGeneration, PublicWorldModifier generator)
	{
		if (this.canGenerate || forceGeneration)
		{
			for (Triple<BlockPos, BlockState, Boolean> pair : this.gen)
				if (pair.getC())
					generator.setWorldBlockState(this.world, pair.getA(), pair.getB());

			return true;
		}
		else return false;
	}

	protected static boolean canTreeReplace(TestableWorld testableWorld_1, BlockPos blockPos_1)
	{
		return testableWorld_1.testBlockState(blockPos_1, (blockState_1) -> {
			Block block_1 = blockState_1.getBlock();
			return blockState_1.isAir() || blockState_1.matches(BlockTags.LEAVES) || block_1 == Blocks.GRASS_BLOCK || Block.isNaturalDirt(block_1) || block_1.matches(BlockTags.LOGS) || block_1.matches(BlockTags.SAPLINGS) || block_1 == Blocks.VINE;
		});
	}
}
