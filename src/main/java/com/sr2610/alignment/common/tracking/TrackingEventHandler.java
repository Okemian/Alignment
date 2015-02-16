package com.sr2610.alignment.common.tracking;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TrackingEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer
				&& AlignmentExtendedPlayer.get((EntityPlayer) event.entity) == null)
			AlignmentExtendedPlayer.registerPlayer((EntityPlayer) event.entity);

	}


}
