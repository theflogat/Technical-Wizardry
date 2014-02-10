package fr.theflogat.securitySwap.content;

import fr.theflogat.securitySwap.SecuritySwap;
import fr.theflogat.securitySwap.lib.config.Ids;
import fr.theflogat.securitySwap.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemSwapper extends Item{

	public ItemSwapper(int id) {
		super(id);
		this.setUnlocalizedName(Names.SecuritySwapItem_UnlocalizedName);
		this.setCreativeTab(SecuritySwap.CreativeTabSSU);
	}
	
	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10){
		if(!par3World.isRemote){
			int var1 = par3World.getBlockId(x, y, z);
			int var2 = par3World.getBlockMetadata(x, y, z);
			
			if(Block.blocksList[var1]instanceof BlockContainer){
				TileEntity tile = par3World.getBlockTileEntity(x, y, z);
				//if(!tile.addOwner(par2EntityPlayer)){
					//par2EntityPlayer.addChatMessage("You could have lost your hand");
				//}
			}
		}
		return false;
    }
}