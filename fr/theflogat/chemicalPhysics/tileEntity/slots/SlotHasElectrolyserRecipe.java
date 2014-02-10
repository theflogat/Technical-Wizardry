package fr.theflogat.chemicalPhysics.tileEntity.slots;

import fr.theflogat.chemicalPhysics.api.ElectrolyserRecipeHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotHasElectrolyserRecipe extends Slot{

    public SlotHasElectrolyserRecipe(IInventory par1IInventory, int par2, int par3, int par4)
    {
        super(par1IInventory, par2, par3, par4);
    }
	
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return ElectrolyserRecipeHelper.hasRecipe(par1ItemStack);
    }
    
}
