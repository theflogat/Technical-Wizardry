package fr.theflogat.technicalWizardry.proxies;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.theflogat.technicalWizardry.world.TickHandler;

public class CommonProxy{
	public void initRenderers() {

	}

	public void initSounds() {

	}

	public void registerServerTickHandler(){
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
	}
}
