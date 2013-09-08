package fr.theflogat.technicalWizardry.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		config.load();
		//Blocks
		Ids.actualForge = config.getBlock(config.CATEGORY_BLOCK, Names.Forge_BlockName, Ids.baseForge).getInt();
		Ids.actualFeatherBlock = config.getBlock(config.CATEGORY_BLOCK, Names.FeatherBlock_BlockName, Ids.baseFeatherBlock).getInt();
		//Items
		Ids.actualDimensionalLife = config.getItem(config.CATEGORY_ITEM, Names.DimensionalLife_ItemName, Ids.baseDimensionalLife).getInt() - 256;
		Ids.actualSacrificer = config.getItem(config.CATEGORY_ITEM, Names.Sacrificer_ItemName, Ids.baseSacrificer).getInt() - 256;
		Ids.actualJarOfLife = config.getItem(config.CATEGORY_ITEM, Names.JarOfLife_ItemName, Ids.baseJarOfLife).getInt() - 256;
		Ids.actualRune = config.getItem(config.CATEGORY_ITEM, Names.Rune_ItemName, Ids.baseRune).getInt() - 256;
		Ids.actualRuneWater = config.getItem(config.CATEGORY_ITEM, Names.RuneWater_ItemName, Ids.baseRuneWater).getInt() - 256;
		Ids.actualRuneLava = config.getItem(config.CATEGORY_ITEM, Names.RuneLava_ItemName, Ids.baseRuneLava).getInt() - 256;
		Ids.actualRuneEarth = config.getItem(config.CATEGORY_ITEM, Names.RuneEarth_ItemName, Ids.baseRuneEarth).getInt() - 256;
		Ids.actualRuneDeath = config.getItem(config.CATEGORY_ITEM, Names.RuneDeath_ItemName, Ids.baseRuneDeath).getInt() - 256;
		Ids.actualRuneLife = config.getItem(config.CATEGORY_ITEM, Names.RuneLife_ItemName, Ids.baseRuneLife).getInt() - 256;
		Ids.actualRuneAir = config.getItem(config.CATEGORY_ITEM, Names.RuneAir_ItemName, Ids.baseRuneAir).getInt() - 256;
		Ids.actualRuneLight = config.getItem(config.CATEGORY_ITEM, Names.RuneLight_ItemName, Ids.baseRuneLight).getInt() - 256;
		Ids.actualRuneObscurous = config.getItem(config.CATEGORY_ITEM, Names.RuneObscurous_ItemName, Ids.baseRuneObscurous).getInt() - 256;
		Ids.actualRuneChaos_Meta = config.getItem(config.CATEGORY_ITEM, Names.RunesChaos_MetaItemName, Ids.baseRuneChaos_Meta).getInt() - 256;
		Ids.actualRuneAssembler = config.getItem(config.CATEGORY_ITEM, Names.RuneAssembler_ItemName, Ids.baseRuneAssembler).getInt() - 256;
		//End
		config.save();
	}
}
