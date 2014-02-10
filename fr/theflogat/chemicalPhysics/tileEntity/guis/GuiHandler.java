package fr.theflogat.chemicalPhysics.tileEntity.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import fr.theflogat.chemicalPhysics.ChemicalPhysics;
import fr.theflogat.chemicalPhysics.lib.GuiIds;
import fr.theflogat.chemicalPhysics.tileEntity.TileEntityElectrolyser;
import fr.theflogat.chemicalPhysics.tileEntity.container.ContainerElectrolyser;

public class GuiHandler implements IGuiHandler{
	
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(ChemicalPhysics.instance, this);
	}
	

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch(id) {
		case GuiIds.Electrolyser:
			if(entity != null && entity instanceof TileEntityElectrolyser) {
				return new ContainerElectrolyser(player.inventory, (TileEntityElectrolyser) entity);
			} else {
				return null;
			}
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch(id) {
		case GuiIds.Electrolyser:
			if(entity != null && entity instanceof TileEntityElectrolyser) {
				return new GuiElectrolyser(player.inventory, (TileEntityElectrolyser) entity);
			} else {
				return null;
			}
		default:
			return null;
		}
	}
}
