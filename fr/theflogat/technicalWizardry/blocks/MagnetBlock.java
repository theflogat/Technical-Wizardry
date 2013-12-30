package fr.theflogat.technicalWizardry.blocks;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.tileEntity.TEMagnet;
import fr.theflogat.technicalWizardry.tileEntity.TEMobMagnet;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class MagnetBlock extends BlockContainer{
	
	Random random;
	
	public MagnetBlock(int par1) {
		super(par1, Material.iron);
		this.setHardness(15F);
		this.setResistance(30F);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.MagnetBlock_UnlocalizedName);
		this.setStepSound(Block.soundMetalFootstep);
		this.setLightValue(0F);
		}  
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		return false;
	}
	
	public TileEntity createTileEntity(World world) {
		return new TEMobMagnet();
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("Draws monster nearby in an 18x18x3 range");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
	
	@SideOnly(Side.CLIENT)
	public static Icon top_Icon;
	@SideOnly(Side.CLIENT)
	public static Icon bottom_Icon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		top_Icon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.MagnetBlock_UnlocalizedName + "_top");
		bottom_Icon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.MagnetBlock_UnlocalizedName + "_bottom");
		sideIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.MagnetBlock_UnlocalizedName + "_side");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side == 0) {
			return bottom_Icon;
		} else if(side == 1) {
			return top_Icon;
		} else {
			return sideIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEMobMagnet();
	}
}
