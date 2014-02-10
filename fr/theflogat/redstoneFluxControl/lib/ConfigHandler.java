package fr.theflogat.redstoneFluxControl.lib;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	public static void init(File configFile){
		Configuration config = new Configuration(configFile);
		config.load();
		Ids.actualItemRFR = config.get(config.CATEGORY_ITEM, "ItemRFReader", Ids.baseItemRFR).getInt() - 256;
		
		Ids.actualPowerBlock = config.get(config.CATEGORY_BLOCK, "PowerBlock", Ids.basePowerBlock).getInt();		
		Ids.actualBlockRFC = config.get(config.CATEGORY_BLOCK, "BlockRFController", Ids.baseBlockRFC).getInt();
		config.save();
	}
}
