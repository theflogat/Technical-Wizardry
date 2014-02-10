package fr.theflogat.chemicalPhysics.tileEntity.slots;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRestrictedArray extends Slot{

	private Container container;
	private int[] idAllowed;
	
	public SlotRestrictedArray(IInventory par1iInventory, int par2, int par3, int par4, Container par5container, int[] par6id) {
		super(par1iInventory, par2, par3, par4);
        this.container = par5container;
        this.idAllowed = par6id;
	}

    public boolean isItemValid(ItemStack par1ItemStack)
    {
    	for(int i=0;i<idAllowed.length;i++){
    		if(par1ItemStack.getItem().itemID == idAllowed[i]){
    			return true;
    		}
    	}
    	return false;
    }
}