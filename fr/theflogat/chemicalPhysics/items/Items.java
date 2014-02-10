package fr.theflogat.chemicalPhysics.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import fr.theflogat.chemicalPhysics.api.ItemObjectCPU;
import fr.theflogat.chemicalPhysics.items.cells.*;
import fr.theflogat.chemicalPhysics.lib.config.Ids;
import fr.theflogat.chemicalPhysics.lib.config.Names;

public class Items {
	

	
	public static void init(){
		
		ItemObjectCPU.EmptyCell = new EmptyCell(Ids.actualEmptyCell);
		ItemObjectCPU.WaterCell = new WaterCell(Ids.actualWaterCell);
		ItemObjectCPU.LavaCell = new LavaCell(Ids.actualLavaCell);
		ItemObjectCPU.RFReader = new RFReader(Ids.actualRFReader);
		
		ItemObjectCPU.MercuryBucket = new MercuryBucket(Ids.actualMercuryBucket, 0);
		
		ItemObjectCPU.CellZ1 = new HydrogenCell(Ids.actualElementCellT);
		ItemObjectCPU.CellZ2 = new HeliumCell(Ids.actualElementCellT+1);
		ItemObjectCPU.CellZ3 = new LithiumCell(Ids.actualElementCellT+2);
		ItemObjectCPU.CellZ4 = new BerylliumCell(Ids.actualElementCellT+3);
		ItemObjectCPU.CellZ5 = new BoronCell(Ids.actualElementCellT+4);
		ItemObjectCPU.CellZ6 = new CarbonCell(Ids.actualElementCellT+5);
		ItemObjectCPU.CellZ7 = new NitrogenCell(Ids.actualElementCellT+6);
		ItemObjectCPU.CellZ8 = new OxygenCell(Ids.actualElementCellT+7);
		ItemObjectCPU.CellZ9 = new FluorineCell(Ids.actualElementCellT+8);
		ItemObjectCPU.CellZ10 = new NeonCell(Ids.actualElementCellT+9);
		
		ItemObjectCPU.CellZ80 = new MercuryCell(Ids.actualElementCellT+70);
		
		GameRegistry.registerItem(ItemObjectCPU.MercuryBucket, Names.BucketMercury_FluidName);
		initRecipes();
	}
	
	private static void initRecipes(){

	}
	
	public static void addNames(){
		LanguageRegistry.addName(ItemObjectCPU.EmptyCell, Names.EmptyCell_ItemName);
		LanguageRegistry.addName(ItemObjectCPU.WaterCell, Names.WaterCell_ItemName);
		LanguageRegistry.addName(ItemObjectCPU.LavaCell, Names.LavaCell_ItemName);
		LanguageRegistry.addName(ItemObjectCPU.RFReader, Names.RFReader_ItemName);
		
		LanguageRegistry.addName(ItemObjectCPU.MercuryBucket, Names.BucketMercury_FluidName);
	}
}
