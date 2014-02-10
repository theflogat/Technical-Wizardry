package fr.theflogat.debugger;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
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

@Mod( modid = "debugger", name = "Debugger", version = "1.0.0 Final")

@NetworkMod( channels = {"debugger"}, clientSideRequired = true, serverSideRequired = false )

public class Debbuger {
	
	@Instance("debugger")
	public static Debbuger instance;
	
	@SidedProxy(clientSide = "fr.theflogat.debugger.ClientProxy", serverSide = "fr.theflogat.debugger.CommonProxy")
	public static CommonProxy proxy;
	
	public static EnumToolMaterial magic = EnumHelper.addToolMaterial("Runic", 3, 5000, 8.0F, 3.0F, 30);
	
	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		proxy.initRenderers();
		proxy.initSounds();
		//----------Blocks----------\\
		Block Debugger = new DebuggerBlock(1000);
		GameRegistry.registerBlock(Debugger, "Debugger");
		LanguageRegistry.addName(Debugger, "Debugger");
		//----------Items----------\\
		Item DebuggerIt = new DebuggerItem(20000);
		LanguageRegistry.addName(DebuggerIt, "Debugger Item");
	}

	@EventHandler
	public static void init( FMLInitializationEvent event ) {


	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {

	}
}
