package valoeghese.biomeoverhaul;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;
import valoeghese.biomeoverhaul.config.OverhaulSettings;

public class OverhaulConfig
{
	public static final String JSON = "{\"climate_scale\" : 27.5, \"humidity_scale\" : 15.0, \"swamp_scale\": 9.0, \"ocean_scale\": 17.0, \"ocean_cutoff\": 0.3, \"desert_cutoff\": 0.56, \"tropical_cutoff\": 0.28, \"cool_cutoff\": -0.28, \"frozen_cutoff\": -0.56, \"ocean_bluff_cutoff\": 0.26, \"forest_cutoff\": 0.1D, \"canopy_cutoff\": 0.24D, \"rainforest_cutoff\": 0.29D, \"mountain_main_scale_multiplier\": 0.75D, \"client_tinted_skies\": false}";
	public static void init()
	{
		File configLoc = new File(FabricLoader.getInstance().getConfigDirectory().toString() + "/BiomeOverhaul.json");
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.setPrettyPrinting().create();
		
		boolean b = false;
		try
		{
			b = configLoc.createNewFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if (b)
		{
			try (FileWriter writer = new FileWriter(configLoc))
			{
				OverhaulSettings.SETTINGS = gson.fromJson(JSON, OverhaulSettings.class);
				
				writer.write(gson.toJson(OverhaulSettings.SETTINGS));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try (FileReader reader = new FileReader(configLoc))
			{
				OverhaulSettings.SETTINGS = gson.fromJson(reader, OverhaulSettings.class);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
