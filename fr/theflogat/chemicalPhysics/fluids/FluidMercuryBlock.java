package fr.theflogat.chemicalPhysics.fluids;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.chemicalPhysics.api.BlockObjectCPU;
import fr.theflogat.chemicalPhysics.handler.MaterialCoolFluid;
import fr.theflogat.chemicalPhysics.items.cells.ItemCell;
import fr.theflogat.chemicalPhysics.lib.References;
import fr.theflogat.chemicalPhysics.lib.config.Names;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidMercuryBlock extends BlockFluidChem{

	public FluidMercuryBlock(int id) {
		super(id, BlockObjectCPU.FluidMercury, new MaterialCoolFluid(MapColor.stoneColor));
	}
	
	  @SideOnly(Side.CLIENT)
	  public Icon getIcon(int side, int meta)
	  {
	    return this.blockIcon;
	  }

	  @SideOnly(Side.CLIENT)
	  public void registerIcons(IconRegister iconRegister)
	  {
	    this.blockIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.FluidMercury_UnlocalizedName + "_still");
	    getFluid().setIcons(this.blockIcon);
	  }

	  public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	  {
	    if (world.getBlockMaterial(x, y, z).isLiquid()) return false;
	    return super.canDisplace(world, x, y, z);
	  }

	  public boolean displaceIfPossible(World world, int x, int y, int z)
	  {
	    if (world.getBlockMaterial(x, y, z).isLiquid()) return false;
	    return super.displaceIfPossible(world, x, y, z);
	  }
	  
	  public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	  {
		  par5Entity.onGround = true;
		  par5Entity.motionX *= 0.4D;
			  if(Keyboard.isKeyDown(57)){
				  par5Entity.motionY = 0.4D;
			  } else {
				  par5Entity.motionY *= 0.4D;
			  }
		  par5Entity.motionZ *= 0.4D;
		  par5Entity.onGround = true;
	  }

	@Override
	public ItemCell getCellFromBlock() {
		return null;
	}
}
