package fr.theflogat.chemicalPhysics.proxies;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.theflogat.chemicalPhysics.world.TickHandler;

public class CommonProxy {
	public void initRenderers() {

	}

	public void initSounds() {

	}
	
	public void registerServerTickHandler(){
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
	}
}
