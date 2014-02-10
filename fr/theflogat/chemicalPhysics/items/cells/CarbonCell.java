package fr.theflogat.chemicalPhysics.items.cells;

import fr.theflogat.chemicalPhysics.ChemicalPhysics;
import fr.theflogat.chemicalPhysics.lib.config.Names;
import net.minecraft.item.Item;

public class CarbonCell extends ItemCell{

	public CarbonCell(int id) {
		super(id);
		this.setUnlocalizedName(Names.ElementsCell_UnlocalizedName[5]);
		this.setCreativeTab(ChemicalPhysics.CreativeTabCPU);
        this.setMaxStackSize(32);
	}

}