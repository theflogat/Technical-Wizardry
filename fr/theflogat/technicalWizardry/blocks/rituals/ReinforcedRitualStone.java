package fr.theflogat.technicalWizardry.blocks.rituals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ReinforcedRitualStone extends Block{

	public ReinforcedRitualStone(int id) {
		super(id, Material.rock);
		this.setHardness(40);
		this.setResistance(40);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName(Names.ReinforcedRitualStone_UnlocalizedName);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(player.getCurrentEquippedItem()!=null){
			if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.LapidemMagica && world.getBlockMetadata(x, y, z)!=1){
				world.setBlock(x, y, z, this.blockID, 1, 2);
				if(player.getCurrentEquippedItem().stackSize-1!=0){
					player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(player.getCurrentEquippedItem().getItem(), player.getCurrentEquippedItem().stackSize - 1, player.getCurrentEquippedItem().getItemDamage());
				} else {
					player.inventory.mainInventory[player.inventory.currentItem] = null;
				}
				return true;
			} else if(player.getCurrentEquippedItem().getItem()== ItemObjectTWU.Rune && world.getBlockMetadata(x, y, z)!=0){
				world.setBlock(x, y, z, this.blockID, 0, 2);
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
		runeIcons = new Icon[2];
		runeIcons[0] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.ReinforcedRitualStone_UnlocalizedName);
		runeIcons[1] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.ReinforcedRitualStone_UnlocalizedName + "_magic");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(metadata<runeIcons.length)
			return runeIcons[metadata];
		return runeIcons[0];
	}
}
