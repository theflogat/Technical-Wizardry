package fr.theflogat.redstoneFluxControl;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.theflogat.redstoneFluxControl.api.ItemBlockObject;

public class Recipes {
	public static void init(){
		GameRegistry.addRecipe(new ItemStack(ItemBlockObject.RFReader, 1), new Object[]{
			"XXX",
			"PRP",
			"III",
			'R', Block.blockRedstone, 'I', Item.ingotIron, 'P', Item.paper, 'X', new ItemStack(Item.dyePowder, 1, 15)
		});
		
		GameRegistry.addRecipe(new ItemStack(ItemBlockObject.RFController, 1), new Object[]{
			"ERE",
			"RBR",
			"ICI",
			'R', Block.blockRedstone, 'B', Block.blockIron, 'E', Item.redstoneRepeater, 'C', Item.comparator, 'I', Item.ingotIron
		});
	}
}