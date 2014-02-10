package fr.theflogat.chemicalPhysics.blocks;

import fr.theflogat.chemicalPhysics.ChemicalPhysics;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DistillationTower extends BlockContainer{

	protected DistillationTower(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setResistance(2);
		this.setCreativeTab(ChemicalPhysics.CreativeTabCPU);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
}
