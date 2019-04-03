package valoeghese.biomeoverhaul.util.math;

import net.minecraft.util.math.Vec3i;

public class TranslatableTuple<A extends Vec3i, B> extends Tuple<A, B>
{

	public TranslatableTuple(A vector, B b)
	{
		super(vector, b);
	}
	
	@SuppressWarnings("unchecked")
	public TranslatableTuple<A, B> translate(A vector)
	{
		this.a = (A)add(this.a, vector);
		return this;
	}
	
	private static Vec3i add(Vec3i a, Vec3i b)
	{
		return b.getX() == 0 && b.getY() == 0 && b.getZ() == 0 ? a : new Vec3i(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
	}
}
