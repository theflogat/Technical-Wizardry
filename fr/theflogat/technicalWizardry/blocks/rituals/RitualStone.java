package fr.theflogat.technicalWizardry.blocks.rituals;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.lib.GuiIds;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;;

public class RitualStone extends Block{

	public RitualStone(int par1) {
		super(par1, Material.rock);
		this.setHardness(5);
		this.setResistance(5);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName(Names.RitualStone_UnlocalizedName);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(player.getCurrentEquippedItem()!=null){
			if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.Rune && world.getBlockMetadata(x, y, z)!=0){
				world.setBlock(x, y, z, this.blockID, 0, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			} else if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneWater && world.getBlockMetadata(x, y, z)!=1){
				world.setBlock(x, y, z, this.blockID, 1, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneLava && world.getBlockMetadata(x, y, z)!=2){
				world.setBlock(x, y, z, this.blockID,2, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneEarth && world.getBlockMetadata(x, y, z)!=3){
				world.setBlock(x, y, z, this.blockID,3, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneDeath && world.getBlockMetadata(x, y, z)!=4){
				world.setBlock(x, y, z, this.blockID,4, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneLife && world.getBlockMetadata(x, y, z)!=5){
				world.setBlock(x, y, z, this.blockID,5, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneAir && world.getBlockMetadata(x, y, z)!=6){
				world.setBlock(x, y, z, this.blockID,6, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneLight && world.getBlockMetadata(x, y, z)!=7){
				world.setBlock(x, y, z, this.blockID,7, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneObscurous && world.getBlockMetadata(x, y, z)!=8){
				world.setBlock(x, y, z, this.blockID,8, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneChaos_Meta && player.getCurrentEquippedItem().getItemDamage() == 0 && world.getBlockMetadata(x, y, z)!=9){
				world.setBlock(x, y, z, this.blockID,9, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneChaos_Meta && player.getCurrentEquippedItem().getItemDamage() == 1 && world.getBlockMetadata(x, y, z)!=10){
				world.setBlock(x, y, z, this.blockID,10, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneChaos_Meta && player.getCurrentEquippedItem().getItemDamage() == 2 && world.getBlockMetadata(x, y, z)!=11){
				world.setBlock(x, y, z, this.blockID,11, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}else 		if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.RuneChaos_Meta && player.getCurrentEquippedItem().getItemDamage() == 3 && world.getBlockMetadata(x, y, z)!=12){
				world.setBlock(x, y, z, this.blockID,12, 3);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			}
		}
		
		
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public static Icon[] runeIcons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		runeIcons = new Icon[13];
		runeIcons[0] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName);
		runeIcons[1] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_water");
		runeIcons[2] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_fire");
		runeIcons[3] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_earth");
		runeIcons[4] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_death");
		runeIcons[5] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_life");
		runeIcons[6] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_air");
		runeIcons[7] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_light");
		runeIcons[8] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_obscur");
		runeIcons[9] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_liquid");
		runeIcons[10] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_movement");
		runeIcons[11] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_dimensional");
		runeIcons[12] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RitualStone_UnlocalizedName + "_brightness");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(metadata<runeIcons.length)
			return runeIcons[metadata];
		return runeIcons[0];
	}	
}
