package fr.theflogat.redstoneFluxControl;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.redstoneFluxControl.api.ItemBlockObject;
import fr.theflogat.redstoneFluxControl.lib.Ids;
import fr.theflogat.redstoneFluxControl.lib.References;

public class LoadContent {
	public static void init(){
		ItemBlockObject.RFController = new RFControllerBlock(Ids.actualBlockRFC);
		ItemBlockObject.PowerwBlock = new PowerBlock(Ids.actualPowerBlock);
		
		ItemBlockObject.RFReader = new RFReader(Ids.actualItemRFR);

		GameRegistry.registerBlock(ItemBlockObject.PowerwBlock, "Power Block");
		GameRegistry.registerBlock(ItemBlockObject.RFController, "RF Manager");
		GameRegistry.registerTileEntity(TERFController.class, References.MOD_ID.toLowerCase() + ":" + "RFController");
	}
	
	public static void addNames(){
		LanguageRegistry.addName(ItemBlockObject.RFController, "RF Manager");
		LanguageRegistry.addName(ItemBlockObject.RFReader, "RF Reader");
		LanguageRegistry.addName(ItemBlockObject.PowerwBlock, "Power Block");
	}
}
