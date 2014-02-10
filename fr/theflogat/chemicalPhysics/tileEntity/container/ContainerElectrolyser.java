package fr.theflogat.chemicalPhysics.tileEntity.container;

import fr.theflogat.chemicalPhysics.api.ItemObjectCPU;
import fr.theflogat.chemicalPhysics.items.Items;
import fr.theflogat.chemicalPhysics.tileEntity.TileEntityCPU;
import fr.theflogat.chemicalPhysics.tileEntity.TileEntityElectrolyser;
import fr.theflogat.chemicalPhysics.tileEntity.slots.SlotHasElectrolyserRecipe;
import fr.theflogat.chemicalPhysics.tileEntity.slots.SlotOutput;
import fr.theflogat.chemicalPhysics.tileEntity.slots.SlotRestricted;
import fr.theflogat.chemicalPhysics.tileEntity.slots.SlotRestrictedArray;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerElectrolyser extends ContainerCPU{

	private TileEntityElectrolyser electrolyser;
	public static int[] FuelIDs = {Item.coal.itemID, Item.blazeRod.itemID, Item.blazePowder.itemID};

	public ContainerElectrolyser(InventoryPlayer invPlayer, TileEntityElectrolyser entity) {
		this.electrolyser = entity;
		
		for(int x = 0; x < 9; x++) {
			  this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}
		addSlotToContainer(new SlotHasElectrolyserRecipe(entity, 0, 44 , 50));
		addSlotToContainer(new SlotRestricted(entity, 1, 116 , 50, this, ItemObjectCPU.EmptyCell.itemID));
		addSlotToContainer(new SlotOutput(entity, 2, 44 , 4));
		addSlotToContainer(new SlotOutput(entity, 3, 62 , 4));
		addSlotToContainer(new SlotOutput(entity, 4, 80 , 4));
		addSlotToContainer(new SlotOutput(entity, 5, 98 , 4));
		addSlotToContainer(new SlotOutput(entity, 6, 116 , 4));
		addSlotToContainer(new SlotRestrictedArray(entity, 7, 7, 7, this, FuelIDs));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return electrolyser.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
	  /*Slot slot = getSlot(i);

	  if(slot != null && slot.getHasStack()) {
	        ItemStack itemstack = slot.getStack();
	        ItemStack result = itemstack.copy();

	        if(i >= 36) {
	          if(!mergeItemStack(itemstack, 0, 36, false)) {
	                return null;
	          }
	        } else if(!mergeItemStack(itemstack, 36, 36 + electrolyser.getSizeInventory(), false)) {
	          return null;
	        }

	        if(itemstack.stackSize == 0) {
	          slot.putStack(null);
	        } else {
	          slot.onSlotChanged();
	        }
	        slot.onPickupFromSlot(player, itemstack); 
	        return result;
	  }*/
	  return null;
	}

	@Override
	public TileEntityCPU getTile() {
		return electrolyser;
	}
}
