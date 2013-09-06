package fr.theflogat.technicalWizardry.items.runes;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;

public class RuneWater  extends Item{
	public RuneWater(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.RuneWater_UnlocalizedName);
	}
}
