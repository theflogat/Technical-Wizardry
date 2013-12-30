package fr.theflogat.technicalWizardry.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.entity.MagicTransportationAeroplane;
import fr.theflogat.technicalWizardry.events.ItemSpeedUpgradeTWUEvent;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TESpecificItemInserter;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;

public class SpeedUpgrade extends Item {

	public SpeedUpgrade(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.SpeedUpgrade_UnlocalizedName);
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }
        else
        {
        	ItemSpeedUpgradeTWUEvent event = new ItemSpeedUpgradeTWUEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return par1ItemStack;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                if (par3EntityPlayer.capabilities.isCreativeMode)
                {
                    return par1ItemStack;
                }

                if (--par1ItemStack.stackSize <= 0)
                {
                    return event.result;
                }

                if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
                {
                    par3EntityPlayer.dropPlayerItem(event.result);
                }

                return par1ItemStack;
            }

            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (true)
                {
                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                	if(par2World.getBlockTileEntity(i, j, k) instanceof TEItemInserter){
                		boolean success = ((TEItemInserter) par2World.getBlockTileEntity(i, j, k)).setUpgrade();
                		if(success){
                			if(par1ItemStack.stackSize ==1){
                				return new ItemStack(0,0,0);
                			} else {
                    			return new ItemStack(par1ItemStack.getItem(),par1ItemStack.stackSize-1,par1ItemStack.getItemDamage());
                			}
                		}
                	} else if(par2World.getBlockTileEntity(i, j, k)instanceof TESpecificItemInserter){
                		boolean success = ((TESpecificItemInserter) par2World.getBlockTileEntity(i, j, k)).setUpgrade();
                		if(success){
                			if(par1ItemStack.stackSize ==1){
                				return new ItemStack(0,0,0);
                			} else {
                    			return new ItemStack(par1ItemStack.getItem(),par1ItemStack.stackSize-1,par1ItemStack.getItemDamage());
                			}
                		}
                	}
                }
            }
        }
		return par1ItemStack;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.SpeedUpgrade_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
}
