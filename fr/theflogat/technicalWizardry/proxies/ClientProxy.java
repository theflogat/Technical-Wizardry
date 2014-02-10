package fr.theflogat.technicalWizardry.proxies;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.theflogat.technicalWizardry.entity.Projectile;
import fr.theflogat.technicalWizardry.render.RenderProjectile;
//import fr.theflogat.technicalWizardry.tileEntity.render.TileEntityVacuumChestRenderer;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void initRenderers() {
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVacuumChest.class, new TileEntityVacuumChestRenderer());
		RenderingRegistry.registerEntityRenderingHandler(Projectile.class, new RenderProjectile());
	}

	@Override
	public void initSounds() {

	}
	
}
