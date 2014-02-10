package fr.theflogat.redstoneFluxControl;

import cofh.api.energy.IEnergyHandler;
import fr.theflogat.redstoneFluxControl.lib.References;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RFReader extends Item{

	public RFReader(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setUnlocalizedName(References.MOD_ID.toLowerCase() + ":" + "RFReader");
		this.setMaxStackSize(1);
	}

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		if(par3World.getBlockTileEntity(par4, par5, par6)instanceof IEnergyHandler && !par3World.isRemote){
			int pow = 0;
			for(ForgeDirection dir: ForgeDirection.VALID_DIRECTIONS){
				pow = Math.max(pow, ((IEnergyHandler)par3World.getBlockTileEntity(par4, par5, par6)).getEnergyStored(dir));
			}
			int maxPow = 0;
			for(ForgeDirection dir: ForgeDirection.VALID_DIRECTIONS){
				maxPow = Math.max(maxPow, ((IEnergyHandler)par3World.getBlockTileEntity(par4, par5, par6)).getMaxEnergyStored(dir));
			}
			par2EntityPlayer.addChatMessage(Integer.toString(pow) + "/" + Integer.toString(maxPow) + "RF");
			return true;
		}
		return false;
    }
	
	public void registerIcons(IconRegister icon){
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + "RFReader");
	}

}
