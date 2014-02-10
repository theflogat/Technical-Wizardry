package fr.theflogat.technicalWizardry.tileEntity;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.regex.Matcher;

import fr.theflogat.technicalWizardry.handler.sync.PacketManager;
import fr.theflogat.technicalWizardry.lib.LogHelper;
import fr.theflogat.technicalWizardry.util.Coordinates;
import fr.theflogat.technicalWizardry.util.Incrementer;
import fr.theflogat.technicalWizardry.util.InventoryManagement;
import fr.theflogat.technicalWizardry.util.LabeledInteger;
import fr.theflogat.technicalWizardry.util.TWUUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TESpecificItemInserter extends TETWU implements ISidedInventory{

	public boolean upgradeSpeed = false;
	public int cooldownValue = 20;
	public int cooldown = 0;
	public int StorageLimit = 64;
	public TileEntity foundEnt;
	public ItemStack[] inv;
	public Coordinates blockCoords = this.getCoords();
	public int redstone = 0;
	public byte meta = 0;
	public String TAG_SPEED_UPGRADE = "speedUpgrade";
	
	/*public boolean upgradeItemFilter = false;
	public boolean upgradeMachineFilter = false;
	public boolean upgradeThorough = false;
	public boolean upgradeThroughput = false;
	public boolean upgradeEject = false;
	public int eject_direction;*/

	private static final int[] sideInfo = { 0 };

	
	public TESpecificItemInserter(){
		super(sideInfo);
		this.inv = new ItemStack[1];
	}
	

	@Override
	public void updateEntity() {
		redstone = 0;
		for(int i = 0; i<7;i++){
			redstone = Math.max(worldObj.getIndirectPowerLevelTo(xCoord, yCoord, zCoord, i), redstone);
		}
		if(upgradeSpeed)
			cooldownValue = 3;
		if(cooldown==0){
			if(getStackInSlot(0)!=null){
				foundEnt = this.getTileFromOrientation();
				setInventorySlotContents(0,InventoryManagement.tryInsertInInvWithSlot(foundEnt, getStackInSlot(0), redstone, ((byte) this.getBlockMetadata())));
			}
			cooldown = cooldownValue;
		}else{
			cooldown--;
		}
		meta = (byte) this.getBlockMetadata();
	}
	
	public TileEntity getTileFromOrientation(){
		meta = (byte) this.getBlockMetadata();
		if(meta==0){
			return worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord);
		} else if(meta==1){
			return worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
		} else if(meta==2){
			return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord-1);
		} else if(meta==3){
			return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord+1);
		} else if(meta==4){
			return worldObj.getBlockTileEntity(xCoord-1, yCoord, zCoord);
		} else if(meta==5){
			return worldObj.getBlockTileEntity(xCoord+1, yCoord, zCoord);
		}
		return null;
	}
	
	public int getRedsone(){
		return redstone;
	}
	
	public boolean setUpgrade(){
		if(!upgradeSpeed){
			upgradeSpeed = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getUpgrade(){
		return upgradeSpeed;
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
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return StorageLimit;
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
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return true;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return true;
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
		return "SpecificItemInserter";
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return sideInfo;
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setBoolean("upgradeSpeed", upgradeSpeed);
		
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
		
		upgradeSpeed = compound.getBoolean("upgradeSpeed");
	}
}