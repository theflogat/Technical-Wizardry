package fr.theflogat.technicalWizardry.util;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class InventoryManagement {
	
	public static ItemStack tryInsertInInvSpcReturnForEntItem(TileEntity tile, ItemStack item){
		if(tile==null || !(tile instanceof IInventory))
			return null;
		if(item==null||item.stackSize<=0)
			return null;
		
		IInventory IInvTile;
		IInvTile=((IInventory)tile);
		int maxSlotCount=IInvTile.getSizeInventory();
		
		for(int i = 0; i<maxSlotCount; i++){
			if(IInvTile.getStackInSlot(i)==null){
				IInvTile.setInventorySlotContents(i, item);
				IInvTile.onInventoryChanged();
				return null;
			} else if(IInvTile.getStackInSlot(i).getItem()==item.getItem() && 
					IInvTile.getStackInSlot(i).getItemDamage()==item.getItemDamage() &&
					IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))!=1){
				if(IInvTile.getStackInSlot(i).stackSize<IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))){
					if(item.stackSize + IInvTile.getStackInSlot(i).stackSize <= IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))){
						IInvTile.setInventorySlotContents(i, new ItemStack(IInvTile.getStackInSlot(i).getItem(), IInvTile.getStackInSlot(i).stackSize + item.stackSize ,IInvTile.getStackInSlot(i).getItemDamage()));
						IInvTile.onInventoryChanged();
						return null;
					} else {
						int deducedSize = IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i)) - IInvTile.getStackInSlot(i).stackSize;
						IInvTile.setInventorySlotContents(i, new ItemStack(IInvTile.getStackInSlot(i).getItem(), IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i)) ,IInvTile.getStackInSlot(i).getItemDamage()));
						IInvTile.onInventoryChanged();
						return new ItemStack(item.getItem(), item.stackSize - deducedSize, item.getItemDamage());
					}
				}
			}
		}
		return null;
	}
	
	public static ItemStack tryInsertInInv(TileEntity tile, ItemStack item, byte meta){
		if(tile==null || !(tile instanceof IInventory))
			return item;
		if(item==null||item.stackSize<=0)
			return null;
		
		IInventory IInvTile;
		IInvTile=((IInventory)tile);
		int maxSlotCount=IInvTile.getSizeInventory();
		
		if(tile instanceof ISidedInventory){
			for(int i = 0; i<maxSlotCount; i++){
				ISidedInventory ISidTile = ((ISidedInventory)tile);
				if(ISidTile.isItemValidForSlot(i, item) && ISidTile.canInsertItem(i, item, meta)){
					if(IInvTile.getStackInSlot(i)==null){
						IInvTile.setInventorySlotContents(i, item);
						IInvTile.onInventoryChanged();
						return null;
					} else if(IInvTile.getStackInSlot(i).getItem()==item.getItem() && 
							IInvTile.getStackInSlot(i).getItemDamage()==item.getItemDamage() &&
							IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))!=1){
						if(IInvTile.getStackInSlot(i).stackSize<IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))){
							if(item.stackSize + IInvTile.getStackInSlot(i).stackSize <= IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))){
								IInvTile.setInventorySlotContents(i, new ItemStack(IInvTile.getStackInSlot(i).getItem(), IInvTile.getStackInSlot(i).stackSize + item.stackSize ,IInvTile.getStackInSlot(i).getItemDamage()));
								IInvTile.onInventoryChanged();
								return null;
							} else {
								int deducedSize = IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i)) - IInvTile.getStackInSlot(i).stackSize;
								IInvTile.setInventorySlotContents(i, new ItemStack(IInvTile.getStackInSlot(i).getItem(), IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i)) ,IInvTile.getStackInSlot(i).getItemDamage()));
								IInvTile.onInventoryChanged();
								return new ItemStack(item.getItem(), item.stackSize - deducedSize, item.getItemDamage());
							}
						}
					}
				}
			}
			return item;
		}
		
		for(int i = 0; i<maxSlotCount; i++){
			if(IInvTile.getStackInSlot(i)==null){
				IInvTile.setInventorySlotContents(i, item);
				IInvTile.onInventoryChanged();
				return null;
			} else if(IInvTile.getStackInSlot(i).getItem()==item.getItem() && 
					IInvTile.getStackInSlot(i).getItemDamage()==item.getItemDamage() &&
					IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))!=1){
				if(IInvTile.getStackInSlot(i).stackSize<IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))){
					if(item.stackSize + IInvTile.getStackInSlot(i).stackSize <= IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i))){
						IInvTile.setInventorySlotContents(i, new ItemStack(IInvTile.getStackInSlot(i).getItem(), IInvTile.getStackInSlot(i).stackSize + item.stackSize ,IInvTile.getStackInSlot(i).getItemDamage()));
						IInvTile.onInventoryChanged();
						return null;
					} else {
						int deducedSize = IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i)) - IInvTile.getStackInSlot(i).stackSize;
						IInvTile.setInventorySlotContents(i, new ItemStack(IInvTile.getStackInSlot(i).getItem(), IInvTile.getStackInSlot(i).getItem().getItemStackLimit(IInvTile.getStackInSlot(i)) ,IInvTile.getStackInSlot(i).getItemDamage()));
						IInvTile.onInventoryChanged();
						return new ItemStack(item.getItem(), item.stackSize - deducedSize, item.getItemDamage());
					}
				}
			}
		}
		return item;
	}

	public static ItemStack tryInsertInInvWithSlot(TileEntity tile, ItemStack item, int slot, byte meta){
		if(tile==null || !(tile instanceof IInventory))
			return item;
		if(item==null||item.stackSize<=0)
			return null;
	
		IInventory IInvTile;
		IInvTile=((IInventory)tile);
		
		if(tile instanceof ISidedInventory){
			ISidedInventory ISidTile = ((ISidedInventory)tile);
			if(ISidTile.isItemValidForSlot(slot, item) && ISidTile.canInsertItem(slot, item, meta)){
				if(IInvTile.getStackInSlot(slot)==null){
					IInvTile.setInventorySlotContents(slot, item);
					IInvTile.onInventoryChanged();
					return null;
				} else if(IInvTile.getStackInSlot(slot).getItem()==item.getItem() && 
						IInvTile.getStackInSlot(slot).getItemDamage()==item.getItemDamage() &&
						IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot))!=1){
					if(IInvTile.getStackInSlot(slot).stackSize<IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot))){
						if(item.stackSize + IInvTile.getStackInSlot(slot).stackSize <= IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot))){
							IInvTile.setInventorySlotContents(slot, new ItemStack(IInvTile.getStackInSlot(slot).getItem(), IInvTile.getStackInSlot(slot).stackSize + item.stackSize ,IInvTile.getStackInSlot(slot).getItemDamage()));
							IInvTile.onInventoryChanged();
							return null;
						} else {
							int deducedSize = IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot)) - IInvTile.getStackInSlot(slot).stackSize;
							IInvTile.setInventorySlotContents(slot, new ItemStack(IInvTile.getStackInSlot(slot).getItem(), IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot)) ,IInvTile.getStackInSlot(slot).getItemDamage()));
							IInvTile.onInventoryChanged();
							return new ItemStack(item.getItem(), item.stackSize - deducedSize, item.getItemDamage());
						}
					}
				}
			} else {
				return item;
			}
		}
	
		if(IInvTile.getStackInSlot(slot)==null){
			IInvTile.setInventorySlotContents(slot, item);
			IInvTile.onInventoryChanged();
			return null;
		} else if(IInvTile.getStackInSlot(slot).getItem()==item.getItem() && 
				IInvTile.getStackInSlot(slot).getItemDamage()==item.getItemDamage() &&
				IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot))!=1){
			if(IInvTile.getStackInSlot(slot).stackSize<IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot))){
				if(item.stackSize + IInvTile.getStackInSlot(slot).stackSize <= IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot))){
					IInvTile.setInventorySlotContents(slot, new ItemStack(IInvTile.getStackInSlot(slot).getItem(), IInvTile.getStackInSlot(slot).stackSize + item.stackSize ,IInvTile.getStackInSlot(slot).getItemDamage()));
					IInvTile.onInventoryChanged();
					return null;
				} else {
					int deducedSize = IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot)) - IInvTile.getStackInSlot(slot).stackSize;
					IInvTile.setInventorySlotContents(slot, new ItemStack(IInvTile.getStackInSlot(slot).getItem(), IInvTile.getStackInSlot(slot).getItem().getItemStackLimit(IInvTile.getStackInSlot(slot)) ,IInvTile.getStackInSlot(slot).getItemDamage()));
					IInvTile.onInventoryChanged();
					return new ItemStack(item.getItem(), item.stackSize - deducedSize, item.getItemDamage());
					}
				}
			}
		return item;
	}
   
   public static IInventory getInventory(IInventory inventory) {
       if (inventory instanceof TileEntity) {
               TileEntity te = (TileEntity)inventory;
               return getInventory(te.worldObj, te.xCoord, te.yCoord, te.zCoord);
       }
       return inventory;
   }
   
   public static IInventory getInventory(World world, int x, int y, int z) {
       TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
       if ((tileEntity != null) && ((tileEntity instanceof IInventory))) {
               int blockID = world.getBlockId(x, y, z);
               Block block = Block.blocksList[blockID];
               return (IInventory)tileEntity;
       }
       return null;
   }
   
   public static ItemStack decreaseItemStack(ItemStack par1itemstack, int decrNb){
	   if(par1itemstack.stackSize<=decrNb){
		   return new ItemStack(0,0,0);
	   }
	   return new ItemStack(par1itemstack.getItem(), par1itemstack.stackSize, par1itemstack.getItemDamage());
   }
}
