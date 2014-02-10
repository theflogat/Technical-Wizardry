package fr.theflogat.redstoneFluxControl;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import fr.theflogat.redstoneFluxControl.gui.GuiHandler;
import fr.theflogat.redstoneFluxControl.lib.ConfigHandler;
import fr.theflogat.redstoneFluxControl.lib.References;
import fr.theflogat.redstoneFluxControl.proxies.CommonProxy;

@Mod( modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)

@NetworkMod( channels = {References.MOD_ID}, clientSideRequired = true, packetHandler = PacketManager.class)

public class RedstoneFluxControl {

	@Instance(References.MOD_ID)
	public static RedstoneFluxControl instance;
	
	@SidedProxy(clientSide = References.PROXY_LOCATION + ".ClientProxy", serverSide = References.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		LoadContent.init();
	}
	
	@EventHandler
	public static void init( FMLInitializationEvent event ) {
		LoadContent.addNames();
		new GuiHandler();
	}
	
	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {
		Recipes.init();
	}
}
