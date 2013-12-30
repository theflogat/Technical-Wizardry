package fr.theflogat.technicalWizardry.tileEntity.container;

import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.tileEntity.TEMainRitualStone;
import fr.theflogat.technicalWizardry.tileEntity.slots.SlotRestricted;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerMainRitualStone extends Container{
	
	private TEMainRitualStone mainRit;

	public ContainerMainRitualStone(InventoryPlayer invPlay, TEMainRitualStone tile){
		mainRit = tile;
		
		for(int x = 0; x < 9; x++) {
			  this.addSlotToContainer(new Slot(invPlay, x, 8 + x * 18, 142));
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlay, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		this.addSlotToContainer(new SlotRestricted(tile, 0, 80 , 59, this, ItemObjectTWU.Rune.itemID));
		this.addSlotToContainer(new Slot(tile, 1 ,62, 35));
		this.addSlotToContainer(new Slot(tile, 2 ,80, 35));
		this.addSlotToContainer(new Slot(tile, 3 ,98, 35));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return mainRit.isUseableByPlayer(entityplayer);
	}

}
