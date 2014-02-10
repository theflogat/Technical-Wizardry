package fr.theflogat.redstoneFluxControl;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ContainerRFController extends Container{

	private TERFController contr;
	
	public ContainerRFController(InventoryPlayer inventory,	TERFController entity) {
		contr = entity;
	}
	
	public boolean[] oldData = new boolean[6];

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return contr.canInteractWith(entityplayer);
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting player) {
		super.addCraftingToCrafters(player);
		
		
	}
	
	@Override
	public void updateProgressBar(int par1, int par2) {
		super.updateProgressBar(par1, par2);
		
		
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		
	}
	
	public TERFController getTile(){
		return contr;
	}
}
