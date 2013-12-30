package fr.theflogat.technicalWizardry.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RuneValueHelper {
	
	/**
	 * 
	 * @param blockId
	 * @param blockMeta
	 * @return ItemStack
	 * 
	 * Gets The Corresponding Rune From ID & Metadata
	 */
	public static ItemStack evaluation(int blockId, int blockMeta){
		for(int a = 0;a<BlockRuneAssigner.itsLength();a++){
    		if(blockId == BlockRuneAssigner.getAllIds()[a]){
    			if(BlockRuneAssigner.getAllMeta()[a] == blockMeta){
    				switch(BlockRuneAssigner.getAllValues()[a]){
    				case AIR:
    					return new ItemStack(ItemObjectTWU.RuneAir);
					case DEATH:
    					return new ItemStack(ItemObjectTWU.RuneDeath);
					case EARTH:
    					return new ItemStack(ItemObjectTWU.RuneEarth);
					case LAVA:
    					return new ItemStack(ItemObjectTWU.RuneLava);
					case LIFE:
    					return new ItemStack(ItemObjectTWU.RuneLife);
    				case LIGHT:
    					return new ItemStack(ItemObjectTWU.RuneLight);
    				case OBSCUR:
    					return new ItemStack(ItemObjectTWU.RuneObscurous);
    				case WATER:
    					return new ItemStack(ItemObjectTWU.RuneWater);
        			}//END of Switch	
    			}
    		}
		}
		return null;
	}
	
	/**
	 * 
	 * @param par1ItemStack
	 * @param par2World
	 * @param par3EntityPlayer
	 * @param x
	 * @param y
	 * @param z
	 * @return ItemStack
	 * 
	 * Only used for the rune itself
	 * Sets the right-clicked block to air
	 * and returns the corresponding rune
	 */
	
	public static ItemStack evaluation(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int x, int y, int z){
		for(int a = 0;a<BlockRuneAssigner.itsLength();a++){
    		if(par2World.getBlockId(x, y, z) == BlockRuneAssigner.getAllIds()[a]){
    			if(BlockRuneAssigner.getAllMeta()[a]==par2World.getBlockMetadata(x, y, z)){
    				switch(BlockRuneAssigner.getAllValues()[a]){
    				case AIR:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneAir);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneAir)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneAir.itemID, 1, 0));
                        }
                        break;
    				case DEATH:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneDeath);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneDeath)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneDeath.itemID, 1, 0));
                        }
                        break;
    				case EARTH:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneEarth);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneEarth)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneEarth.itemID, 1, 0));
                        }
                        break;
    				case LAVA:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneLava);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneLava)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneLava.itemID, 1, 0));
                        }
                        break;
    				case LIFE:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneLife);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneLife)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneLife.itemID, 1, 0));
                        }
                        break;
    				case LIGHT:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneLight);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneLight)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneLight.itemID, 1, 0));
                        }
                        break;
    				case OBSCUR:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneObscurous);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneObscurous)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneObscurous.itemID, 1, 0));
                        }
                        break;
    				case WATER:
                        par2World.setBlockToAir(x, y, z);

                        if (--par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(ItemObjectTWU.RuneWater);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemObjectTWU.RuneWater)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(ItemObjectTWU.RuneWater.itemID, 1, 0));
                        }
                        break;
        			}//END of Switch	
    			}
    		}
		}
		return par1ItemStack;
	}
	
	public static boolean hasValue(ItemStack itemstack){
		for(int a = 0;a<BlockRuneAssigner.itsLength();a++){
    		if(itemstack.itemID == BlockRuneAssigner.getAllIds()[a]){
    			if(BlockRuneAssigner.getAllMeta()[a]== itemstack.getItemDamage()){
    				return true;
    			}
    		}
		}
		return false;
	}
}
