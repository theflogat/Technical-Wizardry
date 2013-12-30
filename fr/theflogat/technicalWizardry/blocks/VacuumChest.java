package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.GuiIds;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TETWU;
import fr.theflogat.technicalWizardry.tileEntity.TEVacuumChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VacuumChest extends BlockContainer{

	protected VacuumChest(int id) {
		super(id, Material.iron);
		this.setHardness(5.0F);
		this.setResistance(1);
		this.setStepSound(soundMetalFootstep);
		this.setUnlocalizedName(Names.VacuumChest_UnlocalizedName);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setBlockBounds(0, 0, 0, 1, 0.8F, 1);
	}
	
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = par1World.getBlockId(par2, par3, par4 - 1);
        int i1 = par1World.getBlockId(par2, par3, par4 + 1);
        int j1 = par1World.getBlockId(par2 - 1, par3, par4);
        int k1 = par1World.getBlockId(par2 + 1, par3, par4);
        byte b0 = 0;
        int l1 = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l1 == 0)
        {
            b0 = 2;
        }

        if (l1 == 1)
        {
            b0 = 5;
        }

        if (l1 == 2)
        {
            b0 = 3;
        }

        if (l1 == 3)
        {
            b0 = 4;
        }

        if (l != this.blockID && i1 != this.blockID && j1 != this.blockID && k1 != this.blockID)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
        }
        else
        {
            if ((l == this.blockID || i1 == this.blockID) && (b0 == 4 || b0 == 5))
            {
                if (l == this.blockID)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4 - 1, b0, 3);
                }
                else
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4 + 1, b0, 3);
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
            }

            if ((j1 == this.blockID || k1 == this.blockID) && (b0 == 2 || b0 == 3))
            {
                if (j1 == this.blockID)
                {
                    par1World.setBlockMetadataWithNotify(par2 - 1, par3, par4, b0, 3);
                }
                else
                {
                    par1World.setBlockMetadataWithNotify(par2 + 1, par3, par4, b0, 3);
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
            }
        }
    }
	
    public boolean isOpaqueCube()
    {
        return false;
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, TechnicalWizardry.instance, GuiIds.VacuumChest, world, x, y, z);
		}
		return true;
	}

	@Override
	public void breakBlock(World par1World, int par2,int par3,int par4,int par5,int par6){
		TETWU tile =  (TETWU) par1World.getBlockTileEntity(par2, par3, par4);
		tile.dropContents();
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEVacuumChest();
	}

	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		bottomIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.VacuumChest_UnlocalizedName + "_bottom");
		topIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.VacuumChest_UnlocalizedName + "_top");
		sideIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.VacuumChest_UnlocalizedName + "_side");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side == 0) {
			return bottomIcon;
		} else if(side == 1) {
			return topIcon;
		} else {
			return sideIcon;
		}
	}
}
