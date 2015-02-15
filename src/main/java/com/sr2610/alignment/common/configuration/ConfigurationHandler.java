package com.sr2610.alignment.common.configuration;

import java.io.File;

import com.sr2610.alignment.common.lib.LibNames;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

	public static Configuration config;

	// Sections to add to the config
	public static String general = "General Settings";
	public static String tracking = "Alignment Tracking";

	public static boolean exampleOption;
	public static boolean enableTracking;

	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}

	public static void syncConfig() {
		config.addCustomCategoryComment(general,
				"General Settings for Alignment");
		config.addCustomCategoryComment(tracking,
				"This section contains all settings regarding tracking the players alignment through thier actions.");

		exampleOption = config.get(general, "exampleOption", true,
				"Description of option goes here.").getBoolean(exampleOption);
		enableTracking = config.get(tracking, "Enable Tracking", true,
				"Enable Silent Tracking of Actions").getBoolean(enableTracking);

		config.save();
	}

	@SubscribeEvent
	public void onConfigChanged(
			ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(LibNames.modID)) {
			syncConfig();
		}
	}
}
