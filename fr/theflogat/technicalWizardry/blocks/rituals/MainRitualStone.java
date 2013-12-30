package fr.theflogat.technicalWizardry.blocks.rituals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class MainRitualStone extends BlockContainer{

	public MainRitualStone(int id) {
		super(id, Material.iron);
		this.setHardness(40);
		this.setResistance(40);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName(Names.MainRitualStone_UnlocalizedName);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
	}
  
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public static Icon runeIcons; 
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		runeIcons = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.MainRitualStone_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		return runeIcons;
	}

}
