package com.sr2610.alignment;

import net.minecraftforge.common.MinecraftForge;

import com.sr2610.alignment.common.CommonProxy;
import com.sr2610.alignment.common.configuration.ConfigurationHandler;
import com.sr2610.alignment.common.lib.LibNames;
import com.sr2610.alignment.common.tracking.TrackingEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibNames.modID, name = LibNames.modName, version = LibNames.modVersion, guiFactory = LibNames.modGuiFactory)
public class Alignment {

	@Mod.Instance(LibNames.modID)
	public static Alignment instance;

	@SidedProxy(serverSide = LibNames.proxyServer, clientSide = LibNames.proxyClient)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.preInit(event);

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		proxy.init(event);

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		proxy.postInit(event);
		
	}

}
