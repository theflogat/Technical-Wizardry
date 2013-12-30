package fr.theflogat.technicalWizardry.blocks;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.items.Items;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class LapidemMagicaOre extends Block{

	public LapidemMagicaOre(int id) {
		super(id, Material.rock);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.LapidemMagicaOre_UnlocalizedName);
		this.setHardness(4F);
		this.setResistance(4F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("Ore that generates in the Overworld");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ItemObjectTWU.LapidemMagica.itemID;
    }
    
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0)
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }
    
	@SideOnly(Side.CLIENT)
	public static Icon Icon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		Icon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.LapidemMagicaOre_UnlocalizedName);
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
