package fr.theflogat.technicalWizardry.lib;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class Formulas extends Item {
	
	
    public Formulas(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
    
    public ItemStack add(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
        
    	MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
    	
        if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;

        	par2World.setBlockToAir(i, j, k);
            
            if (--par1ItemStack.stackSize <= 0)
            {
            	return new ItemStack(Item.bucketWater);
            }

            if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketWater)))
            {
            	par3EntityPlayer.dropPlayerItem(new ItemStack(Item.bucketWater.itemID, 1, 0));
            }
        }
		return par1ItemStack;
    }
}
