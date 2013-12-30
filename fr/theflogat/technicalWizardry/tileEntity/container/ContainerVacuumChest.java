package fr.theflogat.technicalWizardry.tileEntity.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fr.theflogat.technicalWizardry.tileEntity.TEVacuumChest;

public class ContainerVacuumChest extends Container{
	
	public TEVacuumChest tile;
	public int actualSlot=0;

	public ContainerVacuumChest(InventoryPlayer invPlayer,TEVacuumChest entity) {
		tile = entity;
		for(int x = 0; x < 9; x++) {
			  this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(entity,actualSlot, 8 + x * 18, 6 + y * 18));
				++actualSlot;
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 < tile.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, tile.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, tile.getSizeInventory(), false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}
