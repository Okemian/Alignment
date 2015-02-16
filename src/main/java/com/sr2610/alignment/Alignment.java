package com.sr2610.alignment;

import net.minecraftforge.common.MinecraftForge;

import com.sr2610.alignment.common.configuration.ConfigurationHandler;
import com.sr2610.alignment.common.lib.LibNames;
import com.sr2610.alignment.common.tracking.TrackingEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = LibNames.modID, name = LibNames.modName, version = LibNames.modVersion,guiFactory = LibNames.modGuiFactory)
public class Alignment {
	
	 @Mod.Instance(LibNames.modID)
	    public static Alignment instance;
	 
	 
	  @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	 
	        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
	        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
	    }
	 
	    @Mod.EventHandler
	    public void init(FMLInitializationEvent event){
	 
	        FMLCommonHandler.instance().bus().register(instance);
	        MinecraftForge.EVENT_BUS.register(new TrackingEventHandler());

	    }
	 
	    @Mod.EventHandler
	    public void postInit(FMLPostInitializationEvent event){
	 
	    }

}
