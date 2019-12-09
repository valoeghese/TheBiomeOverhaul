package valoeghese.biomeoverhaul.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import valoeghese.biomeoverhaul.util.math.Triple;

public class BlockGenerator
{
	protected ModifiableTestableWorld world;
	public Set<BlockPos> set;
	protected boolean canGenerate = true;
	protected List<Triple<BlockPos, BlockState, Boolean>> gen = new ArrayList<>();
	protected BlockBox mibb;
	
	public BlockGenerator(ModifiableTestableWorld world, Set<BlockPos> set, BlockBox mibb)
	{
		this.world = world;
		this.set = set;
		this.mibb = mibb;
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
			for (Triple<BlockPos, BlockState, Boolean> triple : this.gen)
				if (triple.getC())
					world.setBlockState(triple.getA(), triple.getB(), flag);

			return true;
		}
		else return false;
	}

	public boolean generate(boolean forceGeneration, PublicWorldModifier generator)
	{
		if (this.canGenerate || forceGeneration)
		{
			for (Triple<BlockPos, BlockState, Boolean> triple : this.gen)
				if (triple.getC())
				{
					if (generator instanceof PublicWorldModifierTester)
						((PublicWorldModifierTester)generator).setWorldBlockState(this.set, this.world, triple.getA(), triple.getB(), mibb);
					else
						generator.setWorldBlockState(this.set, this.world, triple.getA(), triple.getB(), mibb);
				}

			return true;
		}
		else return false;
	}

	protected static boolean canTreeReplace(TestableWorld testableWorld_1, BlockPos blockPos_1)
	{
		return testableWorld_1.testBlockState(blockPos_1, (blockState_1) -> {
			Block block_1 = blockState_1.getBlock();
			return blockState_1.isAir() || blockState_1.matches(BlockTags.LEAVES) || block_1 == Blocks.GRASS_BLOCK || block_1 == Blocks.COARSE_DIRT || block_1 == Blocks.DIRT || block_1.matches(BlockTags.LOGS) || block_1.matches(BlockTags.SAPLINGS) || block_1 == Blocks.VINE;
		});
	}
}
