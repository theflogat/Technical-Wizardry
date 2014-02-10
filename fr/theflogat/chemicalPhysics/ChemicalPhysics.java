package fr.theflogat.chemicalPhysics;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
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
import fr.theflogat.chemicalPhysics.blocks.Blocks;
import fr.theflogat.chemicalPhysics.handler.CreativeTabCPU;
import fr.theflogat.chemicalPhysics.handler.MiscHandler;
import fr.theflogat.chemicalPhysics.handler.events.MercuryBucketHandler;
import fr.theflogat.chemicalPhysics.items.Items;
import fr.theflogat.chemicalPhysics.lib.LogHelper;
import fr.theflogat.chemicalPhysics.lib.References;
import fr.theflogat.chemicalPhysics.lib.config.ConfigHandler;
import fr.theflogat.chemicalPhysics.proxies.CommonProxy;
import fr.theflogat.chemicalPhysics.tileEntity.guis.GuiHandler;
import fr.theflogat.chemicalPhysics.world.WorldGeneratorCPU;
import fr.theflogat.chemicalPhysics.handler.sync.PacketManager;

@Mod( modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)

@NetworkMod( channels = {References.CHANNEL}, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketManager.class)

public class ChemicalPhysics {
			
	@Instance(References.MOD_ID)
	public static ChemicalPhysics instance;
	
	public static WorldGeneratorCPU worldGen;
		
	public static CreativeTabs CreativeTabCPU = new CreativeTabCPU(CreativeTabs.getNextID(), References.MOD_NAME);
		
	@SidedProxy(clientSide = References.PROXY_LOCATION + ".ClientProxy", serverSide = References.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
		
	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		LogHelper.log(Level.INFO, "Loading Config");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		LogHelper.log(Level.INFO, "Config Loaded");
		MiscHandler.init();
		proxy.initRenderers();
		proxy.initSounds();
		new GuiHandler();
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
		GameRegistry.registerWorldGenerator(worldGen = new WorldGeneratorCPU());
		MinecraftForge.EVENT_BUS.register(new MercuryBucketHandler());
		proxy.registerServerTickHandler();
	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {
		
	}
}
