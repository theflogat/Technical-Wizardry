package fr.theflogat.technicalWizardry.blocks;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.GuiIds;
//import fr.theflogat.technicalWizardry.guis.GuiIds;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TEForge;
import fr.theflogat.technicalWizardry.tileEntity.TETWU;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Forge extends BlockContainer{

	public Forge(int id) {
		super(id, Material.rock);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Forge_UnlocalizedName);
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setLightValue(1F);
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("Used to combine rune and blocks");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
    
	@SideOnly(Side.CLIENT)
	public static Icon bottom_topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		bottom_topIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.Forge_UnlocalizedName + "_bottom_top");
		sideIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.Forge_UnlocalizedName + "_side");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side == 0) {
			return bottom_topIcon;
		} else if(side == 1) {
			return bottom_topIcon;
		} else {
			return sideIcon;
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, TechnicalWizardry.instance, GuiIds.Forge, world, x, y, z);
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
		return new TEForge();
	}
}
