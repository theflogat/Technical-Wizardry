package fr.theflogat.technicalWizardry;

import java.util.Random;
import java.util.logging.Level;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.theflogat.technicalWizardry.blocks.Blocks;
import fr.theflogat.technicalWizardry.entity.Entities;
import fr.theflogat.technicalWizardry.handler.CreativeTabTWU;
import fr.theflogat.technicalWizardry.handler.MiscHandler;
import fr.theflogat.technicalWizardry.handler.Recipes;
import fr.theflogat.technicalWizardry.items.Items;
import fr.theflogat.technicalWizardry.lib.*;
import fr.theflogat.technicalWizardry.lib.config.ConfigHandler;
import fr.theflogat.technicalWizardry.proxies.CommonProxy;
import fr.theflogat.technicalWizardry.tileEntity.guis.GuiHandler;
import fr.theflogat.technicalWizardry.world.WorldGeneratorTWU;

@Mod( modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)

@NetworkMod( channels = {References.CHANNEL}, clientSideRequired = true, serverSideRequired = true )

public class TechnicalWizardry {
	
	@Instance(References.MOD_ID)
	public static TechnicalWizardry instance;
	
	public static WorldGeneratorTWU worldGen;
	
	public static CreativeTabs CreativeTabTWU = new CreativeTabTWU(CreativeTabs.getNextID(), References.MOD_NAME);
	
	@SidedProxy(clientSide = References.PROXY_LOCATION + ".ClientProxy", serverSide = References.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static EnumToolMaterial magic = EnumHelper.addToolMaterial("Runic", 3, 5000, 8.0F, 3.0F, 30);

	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		LogHelper.log(Level.INFO, "Loading Config");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		LogHelper.log(Level.INFO, "Config Loaded");
		MiscHandler.init();
		proxy.initRenderers();
		proxy.initSounds();
		new GuiHandler();
		//Entities.init();
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
		GameRegistry.registerWorldGenerator(worldGen = new WorldGeneratorTWU());
		proxy.registerServerTickHandler();


	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {
		Recipes.init();
		LogHelper.log(Level.INFO, "Recipes loaded");
	}
}
