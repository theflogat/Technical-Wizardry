package fr.theflogat.technicalWizardry.items.runes;

import java.util.Random;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.events.FillRuneEvent;
import fr.theflogat.technicalWizardry.items.Items;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class Rune extends Item{

	public static int metatdata = 0;
	
	public Rune(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Rune_UnlocalizedName);
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        boolean flag = this.metatdata == 0;
        
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }
        else
        {
            FillRuneEvent event = new FillRuneEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
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

                if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                {
                    return par1ItemStack;
                }

                if (this.metatdata == 0)
                {
                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
                    {
                        par2World.setBlockToAir(i, j, k);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(Items.RuneWater);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneWater)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneWater, 1, 0));
                        }

                        return par1ItemStack;
                    }

                    if (par2World.getBlockMaterial(i, j, k) == Material.lava && par2World.getBlockMetadata(i, j, k) == 0)
                    {
                        par2World.setBlockToAir(i, j, k);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(Items.RuneLava);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneLava)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneLava, 1, 0));
                        }

                        return par1ItemStack;
                    }
                    if (par2World.getBlockId(i, j, k) == Block.grass.blockID && par2World.getBlockMetadata(i, j, k) == 0) {
                    	
                    	par2World.setBlockToAir(i, j, k);
                    	
                        if (--par1ItemStack.stackSize <= 0)
                        {
                        	return new ItemStack(Items.RuneEarth);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneEarth)))
                        {
                        	par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneEarth, 1, 0));
                        }	
                    	
                        return par1ItemStack;
                    }
                    
                    if (par2World.getBlockId(i, j, k) == Block.wood.blockID || par2World.getBlockId(i, j, k) == Block.sapling.blockID || par2World.getBlockId(i, j, k) == Block.grass.blockID) {
                    	
                    	par2World.setBlockToAir(i, j, k);
                    	
                        if (--par1ItemStack.stackSize <= 0)
                        {
                        	return new ItemStack(Items.RuneLife);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneLife)))
                        {
                        	par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneLife, 1, 0));
                        }	
                    	
                        return par1ItemStack;
                    }
                    if (par2World.getBlockId(i, j, k) == Block.slowSand.blockID || par2World.getBlockId(i, j, k) == Block.netherBrick.blockID){
                    	
                    	par2World.setBlockToAir(i, j, k);
                    	
                        if (--par1ItemStack.stackSize <= 0)
                        {
                        	return new ItemStack(Items.RuneDeath);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneDeath)))
                        {
                        	par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneDeath, 1, 0));
                        }	
                    	
                        return par1ItemStack;
                    }
                    if (par2World.getBlockId(i, j, k) == Ids.actualFeatherBlock){
                    	
                    	par2World.setBlockToAir(i, j, k);
                    	
                        if (--par1ItemStack.stackSize <= 0)
                        {
                        	return new ItemStack(Items.RuneAir);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneAir)))
                        {
                        	par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneAir, 1, 0));
                        }	
                    	
                        return par1ItemStack;
                    }
                    if (par2World.getBlockId(i, j, k) == Block.obsidian.blockID){
                    	
                    	par2World.setBlockToAir(i, j, k);
                    	
                        if (--par1ItemStack.stackSize <= 0)
                        {
                        	return new ItemStack(Items.RuneObscurous);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneObscurous)))
                        {
                        	par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneObscurous, 1, 0));
                        }	
                    	
                        return par1ItemStack;
                    }
                    if (par2World.getBlockId(i, j, k) == Block.glowStone.blockID){
                    	
                    	par2World.setBlockToAir(i, j, k);
                    	
                        if (--par1ItemStack.stackSize <= 0)
                        {
                        	return new ItemStack(Items.RuneLight);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.RuneLight)))
                        {
                        	par3EntityPlayer.dropPlayerItem(new ItemStack(Ids.actualRuneLight, 1, 0));
                        }	
                    	
                        return par1ItemStack;
                    }
                }
            }
        }
		return par1ItemStack;
    }
}
