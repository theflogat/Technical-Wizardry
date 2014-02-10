package fr.theflogat.technicalWizardry.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Projectile extends Entity implements IProjectile{

	private static final String TAG_MOTION_X = "motionX";
	private static final String TAG_MOTION_Y = "motionY";
	private static final String TAG_MOTION_Z = "motionZ";
	
	public Projectile(World world) {
		super(world);
	}
	
	public Projectile(World world, double x, double y, double z, EntityPlayer ent){
		this(world);
		
		posX= x;
		posY = y;
		posZ = z;
		
		this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
	}

	@Override
	protected void entityInit() {
		
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound comp) {
		motionX = comp.getDouble(TAG_MOTION_X);
		motionY = comp.getDouble(TAG_MOTION_Y);
		motionZ = comp.getDouble(TAG_MOTION_Z);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound comp) {
		comp.setDouble(TAG_MOTION_X, motionX);
		comp.setDouble(TAG_MOTION_Y, motionY);
		comp.setDouble(TAG_MOTION_Z, motionZ);
	}

	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
        float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)f2;
        par3 /= (double)f2;
        par5 /= (double)f2;
        par1 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par3 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par5 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f3) * 180.0D / Math.PI);
	}

}
