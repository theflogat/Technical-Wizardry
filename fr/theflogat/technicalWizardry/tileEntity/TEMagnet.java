package fr.theflogat.technicalWizardry.tileEntity;

import java.util.List;

import fr.theflogat.technicalWizardry.vec.Vector;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TEMagnet extends TETWU {

	public TEMagnet() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateEntity() {
		double x1 = xCoord + 0.5;
		double y1 = yCoord + 0.5;
		double z1 = zCoord + 0.5;

		boolean blue = getBlockMetadata() == 0;
		int speedMod = blue ? 1 : -1;
		double range = 18;

		AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(x1 - range, yCoord - 3, z1 - range, x1 + range, y1 + range, z1 + range);
		List<Entity> entities = worldObj.selectEntitiesWithinAABB(Entity.class, boundingBox, getEntitySelector());

		for(Entity entity : entities) {
			double x2 = entity.posX;
			double y2 = entity.posY;
			double z2 = entity.posZ;

			float distanceSqrd = blue ? (float) ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2)) : 1.1F;

			if(distanceSqrd > 1) {
                setEntityMotionFromVector(entity, new Vector(x1, y1, z1), speedMod * 0.25F);
     		}
     	}
}

	private IEntitySelector getEntitySelector() {
        return new IEntitySelector() {

            @Override
            public boolean isEntityApplicable(Entity entity) {
                    return entity instanceof EntityItem;
            }

        };
	}

	private static void setEntityMotionFromVector(Entity entity, Vector originalPosVector, float modifier) {
        Vector entityVector = Vector.fromEntityCenter(entity);
        Vector finalVector = originalPosVector.copy().subtract(entityVector);

        if(finalVector.mag() > 1)
                finalVector.normalize();

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
