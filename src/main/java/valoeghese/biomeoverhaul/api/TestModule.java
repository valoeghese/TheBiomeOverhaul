package valoeghese.biomeoverhaul.api;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import valoeghese.biomeoverhaul.api.enums.GenerationCategory;

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
	/**
	 * To test a single biome, return TestModule.LayerSingle.get(biome)
	 */
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
	
	public static class LayerSingle
	{
		public Layer get(Biome biome)
		{
			return new Layer(Registry.BIOME.getRawId(biome)).withCategories(GenerationCategory.PLAINS);
		}
	}
}
