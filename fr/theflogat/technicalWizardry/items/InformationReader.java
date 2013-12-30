package fr.theflogat.technicalWizardry.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TEItemMover;
import fr.theflogat.technicalWizardry.tileEntity.TESpecificItemInserter;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class InformationReader extends Item{

	public InformationReader(int id) {
		super(id);
		this.setUnlocalizedName(Names.InformationReader_UnlocalizedName);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.InformationReader_UnlocalizedName);
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(!par2World.isRemote){
	        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
	
	        if(movingobjectposition == null)
	        	return par1ItemStack;
	        
	        int x = movingobjectposition.blockX;
	        int y = movingobjectposition.blockY;
	        int z = movingobjectposition.blockZ;
	        
	        TileEntity tile = par2World.getBlockTileEntity(x, y, z);
	        
	        if(tile instanceof TEItemInserter){
	        	this.DisplayItemInserter((TEItemInserter) par2World.getBlockTileEntity(x, y, z), par3EntityPlayer);
	        } else if(tile instanceof TESpecificItemInserter){
	        	this.DisplaySpecificItemInserter((TESpecificItemInserter) tile, par3EntityPlayer);
	        }
    	}
    	return par1ItemStack;
    }
    
    public void DisplayItemInserter(TEItemInserter par1tile, EntityPlayer par2EntityPlayer){
    	par2EntityPlayer.addChatMessage("Speed Upgrade:");
    	par2EntityPlayer.addChatMessage(Boolean.toString(par1tile.upgradeSpeed).toUpperCase());
    }
    
    public void DisplaySpecificItemInserter(TESpecificItemInserter par1tile, EntityPlayer par2EntityPlayer){
    	par2EntityPlayer.addChatMessage("Slot (Redstone):");
    	par2EntityPlayer.addChatMessage(Integer.toString(par1tile.getRedsone()));
    	par2EntityPlayer.addChatMessage("Speed Upgrade:");
    	par2EntityPlayer.addChatMessage(Boolean.toString(par1tile.upgradeSpeed).toUpperCase());
    }
    
    public void DisplayItemMover(TEItemMover par1tile, EntityPlayer par2EntityPlayer){
    	
    }
}
