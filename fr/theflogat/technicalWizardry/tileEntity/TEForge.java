package fr.theflogat.technicalWizardry.tileEntity;

import fr.theflogat.technicalWizardry.api.BlockRuneAssigner;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.api.BlockRuneAssigner.Value;
import fr.theflogat.technicalWizardry.api.RuneValueHelper;
import fr.theflogat.technicalWizardry.items.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class TEForge extends TETWU{

	public ItemStack inv[];
	public ItemStack yield1;
	public boolean decr = false;
	
	public TEForge() {
		super(null);
		this.inv = new ItemStack[3];
	}

	@Override
	public void updateEntity(){
		if(getStackInSlot(2)==null){
			 if(yield1!=null){
				 if(decr){
					 setInventorySlotContents(2, yield1);
					 yield1 = null;
					 decr = false;
				 } else {
					 decrOnceSlt(0);
					 decrOnceSlt(1);
					 decr = true;
				 }

			 } else {
				 if(getStackInSlot(0)!=null && getStackInSlot(1)!=null){
					 yield1 = RuneValueHelper.evaluation(getStackInSlot(1).getItem().itemID, getStackInSlot(1).getItemDamage());
				 }
			 }
		}
	}
	
	public void decrOnceSlt(int slot){
		if(getStackInSlot(slot)==null || getStackInSlot(slot).stackSize==1){
			setInventorySlotContents(slot, null);
		} else {
			setInventorySlotContents(slot, new ItemStack(getStackInSlot(slot).getItem(), getStackInSlot(slot).stackSize-1, getStackInSlot(slot).getItemDamage()));
		}
	}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		if(itemstack.itemID == ItemObjectTWU.Rune.itemID && slot == 0){
			return true;
		} else if(RuneValueHelper.hasValue(itemstack)&&slot==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int j) {
		if(slot==2){
			return true;
		}
		return false;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(itemstack.getItem()==ItemObjectTWU.Rune && slot == 0){
			return true;
		} else if(RuneValueHelper.hasValue(itemstack) && slot == 1){
			return true;
		}
		return false;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		int[] x = {0,1,2};
		return x;
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
		return inv[i];
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		inv[slot] = itemstack;
			
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}
	

	@Override
	public String getInvName() {
		return "Forge";
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagList list = new NBTTagList();

		for(int i = 0; i < this.getSizeInventory(); i++) {
			ItemStack itemstack = this.getStackInSlot(i);

			if(itemstack != null) {
				NBTTagCompound item = new NBTTagCompound();

				item.setByte(this.getInvName() + "SlotsTWUTile", (byte) i);
				itemstack.writeToNBT(item);
				list.appendTag(item);
			}
		}
	compound.setTag(this.getInvName() + "ItemsTWUTile", list);
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagList list = compound.getTagList(this.getInvName() + "ItemsTWUTile");

		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound) list.tagAt(i);
			int slot = item.getByte(this.getInvName() + "SlotsTWUTile");

			if(slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}
}
