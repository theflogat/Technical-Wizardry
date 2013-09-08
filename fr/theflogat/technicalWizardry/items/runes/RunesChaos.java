package fr.theflogat.technicalWizardry.items.runes;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class RunesChaos extends Item{

	public RunesChaos(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return	Names.RuneChaos_MetaUnlocalizedName[itemstack.getItemDamage()];
	}

	Icon[] icons = new Icon[Names.RuneChaos_MetaUnlocalizedName.length];
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		for(int i = 0; i < icons.length; i++) {
			icons[i] = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RuneChaos_MetaUnlocalizedName[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return icons[damage];
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < icons.length; i++) {
			ItemStack itemstack = new ItemStack(id, 1, i);
			list.add(itemstack);
		}
	}
}
