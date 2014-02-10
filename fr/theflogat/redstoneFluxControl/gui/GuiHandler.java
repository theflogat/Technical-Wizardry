package fr.theflogat.redstoneFluxControl.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import fr.theflogat.redstoneFluxControl.ContainerRFController;
import fr.theflogat.redstoneFluxControl.RedstoneFluxControl;
import fr.theflogat.redstoneFluxControl.TERFController;

public class GuiHandler implements IGuiHandler{
	
	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(RedstoneFluxControl.instance, this);
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		switch(id){
		case 0:
			if(entity != null && entity instanceof TERFController) {
				return new ContainerRFController(player.inventory, (TERFController) entity);
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,	int x, int y, int z) {
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		switch(id){
		case 0:
			if(entity != null && entity instanceof TERFController) {
				return new GuiRFController(player.inventory, (TERFController) entity);
			} else {
				return null;
			}
		}
		return null;
	}

}
