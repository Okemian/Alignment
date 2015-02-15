package com.sr2610.alignment.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;

import static com.sr2610.alignment.common.configuration.ConfigurationHandler.*;
import com.sr2610.alignment.common.lib.LibNames;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;



public class AlignmentGuiConfig extends GuiConfig {


	public AlignmentGuiConfig(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), LibNames.modID, false, false, StatCollector.translateToLocal("gui." + LibNames.modID + ".config.title"));
	}
	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements(GuiScreen parent) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		// adds sections declared in ConfigHandler. toLowerCase() is used because the configuration class automatically does this, so must we.
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(general.toLowerCase())));
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(tracking.toLowerCase())));

		return list;
	}
}
