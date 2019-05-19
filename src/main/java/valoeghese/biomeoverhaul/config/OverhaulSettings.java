package valoeghese.biomeoverhaul.config;

public class OverhaulSettings
{
	public static OverhaulSettings SETTINGS = new OverhaulSettings(); //Temporary until initialised
	
	public double climate_scale = 27.5D;
	public double humidity_scale = 15D;
	public double swamp_scale = 9D;
	public double ocean_scale = 17D;
	
	public double ocean_cutoff = 0.3D;
	public double desert_cutoff = 0.56D;
	public double tropical_cutoff = 0.28D;
	public double cool_cutoff = -0.28D;
	public double frozen_cutoff = -0.56D;
	public double ocean_bluff_cutoff = 0.26D;
	
	public double forest_cutoff = 0.1D;
	public double canopy_cutoff = 0.24D;
	public double rainforest_cutoff = 0.29D;
	
	public double mountain_main_scale_multiplier = 0.75D;
	
	public boolean client_tinted_skies = false;
}
