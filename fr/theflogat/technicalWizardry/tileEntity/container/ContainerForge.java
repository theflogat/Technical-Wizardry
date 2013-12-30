package fr.theflogat.technicalWizardry.tileEntity.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fr.theflogat.technicalWizardry.tileEntity.slots.SlotHasRuneValue;
import fr.theflogat.technicalWizardry.tileEntity.slots.SlotOutput;
import fr.theflogat.technicalWizardry.tileEntity.slots.SlotRestricted;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.items.Items;
import fr.theflogat.technicalWizardry.tileEntity.TEForge;

public class ContainerForge extends Container{

	TEForge forge;

	public ContainerForge(InventoryPlayer invPlayer, TEForge entity) {
		this.forge = entity;
		
		for(int x = 0; x < 9; x++) {
			  this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}
		addSlotToContainer(new SlotRestricted(entity, 0, 26 , 35, this, ItemObjectTWU.Rune.itemID));
		addSlotToContainer(new SlotHasRuneValue(entity, 1, 44 , 35));
		addSlotToContainer(new SlotOutput(entity, 2, 129 , 35));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return forge.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}
}
