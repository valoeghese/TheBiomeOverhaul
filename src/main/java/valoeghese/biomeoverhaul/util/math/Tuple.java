package valoeghese.biomeoverhaul.util.math;

public class Tuple<A, B>
{
	protected A a;
	protected B b;
	
	public A getA()
	{
		return this.a;
	}
	
	public B getB()
	{
		return this.b;
	}
	
	public Tuple(A a, B b)
	{
		this.a = a;
		this.b = b;
	}
}
