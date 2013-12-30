package fr.theflogat.technicalWizardry.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.items.tools.ItemMagicalTool;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class SmoothCutter extends ItemMagicalTool{

    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator};
    public static int repaircount = 0;
    public static int dmgVSEntity = 0;
    
	public SmoothCutter(int id) {
		super(id, dmgVSEntity, 37F, null);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.SmoothCutter_UnlocalizedName);
	}
	
	@Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block.blockMaterial != Material.ground && par2Block.blockMaterial != Material.grass){ 
        	return 60.0F;
        } else {
        	return 2.0F;
        }
    }
	
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	par3List.add("Appreciated for its auto-repair");
    	par3List.add("and fast mining abilities");
    	if(Keyboard.isKeyDown(42)){
    		par3List.add("On right-click will give Haste");
    	} else {
    		par3List.add("--Press Shift For More Info--");
    	}
    }
	
	
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
        if (!par2World.isRemote){
        	++repaircount;
        	if ((repaircount%20)== 0)
        		this.setDamage(par1ItemStack, par1ItemStack.getItemDamage()-5);
        }
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(!par2World.isRemote)
    	{
    		if((par1ItemStack.getItemDamage()+100)<1561) {
    			par3EntityPlayer.addPotionEffect(new PotionEffect(3, 30 * 20, 1)); 
    			par1ItemStack.setItemDamage(par1ItemStack.getItemDamage()+150);
    		}
    	}
		return par1ItemStack;
		
	}
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.SmoothCutter_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return itemIcon;
	}
}
