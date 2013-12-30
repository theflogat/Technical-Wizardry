package fr.theflogat.technicalWizardry.tileEntity.container;

import fr.theflogat.chemicalPhysics.tileEntity.slots.SlotRestricted;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.tileEntity.TEBuffer;
import fr.theflogat.technicalWizardry.tileEntity.TEPlayerLinkedBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ContainerPlayerLinked extends Container{

	private TEPlayerLinkedBlock playLink;

	public ContainerPlayerLinked(InventoryPlayer invPlayer, TEPlayerLinkedBlock entity) {
		this.playLink = entity;
		
		for(int x = 0; x < 9; x++) {
			  this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}
		addSlotToContainer(new SlotRestricted(entity, 0, 7, 7, this, ItemObjectTWU.PlayerLink.itemID));
		addSlotToContainer(new Slot(entity, 1, 80, 35));
		addSlotToContainer(new Slot(entity, 2, 98, 35));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return playLink.isUseableByPlayer(player);
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
	        } else if(!mergeItemStack(itemstack, 36, 36 + playLink.getSizeInventory(), false)) {
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
}
