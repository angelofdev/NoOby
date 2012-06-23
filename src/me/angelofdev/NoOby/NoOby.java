/*
 *  NoOby: Makes Obsidian break like Glass but makes Glass & other 
 *  			 unobtainable blocks to drop like normal blocks.
 *  Copyright (C) 2012  M.Y.Azad
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *   
 */

package me.angelofdev.NoOby;

import java.io.IOException;

import me.angelofdev.NoOby.config.Configuration;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoOby extends JavaPlugin {
	private NoObyBlockListener blockListener;
	private static String version;
	private static final String PLUGIN_NAME = "NoOby";
	
	public static NoOby instance;
	
	@Override
	public void onDisable() {
		Log.info(PLUGIN_NAME + " disabled");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		version = pdfFile.getVersion();
		
		initialise();
		initMetrics();
		
		Log.info("Loading configs...");
		Configuration.start();
		Log.info("loaded configs!");
		Log.info(PLUGIN_NAME + " v" + version + " enabled");
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(this.blockListener, this);
	}
	
	public static String getPluginName() {
		return PLUGIN_NAME;
	}
	
	@Override
	public String toString() {
		return getPluginName();
	}
	
	private void initialise() {
		blockListener = new NoObyBlockListener();
		instance = this;
		
	}

	private void initMetrics() {
		try {
		    MetricsLite metrics = new MetricsLite(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
	}	
}