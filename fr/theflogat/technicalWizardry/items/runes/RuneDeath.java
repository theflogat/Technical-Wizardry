package fr.theflogat.technicalWizardry.items.runes;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;

public class RuneDeath extends Item{

	public RuneDeath(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.RuneDeath_UnlocalizedName);
	}

}
