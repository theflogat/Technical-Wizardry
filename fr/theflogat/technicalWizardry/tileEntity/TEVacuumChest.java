package fr.theflogat.technicalWizardry.tileEntity;

import java.util.List;

import fr.theflogat.technicalWizardry.util.Coordinates;
import fr.theflogat.technicalWizardry.util.InventoryManagement;
import fr.theflogat.technicalWizardry.util.TWUUtils;
import fr.theflogat.technicalWizardry.vec.Vector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TEVacuumChest extends TETWU{
	
	public ItemStack[] inv;
	public int cooldown = 0;
	
	public TEVacuumChest() {
		super(null);
		inv = new ItemStack[36];
	}
	
	@Override
	public void updateEntity() {
		if(worldObj.isRemote){
			if(checkIfFull()){
				if (worldObj.isRemote) {
                    worldObj.spawnParticle("portal", xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, worldObj.rand.nextDouble() - 0.5, worldObj.rand.nextDouble() - 1.0, worldObj.rand.nextDouble() - 0.5);
				}

				double x1 = xCoord + 0.5;
				double y1 = yCoord + 0.5;
				double z1 = zCoord + 0.5;	
				int range = 20;
				
				AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(x1 - range, y1 - range, z1 - range, x1 + range, y1 + range, z1 + range);
				List<Entity> entities = worldObj.getEntitiesWithinAABB(Entity.class, boundingBox);

            
            
				for (Entity entity : entities) {

                    	if (!entity.isDead	&& entity instanceof EntityItem) {

                    		double x = (Math.abs(xCoord) - Math.abs(entity.posX));
                    		double y = (Math.abs(yCoord) - Math.abs(entity.posY));
                    		double z = (Math.abs(zCoord) - Math.abs(entity.posZ));
                    		
                    		if(x<1 && y<1 && x<1){
                    			entity.motionX = x*-1;
                    			entity.motionY = y*-1;
                    			entity.motionZ = z*-1;
                    		}
                    	}
            	}
			}
		}
        if (!worldObj.isRemote) {
				
        	double x1 = xCoord + 0.5;
        	double y1 = yCoord + 0.5;
        	double z1 = zCoord + 0.5;	
        	int range = 20;
				
        	AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(x1 - range, yCoord - 4, z1 - range, x1 + range, y1 + range, z1 + range);
        	List<Entity> entities = worldObj.getEntitiesWithinAABB(Entity.class, boundingBox);
        	for(Entity entity : entities){
        		if (entity instanceof EntityItem) {
        			ItemStack stack = ((EntityItem)entity).getEntityItem();
        			Coordinates crds = getCoords();
        			crds.setY(crds.getY()+1);
        			TWUUtils.spawnItemStack(crds, InventoryManagement.tryInsertInInvSpcReturnForEntItem(this, stack), worldObj);
        			entity.setDead();
        		}
        	}
	    }
	}

	private static void setEntityMotionFromVector(Entity entity, double x, double y, double z, float modifier) {
		Vector originalPosVector = new Vector(x, y, z);
		Vector entityVector = Vector.fromEntityCenter(entity);
		Vector finalVector = originalPosVector.subtract(entityVector).normalize();
		entity.motionX = finalVector.x * modifier;
		entity.motionY = finalVector.y * modifier;
		entity.motionZ = finalVector.z * modifier;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		int[] side = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
		return side;
	}
	
	public boolean checkIfFull(){
		for(int i = 0; i<this.getSizeInventory();i++){
			if(inv[i]==null)
				return true;
		}
		return false;
	}

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
	public String getInvName() {
		return "VacuumChest";
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
		return true;
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
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		inv[slot] = itemstack;
			
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inv[i];
	}
}
