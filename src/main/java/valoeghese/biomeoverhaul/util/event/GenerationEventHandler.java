package valoeghese.biomeoverhaul.util.event;

public abstract class GenerationEventHandler<T>
{
	
	public static enum ModifierPriority
	{
		HIGH, STANDARD, LOW;
	}
	
	abstract public void add(T instance, ModifierPriority priority);
}
