package me.angelofdev.NoOby;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	private static String pre = "[" + NoOby.getPluginName() + "] ";
	private static final Logger LOG = Logger.getLogger("Minecraft");
	
	private Log(){
		
	}
	
	public static void info(String message) {
		LOG.log(Level.INFO, pre + message);
	}
	
	public static void warnings(String message) {
		LOG.log(Level.WARNING, pre + message);
	}
	
	public static void severe(String message) {
		LOG.log(Level.SEVERE, pre + message);
	}

	public static Logger getLogger() {
		return LOG;
	}
	
	public static String getPrefix() {
		return pre;
	}
}
