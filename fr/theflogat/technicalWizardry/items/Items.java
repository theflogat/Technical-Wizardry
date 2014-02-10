package fr.theflogat.technicalWizardry.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import fr.theflogat.technicalWizardry.blocks.Blocks;
import fr.theflogat.technicalWizardry.items.runes.*;
import fr.theflogat.technicalWizardry.items.bound.*;
import fr.theflogat.technicalWizardry.items.spells.*;
import fr.theflogat.technicalWizardry.api.BlockObjectTWU;
import fr.theflogat.technicalWizardry.api.BlockRuneAssigner;
import fr.theflogat.technicalWizardry.api.BlockRuneAssigner.Value;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;;

public class Items {
	
	public static void init(){
		
		ItemObjectTWU.DimensionalLife = new DimensionalLife(Ids.actualDimensionalLife);
		ItemObjectTWU.Sacrificer = new Sacrificer(Ids.actualSacrificer);
		ItemObjectTWU.JarOfLife = new JarOfLife(Ids.actualJarOfLife);
		ItemObjectTWU.Rune = new Rune(Ids.actualRune);
		ItemObjectTWU.RuneWater = new RuneWater(Ids.actualRuneWater);	
		ItemObjectTWU.RuneLava = new RuneLava(Ids.actualRuneLava);
		ItemObjectTWU.RuneEarth = new RuneEarth(Ids.actualRuneEarth);
		ItemObjectTWU.RuneDeath = new RuneDeath(Ids.actualRuneDeath);
		ItemObjectTWU.RuneLife = new RuneLife(Ids.actualRuneLife);
		ItemObjectTWU.RuneAir = new RuneAir(Ids.actualRuneAir);
		ItemObjectTWU.RuneLight = new RuneLight(Ids.actualRuneLight);
		ItemObjectTWU.RuneObscurous = new RuneObscurous(Ids.actualRuneObscurous);
		ItemObjectTWU.RuneChaos_Meta = new RunesChaos(Ids.actualRuneChaos_Meta);
		ItemObjectTWU.RuneAssembler = new RuneAssembler(Ids.actualRuneAssembler);
		ItemObjectTWU.SpeedyBread = new SpeedyBread(Ids.actualSpeedyBread);
		ItemObjectTWU.SpeedUpgrade = new SpeedUpgrade(Ids.actualSpeedUpgrade);
		ItemObjectTWU.MovementAmulet = new MovementAmulet(Ids.actualMovementAmulet);
		ItemObjectTWU.SmoothCutter = new SmoothCutter(Ids.actualSmoothCutter);
		ItemObjectTWU.LapidemMagica = new LapidemMagica(Ids.actualLapidemMagica);
		ItemObjectTWU.PlayerLink = new PlayerLink(Ids.actualPlayerLink);
		ItemObjectTWU.InformationReader = new InformationReader(Ids.actualInformationReader);
		ItemObjectTWU.ItemSpell = new ItemSpell(Ids.actualItemSpell);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(ItemObjectTWU.DimensionalLife, Names.DimensionalLife_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.Sacrificer, Names.Sacrificer_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.JarOfLife, Names.JarOfLife_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.Rune, Names.Rune_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneWater, Names.RuneWater_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneLava, Names.RuneLava_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneEarth, Names.RuneEarth_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneDeath, Names.RuneDeath_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneLife, Names.RuneLife_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneAir, Names.RuneAir_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneLight, Names.RuneLight_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneObscurous, Names.RuneObscurous_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.RuneAssembler, Names.RuneAssembler_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.SpeedyBread, Names.SpeedyBread_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.SmoothCutter, Names.SmoothCutter_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.LapidemMagica, Names.LapidemMagica_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.SpeedUpgrade, Names.SpeedUpgrade_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.PlayerLink, Names.PlayerLink_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.InformationReader, Names.InformationReader_ItemName);
		LanguageRegistry.addName(ItemObjectTWU.ItemSpell, Names.ItemSpell_ItemName);
		
		//MetaItems
		for(int i = 0; i < Names.RuneChaos_MetaItemName.length; i++) {
			LanguageRegistry.addName(new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, i), Names.RuneChaos_MetaItemName[i]);
		}
		for(int i = 0; i < Names.MovementAmulet_MetaItemName.length; i++) {
			LanguageRegistry.addName(new ItemStack(ItemObjectTWU.MovementAmulet, 1, i), Names.MovementAmulet_MetaItemName[i]);
		}
	}
}
