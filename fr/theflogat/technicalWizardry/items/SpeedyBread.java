package fr.theflogat.technicalWizardry.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class SpeedyBread extends ItemFood{
	
	private final int healAmount;
    private final float saturationModifier;
    private boolean alwaysEdible;
    
	public SpeedyBread(int id) {
		super(id, id, true);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.SpeedyBread_UnlocalizedName);
		this.healAmount = 20;
		this.saturationModifier = 6;
		this.alwaysEdible = true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.SpeedyBread_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
	
    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par2World.isRemote)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(1, 60 * 20, 1));
            par3EntityPlayer.addPotionEffect(new PotionEffect(8, 60 * 20, 1));  
        }
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("Get rid of hunger");
    		par3List.add("and go faster");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
}
