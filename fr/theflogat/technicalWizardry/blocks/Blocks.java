package fr.theflogat.technicalWizardry.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Blocks {
	
	public static Block Forge;
	public static Block FeatherBlock;
	
	public static void init(){
		Forge = new Forge(Ids.actualForge);
		FeatherBlock = new FeatherBlock(Ids.actualFeatherBlock);
		
		registerBlocks();
		initRecipes();
	}
	
	private static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(FeatherBlock, 1), new Object[]{
			"FF",
			"FF",
			'F', Item.feather
		});
	}
	
	private static void registerBlocks(){
		GameRegistry.registerBlock(Forge, Names.Forge_BlockName);
		GameRegistry.registerBlock(FeatherBlock, Names.FeatherBlock_BlockName);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(Forge, Names.Forge_BlockName);
		LanguageRegistry.addName(FeatherBlock, Names.FeatherBlock_BlockName);
	}
}
