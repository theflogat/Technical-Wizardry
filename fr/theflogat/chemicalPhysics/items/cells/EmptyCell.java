package fr.theflogat.chemicalPhysics.items.cells;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.chemicalPhysics.ChemicalPhysics;
import fr.theflogat.chemicalPhysics.api.ItemObjectCPU;
import fr.theflogat.chemicalPhysics.items.Items;
import fr.theflogat.chemicalPhysics.lib.References;
import fr.theflogat.chemicalPhysics.lib.config.Ids;
import fr.theflogat.chemicalPhysics.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class EmptyCell extends Item{
	
	public EmptyCell(int id) {
		super(id);
		this.setUnlocalizedName(Names.EmptyCell_UnlocalizedName);
		this.setCreativeTab(ChemicalPhysics.CreativeTabCPU);
	}
	

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        boolean flag = true;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                {
                    return par1ItemStack;
                }
                if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                {
                	return par1ItemStack;
                }

                if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
                {
                	par2World.setBlockToAir(i, j, k);

                	if (--par1ItemStack.stackSize <= 0)
                	{
                		return new ItemStack(ItemObjectCPU.WaterCell);
                	}

                	if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectCPU.WaterCell)))
                	{
                		par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualWaterCell, 1, 0));
                	}

                	return par1ItemStack;
                }

                if (par2World.getBlockMaterial(i, j, k) == Material.lava && par2World.getBlockMetadata(i, j, k) == 0)
                {
                	par2World.setBlockToAir(i, j, k);

                	if (--par1ItemStack.stackSize <= 0)
                	{
                		return new ItemStack(ItemObjectCPU.LavaCell);
                	}

                	if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectCPU.LavaCell)))
                	{
                		par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualLavaCell, 1, 0));
                	}

                	return par1ItemStack;
                }
               
            }
            return par1ItemStack;
        }
    
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.EmptyCell_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
}
