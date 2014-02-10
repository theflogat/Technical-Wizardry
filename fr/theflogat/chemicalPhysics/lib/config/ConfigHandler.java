package fr.theflogat.chemicalPhysics.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	public static void init(File configFileCPU) {
		Configuration configCpu = new Configuration(configFileCPU);
		configCpu.load();
		//Blocks
		Ids.actualElectrolyser = configCpu.getBlock(configCpu.CATEGORY_BLOCK, Names.Electrolyser_BlockName, Ids.baseElectrolyser).getInt();
		Ids.actualFluidMercury = configCpu.getBlock(configCpu.CATEGORY_BLOCK, Names.FluidMercury_FluidName, Ids.baseFluidMercury).getInt();

		//Items
		Ids.actualEmptyCell = configCpu.getItem(configCpu.CATEGORY_ITEM, Names.EmptyCell_ItemName, Ids.baseEmptyCell).getInt() - 256;
		Ids.actualWaterCell = configCpu.getItem(configCpu.CATEGORY_ITEM, Names.WaterCell_ItemName, Ids.baseWaterCell).getInt() - 256;
		Ids.actualLavaCell = configCpu.getItem(configCpu.CATEGORY_ITEM, Names.LavaCell_ItemName, Ids.baseLavaCell).getInt() - 256;
		Ids.actualMercuryBucket = configCpu.getItem(configCpu.CATEGORY_ITEM, Names.BucketMercury_FluidName, Ids.baseMercuryBucket).getInt() - 256;
		Ids.actualRFReader = configCpu.getItem(configCpu.CATEGORY_ITEM, Names.RFReader_ItemName, Ids.baseRFReader).getInt();
		
		
		Ids.actualElementCellT = configCpu.getItem(configCpu.CATEGORY_ITEM, Names.ElementsCell_ItemName, Ids.baseElementCell).getInt();

		//RetroGen
		configCpu.addCustomCategoryComment("Retrogen", "Regen Ores In An Already Present World");
		SpecialConfig.RegenFluidMercury = configCpu.get("Retrogen", "Fluid Mercury", false).getBoolean(false);
		
		//End
		configCpu.save();
	}
}
