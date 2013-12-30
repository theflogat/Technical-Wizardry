package fr.theflogat.technicalWizardry.blocks;

import fr.theflogat.technicalWizardry.tileEntity.TETWU;
import fr.theflogat.technicalWizardry.util.Orientation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class AutoMiner extends Block{

	public AutoMiner(int id) {
		super(id, Material.iron);
	}

	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack stack) {
		super.onBlockPlacedBy(world, i, j, k, entityliving, stack);
	}
	
	@Override
	public void breakBlock(World par1World, int par2,int par3,int par4,int par5,int par6){
		TETWU tile =  (TETWU) par1World.getBlockTileEntity(par2, par3, par4);
		tile.dropContents();
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}
