package valoeghese.biomeoverhaul.api.testing;

import net.minecraft.world.biome.layer.LayerRandomnessSource;
import valoeghese.biomeoverhaul.api.layer.Layer;

/**
 * 
 * @author Valoeghese
 *
 * TestModules to test a layer or aspect of generation. Does not override subsequent vanilla layers.
 * 
 * The module must be applied through TestModuleApplier.apply()
 */
public interface TestModule
{
	public Layer getTestBiomeLayer(LayerRandomnessSource random, int int_1, int int_2);
	
	default public boolean disableModifiers()
	{
		return true;
	}
	
	default public boolean canBeOverridenBy(TestModule module)
	{
		return module == TestModuleApplier.NullTestModule.INSTANCE;
	}
	
	/**
	 * @return whether the module is enabled
	 */
	public boolean isEnabled();
}
