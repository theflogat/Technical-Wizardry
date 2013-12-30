package fr.theflogat.technicalWizardry.items.bound;

import java.util.List;
import java.util.logging.Level;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.LogHelper;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.world.World;

public class BoundItem extends Item{

	public String TAG_PLAYER_NAME = "playerName";
	public String playerName;
	
	public BoundItem(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setMaxStackSize(1);
	}
	
	  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	  {
		  if (par1ItemStack.stackTagCompound!=null){
			  par3List.add("Currently Bounded To: " + par1ItemStack.stackTagCompound.getString(TAG_PLAYER_NAME));
		  }
	  }

	  public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	  {
		    if (par1ItemStack.stackTagCompound == null)
		    {
		    	par1ItemStack.setTagCompound(new NBTTagCompound());
		    }

		    if (par1ItemStack.stackTagCompound.getString(TAG_PLAYER_NAME).equals(""))
		    {
		    	par1ItemStack.stackTagCompound.setString(TAG_PLAYER_NAME, par3EntityPlayer.getEntityName());
		    }
		    
		    return par1ItemStack;
	  }
	
	  public String getOwnerName(ItemStack par1Itemstack)
	  {
	    if (par1Itemstack.stackTagCompound == null)
	    {
	      par1Itemstack.setTagCompound(new NBTTagCompound());
	      return null;
	    }

	    return par1Itemstack.stackTagCompound.getString(TAG_PLAYER_NAME);
	  }
}
