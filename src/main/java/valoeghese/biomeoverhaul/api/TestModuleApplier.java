package valoeghese.biomeoverhaul.api;

import net.minecraft.world.biome.layer.LayerRandomnessSource;

/**
 * 
 * ONLY ENABLE FOR TESTING! THIS REPLACES THE ENTIRE WORLD WITH ONE BIOME LAYER!
 *
 */
public class TestModuleApplier
{
	public static void apply(TestModule testModule)
	{
		if (!module.canBeOverridenBy(testModule))
			throw new InvalidModuleApplicationException("Conflicting test modules are being applied! If you wish to switch modules during runtime, perhaps a module needs to override TestModule.canBeOverriddenBy(TestModule module)?");
	}
	
	public static TestModule getModule()
	{
		return module;
	}
	
	private static TestModule module = NullTestModule.INSTANCE;
	
	public static final boolean areModifiersEnabled()
	{
		return module.isEnabled() ? !module.disableModifiers() : true;
	}
	
	public static class NullTestModule implements TestModule
	{
		public static final TestModule INSTANCE = new NullTestModule();

		@Override
		public Layer getTestBiomeLayer(LayerRandomnessSource random, int int_1, int int_2)
		{
			return null;
		}

		@Override
		public boolean isEnabled()
		{
			return false;
		}
		
		@Override
		public boolean canBeOverridenBy(TestModule module)
		{
			return true;
		}
	}
	
	public static class InvalidModuleApplicationException extends RuntimeException
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public InvalidModuleApplicationException(String message)
		{
			super(message);
		}
	}
}
