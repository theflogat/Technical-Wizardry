package fr.theflogat.technicalWizardry.tileEntity.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.GuiIds;
import fr.theflogat.technicalWizardry.tileEntity.*;
import fr.theflogat.technicalWizardry.tileEntity.container.*;


public class GuiHandler implements IGuiHandler{
	
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(TechnicalWizardry.instance, this);
	}
	

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch(id) {
		case GuiIds.Forge:
			if(entity != null && entity instanceof TEForge) {
				return new ContainerForge(player.inventory, (TEForge) entity);
			} else {
				return null;
			}
		case GuiIds.Buffer:
			if(entity != null && entity instanceof TEBuffer) {
				return new ContainerBuffer(player.inventory, (TEBuffer) entity);
			} else {
				return null;
			}
		case GuiIds.ItemInserter:
			if(entity != null && entity instanceof TEItemInserter) {
				return new ContainerItemInserter(player.inventory, (TEItemInserter) entity);
			} else {
				return null;
			}
		case GuiIds.SpecificItemInserter:
			if(entity != null && entity instanceof TESpecificItemInserter) {
				return new ContainerSpecificItemInserter(player.inventory, (TESpecificItemInserter) entity);
			} else {
				return null;
			}
		case GuiIds.VacuumChest:
			if(entity != null && entity instanceof TEVacuumChest) {
				return new ContainerVacuumChest(player.inventory, (TEVacuumChest) entity);
			} else {
				return null;
			}
		case GuiIds.MainRitualStone:
			if(entity != null && entity instanceof TEMainRitualStone) {
				return new ContainerMainRitualStone(player.inventory, (TEMainRitualStone) entity);
			} else {
				return null;
			}
		case GuiIds.PlayerLinkedBlock:
			if(entity != null && entity instanceof TEPlayerLinkedBlock) {
				return new ContainerPlayerLinked(player.inventory, (TEPlayerLinkedBlock) entity);
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
		case GuiIds.Forge:
			if(entity != null && entity instanceof TEForge) {
				return new GuiForge(player.inventory, (TEForge) entity);
			} else {
				return null;
			}
		case GuiIds.Buffer:
			if(entity != null && entity instanceof TEBuffer) {
				return new GuiBuffer(player.inventory, (TEBuffer) entity);
			} else {
				return null;
			}
		case GuiIds.ItemInserter:
			if(entity != null && entity instanceof TEItemInserter) {
				return new GuiInserter(player.inventory, (TEItemInserter) entity, world, x, y, z);
			} else {
				return null;
			}
		case GuiIds.SpecificItemInserter:
			if(entity != null && entity instanceof TESpecificItemInserter) {
				return new GuiSpecificInserter(player.inventory, (TESpecificItemInserter) entity);
			} else {
				return null;
			}
		case GuiIds.VacuumChest:
			if(entity != null && entity instanceof TEVacuumChest) {
				return new GuiVacuumChest(player.inventory, (TEVacuumChest) entity);
			} else {
				return null;
			}
		case GuiIds.MainRitualStone:
			if(entity != null && entity instanceof TEMainRitualStone) {
				return new GuiMainRitualStone(player.inventory, (TEMainRitualStone) entity);
			} else {
				return null;
			}
		case GuiIds.PlayerLinkedBlock:
			if(entity != null && entity instanceof TEPlayerLinkedBlock) {
				return new GuiPlayerLinked(player.inventory, (TEPlayerLinkedBlock) entity);
			} else {
				return null;
			}
		default:
			return null;
		}
	}
}
