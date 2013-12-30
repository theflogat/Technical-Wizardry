package fr.theflogat.technicalWizardry.tileEntity.slots;

import fr.theflogat.technicalWizardry.api.RuneValueHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotHasRuneValue extends Slot{

	public SlotHasRuneValue(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}

    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return RuneValueHelper.hasValue(par1ItemStack);
    }
}
