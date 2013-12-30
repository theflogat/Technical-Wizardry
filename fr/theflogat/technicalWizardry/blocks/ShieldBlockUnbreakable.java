package fr.theflogat.technicalWizardry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class ShieldBlockUnbreakable extends Block{
	public ShieldBlockUnbreakable(int id) {
		super(id, Material.iron);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName(Names.ShieldBlockU_UnlocalizedName);
		this.setBlockUnbreakable();
		this.setStepSound(Block.soundMetalFootstep);
	}

	@SideOnly(Side.CLIENT)
	public static Icon Icon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		Icon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.ShieldBlocks);
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
