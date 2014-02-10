package fr.theflogat.debugger;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DebuggerBlock extends BlockContainer{

	public DebuggerBlock(int id) {
		super(id, Material.iron);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("DebugBlock");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new DebuggerTile();
	}

}
