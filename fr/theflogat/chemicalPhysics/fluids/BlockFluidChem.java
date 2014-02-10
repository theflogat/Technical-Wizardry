package fr.theflogat.chemicalPhysics.fluids;

import fr.theflogat.chemicalPhysics.items.cells.ItemCell;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public abstract class BlockFluidChem extends BlockFluidClassic{

	public BlockFluidChem(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
	}

	public abstract ItemCell getCellFromBlock();
}
