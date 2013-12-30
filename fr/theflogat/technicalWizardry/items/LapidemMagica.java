package fr.theflogat.technicalWizardry.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class LapidemMagica extends Item{
	public LapidemMagica(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.LapidemMagica_UnlocalizedName);
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	par3List.add("Part of worldgen");
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.LapidemMagica_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
}
