package valoeghese.biomeoverhaul.util;

import java.util.HashMap;
import java.util.Map;

public class BlockPlot
{	
	private Map<Integer, BooleanPlane> plot = new HashMap<>();
	
	public boolean contains(int x, int y, int z)
	{
		if (this.plot.containsKey(y))
		{
			BooleanPlane plane = this.plot.get(y);
			
			if (x < plane.size && z < plane.size)
			{
				return plane.getPlane()[x][z].booleanValue();
			}
		}
		
		return false;
	}
	
	public BlockPlot addPlane(int y, BooleanPlane plane)
	{
		plot.put(y, plane);
		
		return this;
	}
	
	public static class BooleanPlane implements Plane<Boolean>
	{
		
		private Boolean[][] plane;
		private final int size;
		private boolean isNull = true;
		
		public BooleanPlane(int size)
		{
			plane = new Boolean[size][size];
			this.size = size;
		}
		
		public boolean isNull() { return this.isNull; }
		
		public BooleanPlane set(Boolean[][] arg0)
		{
			if (this.plane.length == arg0.length && arg0[0].length == this.plane.length)
			{
				plane = arg0;
				isNull = false;
			}
			
			return this;
		}
		
		public int size()
		{
			return size;
		}
		
		public Boolean[][] getPlane()
		{
			return plane;
		}
	}
	
	public static class IntegerPlane implements Plane<Integer>
	{
		
		private Integer[][] plane;
		private final int size;
		private boolean isNull = true;
		
		public IntegerPlane(int size)
		{
			plane = new Integer[size][size];
			this.size = size;
		}
		
		public IntegerPlane set(Integer[][] arg0)
		{
			if (this.plane.length == arg0.length && arg0[0].length == this.plane.length)
			{
				this.isNull = false;
				plane = arg0;
			}
			
			return this;
		}
		
		public boolean isNull() { return this.isNull; }
		
		public int size()
		{
			return size;
		}
		
		public Integer[][] getPlane()
		{
			return plane;
		}
	}
	
	public static interface Plane<T>
	{
		public int size();
		
		public Plane<T> set(T[][] arg0);
		
		public T[][] getPlane();
	}
}
