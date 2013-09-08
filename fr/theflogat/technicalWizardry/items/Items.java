package fr.theflogat.technicalWizardry.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import fr.theflogat.technicalWizardry.items.runes.*;

public class Items {
	
	public static Item DimensionalLife;
	public static Item Sacrificer;
	public static Item JarOfLife;
	public static Item Rune;
	public static Item RuneWater;
	public static Item RuneLava;
	public static Item RuneEarth;
	public static Item RuneDeath;
	public static Item RuneLife;
	public static Item RuneAir;
	public static Item RuneLight;
	public static Item RuneObscurous;	
	public static Item RuneChaos_Meta;
	public static Item RuneAssembler;
	
	public static void init(){
		
		DimensionalLife = new DimensionalLife(Ids.actualDimensionalLife);
		Sacrificer = new Sacrificer(Ids.actualSacrificer);
		JarOfLife = new JarOfLife(Ids.actualJarOfLife);
		Rune = new Rune(Ids.actualRune);
		RuneWater = new RuneWater(Ids.actualRuneWater);	
		RuneLava = new RuneLava(Ids.actualRuneLava);
		RuneEarth = new RuneEarth(Ids.actualRuneEarth);
		RuneDeath = new RuneDeath(Ids.actualRuneDeath);
		RuneLife = new RuneLife(Ids.actualRuneLife);
		RuneAir = new RuneAir(Ids.actualRuneAir);
		RuneLight = new RuneLight(Ids.actualRuneLight);
		RuneObscurous = new RuneObscurous(Ids.actualRuneObscurous);
		RuneChaos_Meta = new RunesChaos(Ids.actualRuneChaos_Meta);
		RuneAssembler = new RuneAssembler(Ids.actualRuneAssembler);
		
		initRecipes();
	}
	
	private static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(Items.Rune, 1), new Object[]{
		"CCC",
		"CIC",	
		"CCC",
		'C', Block.cobblestone, 'I', Item.clay
		});
		GameRegistry.addRecipe(new ItemStack(Items.RuneAssembler, 1), new Object[]{
		"B B",
		"bFb",
		"B B",
		'F', Block.furnaceIdle, 'b', Item.blazePowder,'B', Item.blazeRod
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.RuneChaos_Meta, 1, 0), new Object[]{
		Items.RuneAssembler, Items.RuneLava, Items.RuneWater
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.RuneChaos_Meta, 1, 1), new Object[]{
		Items.RuneAssembler, Items.RuneAir, Items.RuneEarth
		});
		
	}
	
	public static void addNames(){
		LanguageRegistry.addName(DimensionalLife, Names.DimensionalLife_ItemName);
		LanguageRegistry.addName(Sacrificer, Names.Sacrificer_ItemName);
		LanguageRegistry.addName(JarOfLife, Names.JarOfLife_ItemName);
		LanguageRegistry.addName(Rune, Names.Rune_ItemName);
		LanguageRegistry.addName(RuneWater, Names.RuneWater_ItemName);
		LanguageRegistry.addName(RuneLava, Names.RuneLava_ItemName);
		LanguageRegistry.addName(RuneEarth, Names.RuneEarth_ItemName);
		LanguageRegistry.addName(RuneDeath, Names.RuneDeath_ItemName);
		LanguageRegistry.addName(RuneLife, Names.RuneLife_ItemName);
		LanguageRegistry.addName(RuneAir, Names.RuneAir_ItemName);
		LanguageRegistry.addName(RuneLight, Names.RuneLight_ItemName);
		LanguageRegistry.addName(RuneObscurous, Names.RuneObscurous_ItemName);
		LanguageRegistry.addName(RuneAssembler, Names.RuneAssembler_ItemName);
		//MetaItems
		for(int i = 0; i < Names.RuneChaos_MetaItemName.length; i++) {
			LanguageRegistry.addName(new ItemStack(RuneChaos_Meta, 1, i), Names.RuneChaos_MetaItemName[i]);
		}
	}
}
