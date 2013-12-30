package fr.theflogat.technicalWizardry.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import fr.theflogat.technicalWizardry.tileEntity.TEVacuumChest;
//import fr.theflogat.technicalWizardry.tileEntity.render.TileEntityVacuumChestRenderer;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void initRenderers() {
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVacuumChest.class, new TileEntityVacuumChestRenderer());
	}

	@Override
	public void initSounds() {

	}
	
}
