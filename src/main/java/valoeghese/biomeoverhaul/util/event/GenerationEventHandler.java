package valoeghese.biomeoverhaul.util.event;

public interface GenerationEventHandler<T>
{
	
	public static enum ModifierPriority
	{
		HIGH, STANDARD, LOW;
	}
	
	public void add(T instance, ModifierPriority priority);
}
