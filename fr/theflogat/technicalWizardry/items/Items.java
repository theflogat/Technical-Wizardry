package fr.theflogat.technicalWizardry.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.item.Item;
import fr.theflogat.technicalWizardry.items.runes.*;

public class Items {
	
	public static Item DimensionalLife;
	public static Item Sacrificer;
	public static Item JarOfLife;
	public static Item Rune;
	public static Item RuneWater;
	public static Item RuneLava;
	
	public static void init(){
		
		DimensionalLife = new DimensionalLife(Ids.actualDimensionalLife);
		Sacrificer = new Sacrificer(Ids.actualSacrificer);
		JarOfLife = new JarOfLife(Ids.actualJarOfLife);
		Rune = new Rune(Ids.actualRune);
		RuneWater = new RuneWater(Ids.actualRuneWater);	
		RuneLava = new RuneLava(Ids.actualRuneLava);
		
		
		initRecipes();
	}
	
	private static void initRecipes(){
		
	}
	
	public static void addNames(){
		LanguageRegistry.addName(DimensionalLife, Names.DimensionalLife_ItemName);
		LanguageRegistry.addName(Sacrificer, Names.Sacrificer_ItemName);
		LanguageRegistry.addName(JarOfLife, Names.JarOfLife_ItemName);
		LanguageRegistry.addName(Rune, Names.Rune_ItemName);
		LanguageRegistry.addName(RuneWater, Names.RuneWater_ItemName);
		LanguageRegistry.addName(RuneLava, Names.RuneLava_ItemName);
	}
}
