package fr.theflogat.technicalWizardry.handler;

import fr.theflogat.technicalWizardry.lib.config.Ids;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTWU extends CreativeTabs{
	public CreativeTabTWU(int id, String name) {
		super(id, name);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Ids.actualForge;
	}
}
