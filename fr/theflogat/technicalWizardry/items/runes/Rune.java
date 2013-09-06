package fr.theflogat.technicalWizardry.items.runes;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;

public class Rune extends Item{
	public Rune(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Rune_UnlocalizedName);
	}
}
