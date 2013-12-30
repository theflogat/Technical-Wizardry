package fr.theflogat.technicalWizardry.items.bound;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PoweredBoundItems extends BoundItem{
	
	public PoweredBoundItems(int id){
		super(id);
	}
	
	  public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		  super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
		  
		  return par1ItemStack;
	  }
}
