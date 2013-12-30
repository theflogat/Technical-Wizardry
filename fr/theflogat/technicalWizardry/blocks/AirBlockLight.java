package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class AirBlockLight extends Block{

	public AirBlockLight(int id) {
		super(id, Material.air);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.AirBlockLight_UnlocalizedName);
		this.setLightValue(15);
	}
    
    @Override
    public boolean isAirBlock(World world, int x, int y, int z)
    {
        return true;
    }
    
    public boolean canCollideCheck(int par1, boolean par2)
    {
        return false;
    }
    
    public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z)
    {
        return false;
    }
    
    public boolean isCollidable()
    {
    	return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock(){
    	return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return -1;
    }
    
	@SideOnly(Side.CLIENT)
	public static Icon Sicon;
	@SideOnly(Side.CLIENT)
	public static Icon bottom_Icon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		bottom_Icon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.AirMomentumBlockPlusZ_UnlocalizedName + "_bottom");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		return Sicon;
	}
}
