package fr.theflogat.technicalWizardry.blocks;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.Numbers;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ShieldBlock extends Block{
	public ShieldBlock(int id) {
		super(id, Material.iron);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.ShieldBlock_UnlocalizedName);
		this.setHardness(100.0F);
		this.setResistance(100.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("Highly blast-resistant block");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
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