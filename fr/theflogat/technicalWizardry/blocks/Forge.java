package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class Forge extends Block{

	public Forge(int id) {
		super(id, Material.rock);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Forge_UnlocalizedName);
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setLightValue(1F);
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
}
