package fr.theflogat.technicalWizardry;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.blocks.Blocks;
import fr.theflogat.technicalWizardry.items.Items;
import fr.theflogat.technicalWizardry.lib.*;
import fr.theflogat.technicalWizardry.lib.config.ConfigHandler;
import fr.theflogat.technicalWizardry.proxies.CommonProxy;
import fr.theflogat.technicalWizardry.creativeTabs.CreativeTabTWU;;

@Mod( modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)

@NetworkMod( channels = {References.MOD_ID}, clientSideRequired = true, serverSideRequired = true )

public class TechnicalWizardry {
	
	public static CreativeTabs CreativeTabTWU = new CreativeTabTWU(CreativeTabs.getNextID(), References.MOD_NAME);
	
	@SidedProxy( clientSide = References.PROXY_LOCATION + ".ClientProxy", serverSide = References.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		LogHelper.log(Level.INFO, "Loading Config");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		LogHelper.log(Level.INFO, "Config Loaded");
		proxy.initRenderers();
		proxy.initSounds();
		LogHelper.log(Level.INFO, "Preparing items");
		Items.init();
		LogHelper.log(Level.INFO, "Items loaded");
		LogHelper.log(Level.INFO, "Preparing blocks");
		Blocks.init();
		LogHelper.log(Level.INFO, "Blocks loaded");
	}

	@EventHandler
	public static void init( FMLInitializationEvent event ) {
		LogHelper.log(Level.INFO, "Adding Names");
		Items.addNames();
		Blocks.addNames();
		LogHelper.log(Level.INFO,  "Names added");
		LanguageRegistry.instance().addStringLocalization("itemGroup." + References.MOD_NAME, "en_US", References.MOD_NAME);
	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {

	}

}
