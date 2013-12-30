package fr.theflogat.technicalWizardry.items.runes;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class RuneAssembler extends Item{
	public RuneAssembler(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.RuneAssembler_UnlocalizedName);
		this.maxStackSize = 1;
		this.setContainerItem(this);
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("Used to combine runes.");
    		par3List.add("Does not get used up");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
	
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return false;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.RuneAssembler_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
}
