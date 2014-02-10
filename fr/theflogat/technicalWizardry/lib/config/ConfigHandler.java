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
		Ids.actualMagnetBlock = config.getBlock(config.CATEGORY_BLOCK, Names.MagnetBlock_BlockName, Ids.baseMagnetBlock).getInt();
		Ids.actualAirMomentumBlockPlusZ = config.getBlock(config.CATEGORY_BLOCK, Names.AirMomentumBlockPlusZ_BlockName, Ids.baseAirMomentumBlockPlusZ).getInt();
		Ids.actualAirMomentumBlockMinusZ = config.getBlock(config.CATEGORY_BLOCK, Names.AirMomentumBlockMinusZ_BlockName, Ids.baseAirMomentumBlockMinusZ).getInt();
		Ids.actualAirMomentumBlockPlusX = config.getBlock(config.CATEGORY_BLOCK, Names.AirMomentumBlockPlusX_BlockName, Ids.baseAirMomentumBlockPlusX).getInt();
		Ids.actualAirMomentumBlockMinusX = config.getBlock(config.CATEGORY_BLOCK, Names.AirMomentumBlockMinusX_BlockName, Ids.baseAirMomentumBlockMinusX).getInt();
		Ids.actualShieldBlock = config.getBlock(config.CATEGORY_BLOCK, Names.ShieldBlocks, Ids.baseShieldBlock).getInt();
		Ids.actualShieldBlockU = config.getBlock(config.CATEGORY_BLOCK, Names.ShieldBlocks + "_Unbreakable", Ids.baseShieldBlockU).getInt();
		Ids.actualAirBlockLight = config.getBlock(config.CATEGORY_BLOCK, Names.AirBlockLight_BlockName, Ids.baseAirBlockLight).getInt();
		Ids.actualUser = config.getBlock(config.CATEGORY_BLOCK, Names.Buffer_BlockName, Ids.baseUser).getInt();
		Ids.actualLapidemMagicaOre = config.getBlock(config.CATEGORY_BLOCK, Names.LapidemMagicaOre_BlockName, Ids.baseLapidemMagicaOre).getInt();
		Ids.actualItemInserter = config.getBlock(config.CATEGORY_BLOCK, Names.ItemInserter_BlockName, Ids.baseItemInserter).getInt();
		Ids.actualSpecificItemInserter = config.getBlock(config.CATEGORY_BLOCK, Names.SpecificItemInserter_BlockName, Ids.baseSpecificItemInserter).getInt();
		Ids.actualVacuumChest = config.getBlock(config.CATEGORY_BLOCK, Names.VacuumChest_BlockName, Ids.baseVacuumChest).getInt();
		Ids.actualRitualStone = config.getBlock(config.CATEGORY_BLOCK, Names.RitualStone_BlockName, Ids.baseRitualStone).getInt();
		Ids.actualReinforcedRitualStone = config.getBlock(config.CATEGORY_BLOCK, Names.ReinforcedRitualStone_BlockName, Ids.baseReinforcedRitualStone).getInt();
		Ids.actualMainRitualStone = config.getBlock(config.CATEGORY_BLOCK, Names.MainRitualStone_BlockName, Ids.baseMainRitualStone).getInt();
		Ids.actualPlayerLinkedBlock = config.getBlock(config.CATEGORY_BLOCK, Names.PlayerLinkedBlock_BlockName, Ids.basePlayerLinkedBlock).getInt();

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
		Ids.actualSpeedyBread = config.getItem(config.CATEGORY_ITEM, Names.SpeedyBread_ItemName, Ids.baseSpeedyBread).getInt() - 256;
		Ids.actualShieldAmulet = config.getItem(config.CATEGORY_ITEM, Names.ShieldAmulet_ItemName, Ids.baseShieldAmulet).getInt() - 256;
		Ids.actualMovementAmulet = config.getItem(config.CATEGORY_ITEM, Names.MovementAmulet_MetaItemName[0], Ids.baseMovementAmulet).getInt() - 256;
		Ids.actualSmoothCutter = config.getItem(config.CATEGORY_ITEM, Names.SmoothCutter_ItemName, Ids.baseSmoothCutter).getInt() - 256;
		Ids.actualLapidemMagica = config.getItem(config.CATEGORY_ITEM, Names.LapidemMagica_ItemName, Ids.baseLapidemMagica).getInt() - 256;
		Ids.actualSpeedUpgrade = config.getItem(config.CATEGORY_ITEM, Names.SpeedUpgrade_ItemName, Ids.baseSpeedUpgrade).getInt() - 256;
		Ids.actualPlayerLink = config.getItem(config.CATEGORY_ITEM, Names.PlayerLink_ItemName, Ids.basePlayerLink).getInt() - 256;
		Ids.actualInformationReader = config.getItem(config.CATEGORY_ITEM, Names.InformationReader_ItemName, Ids.baseInformationReader).getInt() - 256;
		Ids.actualItemSpell = config.getItem(config.CATEGORY_ITEM, Names.ItemSpell_ItemName, Ids.baseItemSpell).getInt() - 256;

		//RetroGen
		config.addCustomCategoryComment("Retrogen", "Regen Ores In An Already Present World");
		SpecialConfig.RegenLapidemMagica = config.get("Retrogen", "Lapidem Magica Ore", false).getBoolean(false);
		//End
		config.save();
	}
}
