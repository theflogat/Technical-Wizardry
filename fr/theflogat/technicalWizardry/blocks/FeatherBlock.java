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

public class FeatherBlock extends Block{

	public FeatherBlock(int par1) {
		super(par1, Material.cloth);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.FeatherBlock_UnlocalizedName);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setStepSound(Block.soundClothFootstep);
	}

	@SideOnly(Side.CLIENT)
	public static Icon Icon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		Icon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.FeatherBlock_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side == 0) {
			return Icon;
		} else {
			return Icon;
		}
	}
}
