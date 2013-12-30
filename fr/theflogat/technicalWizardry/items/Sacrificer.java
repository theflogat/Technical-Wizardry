package fr.theflogat.technicalWizardry.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.items.tools.ItemMagicalTool;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


public class Sacrificer extends ItemMagicalTool{
	
	public static int cooldown = 0;
	
	public Sacrificer(int id) {
		super(id, 12, 0, null);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.Sacrificer_UnlocalizedName);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		if (cooldown == 0){
			par3EntityPlayer.setHealth(par3EntityPlayer.getHealth() - 4F);
			par3EntityPlayer.addPotionEffect(new PotionEffect(11, 60 * 20, 2));
			par3EntityPlayer.addPotionEffect(new PotionEffect(12, 60 * 20, 2));
			cooldown = 20*20;
		}
		return par1ItemStack;
	}

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
        if (cooldown != 0){
        	if (!par2World.isRemote){
        		--cooldown;
        	}
        }
		this.setDamage(par1ItemStack, par1ItemStack.getItemDamage()-5);
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if (cooldown != 0)
    		par3List.add("Cooldown : " + cooldown/20 + " s");
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("On right click, will give defensive buffs");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.Sacrificer_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
}
