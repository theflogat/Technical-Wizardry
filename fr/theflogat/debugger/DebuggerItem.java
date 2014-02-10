package fr.theflogat.debugger;

import fr.theflogat.chemicalPhysics.tileEntity.TileEntityCPU;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DebuggerItem extends Item{

	public DebuggerItem(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("itemDebug");
	}
	
	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		/*if(par3World.getBlockTileEntity(par4, par5, par6)instanceof TileEntityCPU && !par3World.isRemote){
			par2EntityPlayer.addChatMessage(Integer.toString(((TileEntityCPU)par3World.getBlockTileEntity(par4, par5, par6))
					.getEnergyStored(null)));
			}*/
        //par2EntityPlayer.addChatMessage(Integer.toString(par3World.getBlockMetadata(par5, par6, par7)));
		if(!par3World.isRemote){
			for(int i = 0;i<10;i++){
				//par2EntityPlayer.addChatMessage(par3World.getBlockTileEntity(par4, par5, par6).ownerName[i]);
			}
		}
		return false;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		
		
		return par1ItemStack; 
	}
}
