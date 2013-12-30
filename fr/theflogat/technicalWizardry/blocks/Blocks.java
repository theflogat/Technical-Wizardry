package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.api.BlockObjectTWU;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.blocks.*;
import fr.theflogat.technicalWizardry.blocks.air.AirBlockLight;
import fr.theflogat.technicalWizardry.blocks.air.AirMomentumBlockMinusX;
import fr.theflogat.technicalWizardry.blocks.air.AirMomentumBlockMinusZ;
import fr.theflogat.technicalWizardry.blocks.air.AirMomentumBlockPlusX;
import fr.theflogat.technicalWizardry.blocks.air.AirMomentumBlockPlusZ;
import fr.theflogat.technicalWizardry.blocks.moving.ItemInserter;
import fr.theflogat.technicalWizardry.blocks.moving.SpecificItemInserter;
import fr.theflogat.technicalWizardry.blocks.moving.VacuumChest;
import fr.theflogat.technicalWizardry.blocks.rituals.MainRitualStone;
import fr.theflogat.technicalWizardry.blocks.rituals.ReinforcedRitualStone;
import fr.theflogat.technicalWizardry.blocks.rituals.RitualStone;
import fr.theflogat.technicalWizardry.items.Items;
import fr.theflogat.technicalWizardry.items.LapidemMagica;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import fr.theflogat.technicalWizardry.tileEntity.TEBuffer;
import fr.theflogat.technicalWizardry.tileEntity.TEForge;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TEMainRitualStone;
import fr.theflogat.technicalWizardry.tileEntity.TEMobMagnet;
import fr.theflogat.technicalWizardry.tileEntity.TEPlayerLinkedBlock;
import fr.theflogat.technicalWizardry.tileEntity.TESpecificItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TEVacuumChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Blocks {
	

	public static void init(){
		BlockObjectTWU.Forge = new Forge(Ids.actualForge);
		BlockObjectTWU.FeatherBlock = new FeatherBlock(Ids.actualFeatherBlock);
		BlockObjectTWU.MagnetBlock = new MagnetBlock(Ids.actualMagnetBlock);
		BlockObjectTWU.AirMomentumBlockPlusZ = new AirMomentumBlockPlusZ(Ids.actualAirMomentumBlockPlusZ);
		BlockObjectTWU.AirMomentumBlockMinusZ = new AirMomentumBlockMinusZ(Ids.actualAirMomentumBlockMinusZ);
		BlockObjectTWU.AirMomentumBlockPlusX = new AirMomentumBlockPlusX(Ids.actualAirMomentumBlockPlusX);
		BlockObjectTWU.AirMomentumBlockMinusX = new AirMomentumBlockMinusX(Ids.actualAirMomentumBlockMinusX);
		BlockObjectTWU.ShieldBlocks = new ShieldBlock(Ids.actualShieldBlock);
		BlockObjectTWU.ShieldBlocksU = new ShieldBlockUnbreakable(Ids.actualShieldBlockU);
		BlockObjectTWU.AirLight = new AirBlockLight(Ids.actualAirBlockLight);
		BlockObjectTWU.Buffer = new Buffer(Ids.actualUser);
		BlockObjectTWU.LapidemMagicaOre = new LapidemMagicaOre(Ids.actualLapidemMagicaOre);
		BlockObjectTWU.ItemInserter = new ItemInserter(Ids.actualItemInserter);
		BlockObjectTWU.SpecificItemInserter = new SpecificItemInserter(Ids.actualSpecificItemInserter);
		BlockObjectTWU.VacuumChest = new VacuumChest(Ids.actualVacuumChest);
		BlockObjectTWU.RitualStone = new RitualStone(Ids.actualRitualStone);
		BlockObjectTWU.ReinforcedRitualStone = new ReinforcedRitualStone(Ids.actualReinforcedRitualStone);
		BlockObjectTWU.MainRitualStone = new MainRitualStone(Ids.actualMainRitualStone);
		BlockObjectTWU.PlayerLinkedBlock = new PlayerLinkedBlock(Ids.actualPlayerLinkedBlock);
		
		GameRegistry.registerTileEntity(TEForge.class, "Forge");
		GameRegistry.registerTileEntity(TEMobMagnet.class, "MobMagnet");
		GameRegistry.registerTileEntity(TEBuffer.class, "Buffer");
		GameRegistry.registerTileEntity(TEItemInserter.class, "ItemInserter");
		GameRegistry.registerTileEntity(TESpecificItemInserter.class, "SpecificItemInserter");
		GameRegistry.registerTileEntity(TEVacuumChest.class, "VacuumChest");
		GameRegistry.registerTileEntity(TEMainRitualStone.class, "MainRitualStone");
		GameRegistry.registerTileEntity(TEPlayerLinkedBlock.class, "PlayerLinkedBlock");
		registerBlocks();
	}
	
	private static void registerBlocks(){
		GameRegistry.registerBlock(BlockObjectTWU.Forge, Names.Forge_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.FeatherBlock, Names.FeatherBlock_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.MagnetBlock, Names.MagnetBlock_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.AirMomentumBlockPlusZ, Names.AirMomentumBlockPlusZ_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.AirMomentumBlockMinusZ, Names.AirMomentumBlockMinusZ_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.AirMomentumBlockPlusX, Names.AirMomentumBlockPlusX_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.AirMomentumBlockMinusX, Names.AirMomentumBlockMinusX_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.ShieldBlocks, Names.ShieldBlock_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.ShieldBlocksU, Names.ShieldBlockU_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.AirLight, Names.AirBlockLight_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.Buffer, Names.Buffer_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.LapidemMagicaOre, Names.LapidemMagicaOre_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.ItemInserter, Names.ItemInserter_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.SpecificItemInserter, Names.SpecificItemInserter_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.VacuumChest, Names.VacuumChest_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.RitualStone, Names.RitualStone_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.ReinforcedRitualStone, Names.ReinforcedRitualStone_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.MainRitualStone, Names.MainRitualStone_BlockName);
		GameRegistry.registerBlock(BlockObjectTWU.PlayerLinkedBlock, Names.PlayerLinkedBlock_BlockName);
	
	}
	
	public static void addNames(){
		LanguageRegistry.addName(BlockObjectTWU.Forge, Names.Forge_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.FeatherBlock, Names.FeatherBlock_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.MagnetBlock, Names.MagnetBlock_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.AirMomentumBlockPlusZ, Names.AirMomentumBlockPlusZ_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.AirMomentumBlockMinusZ, Names.AirMomentumBlockMinusZ_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.AirMomentumBlockPlusX, Names.AirMomentumBlockPlusX_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.AirMomentumBlockMinusX, Names.AirMomentumBlockMinusX_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.ShieldBlocks, Names.ShieldBlock_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.ShieldBlocksU, Names.ShieldBlockU_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.AirLight, Names.AirBlockLight_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.Buffer, Names.Buffer_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.LapidemMagicaOre, Names.LapidemMagicaOre_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.ItemInserter, Names.ItemInserter_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.SpecificItemInserter, Names.SpecificItemInserter_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.VacuumChest, Names.VacuumChest_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.RitualStone, Names.RitualStone_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.ReinforcedRitualStone, Names.ReinforcedRitualStone_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.MainRitualStone, Names.MainRitualStone_BlockName);
		LanguageRegistry.addName(BlockObjectTWU.PlayerLinkedBlock, Names.PlayerLinkedBlock_BlockName);
	
	}
}
