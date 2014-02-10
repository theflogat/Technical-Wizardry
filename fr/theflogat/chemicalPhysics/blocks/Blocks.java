package fr.theflogat.chemicalPhysics.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.chemicalPhysics.api.BlockObjectCPU;
import fr.theflogat.chemicalPhysics.api.ItemObjectCPU;
import fr.theflogat.chemicalPhysics.fluids.FluidMercury;
import fr.theflogat.chemicalPhysics.fluids.FluidMercuryBlock;
import fr.theflogat.chemicalPhysics.lib.config.Ids;
import fr.theflogat.chemicalPhysics.lib.config.Names;
import fr.theflogat.chemicalPhysics.tileEntity.TileEntityElectrolyser;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class Blocks {

	public static void init(){
		BlockObjectCPU.Electrolyser = new Electrolyser(Ids.actualElectrolyser);
		BlockObjectCPU.FluidMercury = new FluidMercury().setBlockID(Ids.actualFluidMercury);
		FluidRegistry.registerFluid(BlockObjectCPU.FluidMercury);
		BlockObjectCPU.BlockFluidMercury = new FluidMercuryBlock(Ids.actualFluidMercury);
		
		GameRegistry.registerTileEntity(TileEntityElectrolyser.class, "Electrolyser");
		registerBlocks();
		initRecipes();
	}
	
	private static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(BlockObjectCPU.Electrolyser), new Object[]{
			"XXX",
			"CXC",
			"RRR",
			'R', Item.redstone, 'C', Item.bucketWater, 'X', Item.arrow
		});
	}
	
	private static void registerBlocks(){
		GameRegistry.registerBlock(BlockObjectCPU.Electrolyser, Names.Electrolyser_BlockName);
		GameRegistry.registerBlock(BlockObjectCPU.BlockFluidMercury, Names.FluidMercury_FluidName);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(Names.FluidMercury_FluidName.toLowerCase(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemObjectCPU.MercuryBucket), new ItemStack(Item.bucketEmpty));
	}
	
	public static void addNames(){
		LanguageRegistry.addName(BlockObjectCPU.Electrolyser, Names.Electrolyser_BlockName);
		LanguageRegistry.addName(BlockObjectCPU.BlockFluidMercury, Names.FluidMercury_FluidName);
	}
}
