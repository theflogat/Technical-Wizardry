package fr.theflogat.securitySwap;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.securitySwap.content.Content;
import fr.theflogat.securitySwap.lib.*;
import fr.theflogat.securitySwap.lib.config.ConfigHandler;
import fr.theflogat.securitySwap.proxies.CommonProxy;

@Mod( modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)

@NetworkMod( channels = {References.CHANNEL}, clientSideRequired = true, serverSideRequired = true )

public class SecuritySwap {
	
	@Instance(References.MOD_ID)
	public static SecuritySwap instance;
	
	public static CreativeTabs CreativeTabSSU = new CreativeTabSSU(CreativeTabs.getNextID(), References.MOD_NAME);
	
	@SidedProxy(clientSide = References.PROXY_LOCATION + ".ClientProxy", serverSide = References.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		proxy.initRenderers();
		proxy.initSounds();
		Content.init();
	}

	@EventHandler
	public static void init( FMLInitializationEvent event ) {
		Content.addNames();
		LanguageRegistry.instance().addStringLocalization("itemGroup." + References.MOD_NAME, "en_US", References.MOD_NAME);
	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {}
}