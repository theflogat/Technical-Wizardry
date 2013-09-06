package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {
	
	public static Block Forge;
	
	public static void init(){
		Forge = new Forge(Ids.actualForge);
		
		registerBlocks();
		initRecipes();
	}
	
	private static void initRecipes(){
		
	}
	
	private static void registerBlocks(){
		GameRegistry.registerBlock(Forge, Names.Forge_BlockName);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(Forge, Names.Forge_BlockName);
	}
}
