package fr.theflogat.securitySwap.eventHooks;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;

public class OpeningEvent {
	@ForgeSubscribe
	public void onTryToOpen(PlayerOpenContainerEvent event){
		event.setCanceled(true);
	}
}
