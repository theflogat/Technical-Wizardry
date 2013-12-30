package fr.theflogat.technicalWizardry.entity;

import net.minecraft.entity.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class MagicTransportationAeroplane extends Entity{

	public MagicTransportationAeroplane(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
	    return EnumCreatureAttribute.UNDEFINED;
	}
	
    public AxisAlignedBB getBoundingBox(){
    	return AxisAlignedBB.getBoundingBox(10, 4, 5, 1, 1, 1);
    }

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}

}
