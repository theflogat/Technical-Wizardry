package fr.theflogat.technicalWizardry.items;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;

public class JarOfLife  extends Item{
	public JarOfLife(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.JarOfLife_UnlocalizedName);
	}
}
