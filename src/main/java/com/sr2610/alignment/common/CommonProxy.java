package com.sr2610.alignment.common;

import net.minecraftforge.common.MinecraftForge;

import com.sr2610.alignment.Alignment;
import com.sr2610.alignment.common.configuration.ConfigurationHandler;
import com.sr2610.alignment.common.tracking.TrackingEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        
	}

	public void init(FMLInitializationEvent event) {
		
		FMLCommonHandler.instance().bus().register(Alignment.instance);
        MinecraftForge.EVENT_BUS.register(new TrackingEventHandler());
        
	}

	public void postInit(FMLPostInitializationEvent event) {
	
	}

}
