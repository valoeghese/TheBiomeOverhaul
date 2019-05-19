package valoeghese.biomeoverhaul.api.modifier;

import java.util.ArrayList;
import java.util.List;

import valoeghese.biomeoverhaul.api.BiomeModifier;
import valoeghese.biomeoverhaul.util.event.GenerationEventHandler;

public enum BiomeModifiers implements GenerationEventHandler<BiomeModifier>
{
	INSTANCE;
	
	public static final List<BiomeModifier> initial_modifiers = new ArrayList<BiomeModifier>();
	public static final List<BiomeModifier> standard_modifiers = new ArrayList<BiomeModifier>();
	public static final List<BiomeModifier> final_modifiers = new ArrayList<BiomeModifier>();
	
	@Override
	public void add(BiomeModifier modifier, ModifierPriority priority)
	{
		switch(priority)
		{
		case HIGH:
			initial_modifiers.add(modifier);
		case STANDARD:
			standard_modifiers.add(modifier);
		case LOW:
			final_modifiers.add(modifier);
		}
	}
}
