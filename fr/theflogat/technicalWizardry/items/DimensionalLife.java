package fr.theflogat.technicalWizardry.items;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DimensionalLife extends Item{

	public DimensionalLife(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.DimensionalLife_UnlocalizedName);
	}

}
