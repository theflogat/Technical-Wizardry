package fr.theflogat.securitySwap.lib;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import fr.theflogat.securitySwap.lib.References;

public class LogHelper {
	private static Logger logger = Logger.getLogger(References.MOD_NAME);

	public static void init() {
	logger.setParent(FMLLog.getLogger());
	}

	public static void log(Level logLevel, String message) {
	logger.log(logLevel, message);
	}
}
