package fr.theflogat.technicalWizardry.tileEntity;

import fr.theflogat.technicalWizardry.util.Coordinates;
import fr.theflogat.technicalWizardry.util.TWUUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class TETWU extends TileEntity implements ISidedInventory{
	
	public int[] SideInfo;
	
	public TETWU(int[] sideInfo){
		SideInfo = sideInfo;
	}
	
	public TETWU(){
		SideInfo = null;
	}
	
	public World getWorld() {
		return worldObj;
	}
	
	public void dropContents()
	{
		Coordinates here = getCoords();
		for (int i = 0; i < getSizeInventory(); i++)
			TWUUtils.spawnItemStack(here, getStackInSlot(i), worldObj);
	}

	protected Coordinates getCoords() {
		Coordinates coords = new Coordinates(this.xCoord, this.yCoord, this.zCoord, this.worldObj);
		return coords;
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
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return SideInfo;
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);

		if(itemstack != null) {
			if(itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
		itemstack = itemstack.splitStack(count);
		onInventoryChanged();
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemstack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemstack;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}
}
