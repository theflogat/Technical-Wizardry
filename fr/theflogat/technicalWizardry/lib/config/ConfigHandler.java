package fr.theflogat.technicalWizardry.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		config.load();
		//Blocks
		Ids.actualForge = config.getBlock(config.CATEGORY_BLOCK, Names.Forge_BlockName, Ids.baseForge).getInt();
		//Items
		Ids.actualDimensionalLife = config.getItem(config.CATEGORY_ITEM, Names.DimensionalLife_ItemName, Ids.baseDimensionalLife).getInt() - 256;
		Ids.actualSacrificer = config.getItem(config.CATEGORY_ITEM, Names.Sacrificer_ItemName, Ids.baseSacrificer).getInt() - 256;
		Ids.actualJarOfLife = config.getItem(config.CATEGORY_ITEM, Names.JarOfLife_ItemName, Ids.baseJarOfLife).getInt() - 256;
		Ids.actualRune = config.getItem(config.CATEGORY_ITEM, Names.Rune_ItemName, Ids.baseRune).getInt() - 256;
		Ids.actualRuneWater = config.getItem(config.CATEGORY_ITEM, Names.RuneWater_ItemName, Ids.baseRuneWater).getInt() - 256;
		Ids.actualRuneLava = config.getItem(config.CATEGORY_ITEM, Names.RuneLava_ItemName, Ids.baseRuneLava).getInt() - 256;
		//End
		config.save();
	}

}
