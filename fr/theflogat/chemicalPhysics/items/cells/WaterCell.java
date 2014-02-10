package fr.theflogat.chemicalPhysics.items.cells;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.chemicalPhysics.ChemicalPhysics;
import fr.theflogat.chemicalPhysics.lib.References;
import fr.theflogat.chemicalPhysics.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class WaterCell extends ItemCell{
	public WaterCell(int id){
		super(id);
		this.setUnlocalizedName(Names.WaterCell_UnlocalizedName);
		this.setCreativeTab(ChemicalPhysics.CreativeTabCPU);
        this.setMaxStackSize(32);
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
