package fr.theflogat.chemicalPhysics.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.chemicalPhysics.api.BlockObjectCPU;
import fr.theflogat.chemicalPhysics.lib.References;
import fr.theflogat.chemicalPhysics.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class MercuryBucket extends ItemBucket{

	public MercuryBucket(int par1, int par2) {
		super(par1, par2);
		this.setUnlocalizedName(Names.BucketMercury_UnlocalizedName);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.BucketMercury_UnlocalizedName);
	}
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        
        if (movingobjectposition!=null && movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;

            if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
            {
                return par1ItemStack;
            }
    	
	    	if (movingobjectposition.sideHit == 0)
	    	{
	    		--j;
	    	}
	
	    	if (movingobjectposition.sideHit == 1)
	    	{
	    		++j;
	    	}
	
	    	if (movingobjectposition.sideHit == 2)
	    	{
	    		--k;
	    	}
	
	    	if (movingobjectposition.sideHit == 3)
	    	{
	    		++k;
	    	}
	
	    	if (movingobjectposition.sideHit == 4)
	    	{
	    		--i;
	    	}
		
	    	if (movingobjectposition.sideHit == 5)
	    	{
	    		++i;
	    	}
		
		    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
		    {
		        return par1ItemStack;
		    }
		
		    if (!(par2World.getBlockId(i, j, k)<0) && par2World.isAirBlock(i, j, k) && !par2World.isRemote && !par2World.getBlockMaterial(i, j, k).isLiquid())
		    {
		    	par2World.destroyBlock(i, j, k, true);
		    	par2World.setBlock(i, j, k, BlockObjectCPU.BlockFluidMercury.blockID);
		        return new ItemStack(Item.bucketEmpty);
		    }
	
		    return par1ItemStack;
	    }
		return par1ItemStack;
    }
}
