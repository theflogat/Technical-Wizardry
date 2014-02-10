package fr.theflogat.redstoneFluxControl;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.redstoneFluxControl.lib.Ids;
import fr.theflogat.redstoneFluxControl.lib.References;
import fr.theflogat.technicalWizardry.util.Orientation;

public class RFControllerBlock extends BlockContainer{

	protected RFControllerBlock(int id) {
		super(id, Material.iron);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setUnlocalizedName(References.MOD_ID.toLowerCase() + ":" + "RFController");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TERFController();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y,int z, EntityPlayer player, int side, float hitx,	float hity, float hitz) {
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, RedstoneFluxControl.instance, Ids.guiControllerId, world, x, y, z);
		}		
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	private Icon sideIc;
	@SideOnly(Side.CLIENT)
	private Icon top;
	@SideOnly(Side.CLIENT)
	private Icon bottom;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg) {
		sideIc = reg.registerIcon(References.MOD_ID.toLowerCase() + ":" + "RFC");
		top = reg.registerIcon(References.MOD_ID.toLowerCase() + ":" + "RFC" + "_top");
		bottom = reg.registerIcon(References.MOD_ID.toLowerCase() + ":" + "RFC" + "_bottom");
	}
	
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
    	int metadata = meta%10;
    	
    	
    	if(side == metadata){
    		return top;
    	} else if(side == 1 && metadata == 0){
    		return bottom;
    	} else if(side == 0 && metadata == 1){
    		return bottom;
    	} else if(side == 2 && metadata == 3){
    		return bottom;
    	} else if(side == 3 && metadata == 2){
    		return bottom;
    	}  else if(side == 4 && metadata == 5){
    		return bottom;
    	}  else if(side == 5 && metadata == 4){
    		return bottom;
    	} else {
    		return sideIc;
    	}
    	
    }
	
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }
    
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
	
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = Orientation.determineOrientation(par1World, par2, par3, par4, par5EntityLivingBase);
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }
}
