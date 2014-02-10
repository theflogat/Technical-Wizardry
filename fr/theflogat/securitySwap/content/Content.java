package fr.theflogat.securitySwap.content;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.securitySwap.lib.config.Ids;
import fr.theflogat.securitySwap.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Content {
	
	public static Item ItemSwapper;
	
	public static void init(){
		ItemSwapper = new ItemSwapper(Ids.actualSSItem);
		
	}
	
	public static void addNames(){
		LanguageRegistry.addName(ItemSwapper, Names.SecuritySwapItem_ItemName);
	}
}
