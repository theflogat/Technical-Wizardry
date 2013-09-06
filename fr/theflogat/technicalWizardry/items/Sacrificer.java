package fr.theflogat.technicalWizardry.items;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;

public class Sacrificer extends Item{
	public Sacrificer(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Sacrificer_UnlocalizedName);
	}
}
