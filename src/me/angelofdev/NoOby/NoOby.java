package me.angelofdev.NoOby;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoOby extends JavaPlugin {
	private final NoObyBlockListener playerListener = new NoObyBlockListener (this);
	private static String version;
	private static final String PLUGIN_NAME = "NoOby";
	
	@Override
	public void onDisable() {
		Log.info(PLUGIN_NAME + " disabled");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		version = pdfFile.getVersion();
		
		initMetrics();
		
		Log.info("Loading configs...");
		Configuration.start();
		Log.info("loaded configs!");
		Log.info(PLUGIN_NAME + " v" + version + " enabled");
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.playerListener, this);
	}
	
	public static String getPluginName() {
		return PLUGIN_NAME;
	}
	
	@Override
	public String toString() {
		return getPluginName();
	}

	private void initMetrics() {
		try {
		    MetricsLite metrics = new MetricsLite(instance);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
	}
	
	public NoObyBlockListener getListener() {
		return playerListener;
	}
	
}
