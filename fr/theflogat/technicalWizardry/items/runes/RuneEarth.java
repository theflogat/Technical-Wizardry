package fr.theflogat.technicalWizardry.items.runes;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;

public class RuneEarth extends Item{

	public RuneEarth(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.RuneEarth_UnlocalizedName);
	}

}
