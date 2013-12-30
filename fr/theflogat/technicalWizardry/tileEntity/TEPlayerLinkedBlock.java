package fr.theflogat.technicalWizardry.tileEntity;

import java.util.List;

import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.items.bound.PlayerLink;
import fr.theflogat.technicalWizardry.util.Coordinates;
import fr.theflogat.technicalWizardry.util.InventoryManagement;
import fr.theflogat.technicalWizardry.util.PlayerUtils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TEPlayerLinkedBlock extends TETWU{
	
	public static int[] x = {0,1};
	public EntityPlayer play;
	public ItemStack[] inv;
	public int refresh = 0;
	
	public TEPlayerLinkedBlock(){
		super(x);
		inv = new ItemStack[3];
	}
	
	@Override
	public void updateEntity(){
		if(getStackInSlot(0)!=null){
			if(getStackInSlot(1)!=null){
				if(((PlayerLink)getStackInSlot(0).getItem()).getOwnerName(getStackInSlot(0))!=null && (refresh%200)==0)
					play = PlayerUtils.getPlayerFromName(((PlayerLink)getStackInSlot(0).getItem()).getOwnerName(getStackInSlot(0)), worldObj);
				if((refresh%200)!=0 && play!=null && (refresh%20)==5){
					setInventorySlotContents(1, getStackInSlot(1).useItemRightClick(worldObj, play));
					//setInventorySlotContents(1, InventoryManagement.decreaseItemStack(getStackInSlot(1), 1));
				}
				if((refresh%200)!=0 && play!=null && (refresh%20)==10){
					Coordinates front = getCoordsInFrontFromOrientation();
					getStackInSlot(1).getItem().onItemUse(getStackInSlot(1), play, worldObj, front.getX(), front.getY(), front.getZ(), 0, 0, 0, 0);
				}
				if((refresh%200)!=0 && play!=null && (refresh%20)==15){
					List<EntityLiving> entities = worldObj.getEntitiesWithinAABB(EntityLiving.class, this.getBoundingBoxFromOrientation());
					if(!entities.isEmpty()){
						for(EntityLiving ent : entities){
							getStackInSlot(1).getItem().hitEntity(getStackInSlot(1), play, ent);
						}
					} else {
						getStackInSlot(1).getItem().hitEntity(getStackInSlot(1), play, null);
					}
				}
			}
		}
		refresh++;
	}
	
	public AxisAlignedBB getBoundingBoxFromOrientation(){
		byte meta = (byte) this.getBlockMetadata();
		if(meta==0){
			return AxisAlignedBB.getBoundingBox(xCoord+0.5, yCoord+0.5-1, zCoord+0.5,xCoord-0.5, yCoord-0.5, zCoord-0.5);
		} else if(meta==1){
			return AxisAlignedBB.getBoundingBox(xCoord+0.5, yCoord+0.5+1, zCoord+0.5,xCoord-0.5, yCoord-0.5, zCoord-0.5);
		} else if(meta==2){
			return AxisAlignedBB.getBoundingBox(xCoord+0.5, yCoord+0.5, zCoord+0.5-1,xCoord-0.5, yCoord-0.5, zCoord-0.5);
		} else if(meta==3){
			return AxisAlignedBB.getBoundingBox(xCoord+0.5, yCoord+0.5, zCoord+0.5+1,xCoord-0.5, yCoord-0.5, zCoord-0.5);
		} else if(meta==4){
			return AxisAlignedBB.getBoundingBox(xCoord+0.5-1, yCoord+0.5, zCoord+0.5,xCoord-0.5, yCoord-0.5, zCoord-0.5);
		} else if(meta==5){
			return AxisAlignedBB.getBoundingBox(xCoord+0.5+1, yCoord+0.5, zCoord+0.5,xCoord-0.5, yCoord-0.5, zCoord-0.5);
		}
		return null;
	}
	
	public Coordinates getCoordsInFrontFromOrientation(){
		byte meta = (byte) this.getBlockMetadata();
		if(meta==0){
			return new Coordinates(xCoord, yCoord-1, zCoord, worldObj);
		} else if(meta==1){
			return new Coordinates(xCoord, yCoord+1, zCoord, worldObj);
		} else if(meta==2){
			return new Coordinates(xCoord, yCoord, zCoord-1, worldObj);
		} else if(meta==3){
			return new Coordinates(xCoord, yCoord, zCoord+1, worldObj);
		} else if(meta==4){
			return new Coordinates(xCoord-1, yCoord, zCoord, worldObj);
		} else if(meta==5){
			return new Coordinates(xCoord+1, yCoord, zCoord, worldObj);
		}
		return null;
	}
	
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		if(i==0)
			return false;
		return true;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		if(i==0)
			return false;
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
		return "PlayerLinkedBlock";
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
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if(i==0 && itemstack.getItem() == ItemObjectTWU.PlayerLink)
			return true;
		if(i!=0)
			return true;
		
		return false;
	}

}
