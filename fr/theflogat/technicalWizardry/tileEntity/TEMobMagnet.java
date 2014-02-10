package fr.theflogat.technicalWizardry.tileEntity;

import java.util.List;

import fr.theflogat.technicalWizardry.handler.sync.PacketManager;
import fr.theflogat.technicalWizardry.vec.Vector;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TEMobMagnet extends TETWU{

	public TEMobMagnet() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	public boolean adult = true;

	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
			{
				double x1 = xCoord + 0.5;
				double y1 = yCoord + 0.5;
				double z1 = zCoord + 0.5;
			
				boolean blue = true;
				int speedMod = 2;
				double range = 18;

				AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(x1 - range, yCoord - 4, z1 - range, x1 + range, y1 + range, z1 + range);
				List<EntityLiving> entities = worldObj.getEntitiesWithinAABB(EntityLiving.class, boundingBox);

				for(EntityLiving entity : entities) {
					moveEntity(blue, entity, x1, y1, z1, speedMod);
				}
			}
		}
	}

	private static void moveEntity(boolean blue, EntityLiving entity, double x1, double y1, double z1, int speedMod) {
		double x2 = entity.posX;
		double y2 = entity.posY;
		double z2 = entity.posZ;

		float distanceSqrd = blue ? (float) ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2)) : 1.1F;

		if(distanceSqrd > 1) {
			setEntityMotionFromVector(entity, x1, y1, z1, speedMod * 0.25F);
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
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}
}
