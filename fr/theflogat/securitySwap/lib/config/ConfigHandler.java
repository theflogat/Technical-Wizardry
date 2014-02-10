package fr.theflogat.securitySwap.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		config.load();
		Ids.actualSSItem = config.getItem(config.CATEGORY_ITEM, Names.SecuritySwapItem_ItemName, Ids.baseSSItem).getInt() - 256;
		//Ids.actualSSBlock = config.getBlock(config.CATEGORY_BLOCK, Names.SecuritySwapBlock_BlockName, Ids.baseSSBlock).getInt();
		config.save();
	}

}
