package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.GuiIds;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TEPlayerLinkedBlock;
import fr.theflogat.technicalWizardry.tileEntity.TETWU;
import fr.theflogat.technicalWizardry.util.Orientation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class PlayerLinkedBlock extends BlockContainer{

	public PlayerLinkedBlock(int id) {
		super(id, Material.iron);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.PlayerLinkedBlock_UnlocalizedName);
		this.setResistance(10);
		this.setHardness(10);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, TechnicalWizardry.instance, GuiIds.PlayerLinkedBlock, world, x, y, z);
		}
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon back;
	@SideOnly(Side.CLIENT)
	public Icon front;
	@SideOnly(Side.CLIENT)
	public Icon sideIc;
	
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata)
    {
    	if(side == metadata){
    		return front;
    	} else if(side == 1 && metadata == 0){
    		return back;
    	} else if(side == 0 && metadata == 1){
    		return back;
    	} else if(side == 2 && metadata == 3){
    		return back;
    	} else if(side == 3 && metadata == 2){
    		return back;
    	}  else if(side == 4 && metadata == 5){
    		return back;
    	}  else if(side == 5 && metadata == 4){
    		return back;
    	} else {
    		return sideIc;
    	}
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon)
    {
    	back = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.PlayerLinkedBlock_UnlocalizedName + "_back");
    	front = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.PlayerLinkedBlock_UnlocalizedName + "_front");
    	sideIc = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.PlayerLinkedBlock_UnlocalizedName + "_side");
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
	
	@Override
	public void breakBlock(World par1World, int par2,int par3,int par4,int par5,int par6){
		TETWU tile =  (TETWU) par1World.getBlockTileEntity(par2, par3, par4);
		tile.dropContents();
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEPlayerLinkedBlock();
	}
}
