package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.GuiIds;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TEBuffer;
import fr.theflogat.technicalWizardry.tileEntity.TETWU;
import fr.theflogat.technicalWizardry.util.Orientation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Buffer extends BlockContainer{

	protected Buffer(int id) {
		super(id, Material.iron);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Buffer_UnlocalizedName);
		this.setHardness(3F);
		this.setResistance(3F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0F);
	}
	
	@Override
	public void breakBlock(World par1World, int par2,int par3,int par4,int par5,int par6){
		TETWU tile =  (TETWU) par1World.getBlockTileEntity(par2, par3, par4);
		tile.dropContents();
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, TechnicalWizardry.instance, GuiIds.Buffer, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEBuffer();
	}

	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		sideIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.Buffer_UnlocalizedName + "_side");
	}

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata)
    {
    	return sideIcon;
    }
}
