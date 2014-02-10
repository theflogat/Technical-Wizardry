package fr.theflogat.redstoneFluxControl;

import fr.theflogat.redstoneFluxControl.lib.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class PowerBlock extends Block{
	public PowerBlock(int id){
		super(id, Material.iron);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setUnlocalizedName(References.MOD_ID.toLowerCase() + ":" + "RFController");
	}
	
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int par5)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 0){
        	return 0;
        }
        else
        {
        	return 15;
        }
    }
    
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int par5)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 0){
        	return 0;
        }
        else
        {
        	return 15;
        }
    }
    
    public boolean canProvidePower()
    {
        return true;
    }
}
