package fr.theflogat.technicalWizardry.items.tools;

import com.google.common.collect.Multimap;

import fr.theflogat.technicalWizardry.TechnicalWizardry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemMagicalTool extends ItemTool{
	
	public static final Block[] blocksEffectiveAgainst = {};
	private static boolean canToolBreak = false;
	protected float efficiencyOnProperMaterial;
	protected float dmgVsEntity;
	protected Material[] materialEffAgainst;

	public ItemMagicalTool(int id, float damageVsEntity, float efficiencyOnProperMaterial, Material[] materialEffectiveAgainst) {
		super(id, damageVsEntity, TechnicalWizardry.magic , blocksEffectiveAgainst);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		materialEffAgainst = materialEffectiveAgainst;
		dmgVsEntity = damageVsEntity;
	}
	
	public void setIsBreakable(){
		canToolBreak = true;	
	}
	
	
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if (canToolBreak == true)
    	{
        par1ItemStack.damageItem(1, par3EntityLivingBase);
    	} else {
        par1ItemStack.damageItem(0, par3EntityLivingBase);
    	}
    	return true;
    }
    
    public boolean isFull3D()
    {
        return true;
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }
    
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
    
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.dmgVsEntity, 0));
        return multimap;
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	if(materialEffAgainst!=null){
            for(int i = 0;materialEffAgainst.length>i;i++){
            	if(par2Block.blockMaterial==materialEffAgainst[i]){
            		return efficiencyOnProperMaterial;
            	}
            }
    	}
    	return 1.0F;
    }
    
    public boolean canHarvestBlock(Block par1Block)
    {
        return true;
    }
    
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
}
