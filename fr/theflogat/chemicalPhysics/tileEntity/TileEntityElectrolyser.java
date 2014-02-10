package fr.theflogat.chemicalPhysics.tileEntity;

import java.util.Random;

import cofh.api.energy.EnergyStorage;
import fr.theflogat.chemicalPhysics.api.ItemObjectCPU;
import fr.theflogat.chemicalPhysics.items.Items;
import fr.theflogat.chemicalPhysics.tileEntity.container.ContainerElectrolyser;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityElectrolyser extends TileEntityCPU implements ISidedInventory{

	private Random random;
	private ItemStack[] inventory;
	private ItemStack temp;
	private int stcksc = 0;
	private static int[] accessibleSlots = {0,1,2,3,4,5,6};
	private int cooldown = 0;
	private boolean hasDecreased;
	
	@Override
	public void updateEntity() {
		if(cooldown == 0){
			if(energy.getEnergyStored()>4000){
				if(getStackInSlot(0)!=null){
					if(hasDecreased){
							hasDecreased = false;
					} else {
						energy.setEnergyStored(energy.getEnergyStored() - 4000);
						hasDecreased = true;
					}
				}
			}

			
			
			
			
			
			
			cooldown = 5;
		} else {
			--cooldown;
		}
	}
	
	public boolean dercsl(int decrnb, int slot){
		ItemStack stack = this.getStackInSlot(slot);
		
		if(canDecrSlot(decrnb, slot)){
			if(stack.stackSize==decrnb){
				setInventorySlotContents(slot, null);
			} else {
				setInventorySlotContents(slot, new ItemStack(stack.getItem(), stack.stackSize - decrnb, stack.getItemDamage()));
			}
			return true;
		}
		return false;
	}
	
	public boolean canDecrSlot(int decr, int slot){
		ItemStack stack = this.getStackInSlot(slot);
		if(stack!=null && stack.stackSize>=decr){
			return true;
		}
		return false;
	}
	
	public TileEntityElectrolyser() {
		super(accessibleSlots, 64000);
		inventory = new ItemStack[8];
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
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
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		inventory[slot] = itemstack;
	
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "Electrolyser";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(itemstack.getItem()!=ItemObjectCPU.EmptyCell && slot==1){
			return false;
		} else if(slot==3){
			for(int i=0;i<ContainerElectrolyser.FuelIDs.length;i++){
				if(ContainerElectrolyser.FuelIDs[i]==itemstack.itemID){
					return true;
				}
			}
			return false;
		} else if(slot==2){
			return false;
		} else if(slot==0) {
			if(itemstack.getItem()==ItemObjectCPU.EmptyCell){
				return false;
			} else {
				for(int i=0;i<ContainerElectrolyser.FuelIDs.length;i++){
					if(ContainerElectrolyser.FuelIDs[i]==itemstack.itemID){
						return false;
					}
				}
				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		if(slot == 2){
			return false;
		}
		return true;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		if(slot==2){
			return true;
		}
		return false;
	}

	public int getEnergy() {
		return this.energy.getEnergyStored();
	}
}
