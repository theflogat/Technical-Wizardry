package fr.theflogat.technicalWizardry.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class MovementAmulet extends Item{
	
	private static int length[] = {20, 40, 60, 80, 100, 120 , 140, 160, 180};
	
	public MovementAmulet(int id) {
		super(id);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
	}
	
    public CreativeTabs getCreativeTab()
    {
        return TechnicalWizardry.CreativeTabTWU;
    }
    
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return	Names.MovementAmulet_MetaUnlocalizedName[itemstack.getItemDamage()];
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(!par2World.isRemote)
    	{
    		par3EntityPlayer.addPotionEffect(new PotionEffect(1, length[par1ItemStack.getItemDamage()] * 20, (1 + par1ItemStack.getItemDamage())));
    		par3EntityPlayer.addPotionEffect(new PotionEffect(8, length[par1ItemStack.getItemDamage()] * 20, (1 + par1ItemStack.getItemDamage())));
    	}
		return par1ItemStack;
	}
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	par3List.add("Tier : " + (1 + par1ItemStack.getItemDamage()));
    	if(Keyboard.isKeyDown(42)){
        	par3List.add("Makes you go faster");
        	par3List.add("To upgrade: same recipe");
        	par3List.add("with this instead in the middle");
        	par3List.add("Up to tier 8");	
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.MovementAmulet_MetaUnlocalizedName[0]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < Names.MovementAmulet_MetaItemName.length; i++) {
			ItemStack itemstack = new ItemStack(id, 1, i);
			list.add(itemstack);
		}
	}
}
