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

package me.angelofdev.NoOby.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.error.YAMLException;

public class MyConfiguration extends YamlConfiguration {

	private File file;
	
	public String getFilename(){
		if (file == null)
		throw new UnsupportedOperationException("You didn't use a File to create this object.");
		String[] f = file.getAbsolutePath().split("/");
		return f[f.length-1];
	}
	
	public void load(String file) throws FileNotFoundException, IOException, InvalidConfigurationException{
		this.load(new File(file));
	}
	
	public void load(File file) throws FileNotFoundException, IOException, InvalidConfigurationException{
		super.load(file);
		this.file = file;
	}
	
	public void reload() throws FileNotFoundException, IOException, InvalidConfigurationException{
		load(file);
	}
	
	public static MyConfiguration loadConfiguration(String file){
		return MyConfiguration.loadConfiguration(new File(file));
	}
	
	public static MyConfiguration loadConfiguration(File file){
		if (file == null) {
			throw new IllegalArgumentException("File cannot be null");
		}
	
		MyConfiguration config = new MyConfiguration();
	
		try {
			config.load(file);
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
			Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + file, ex);
		} catch (InvalidConfigurationException ex) {
			if (ex.getCause() instanceof YAMLException) {
				Bukkit.getLogger().severe("Config file " + file + " isn't valid! " + ex.getCause());
			} else if ((ex.getCause() == null) || (ex.getCause() instanceof ClassCastException)) {
				Bukkit.getLogger().severe("Config file " + file + " isn't valid!");
			} else {
				Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + file + ": " + ex.getCause().getClass(), ex);
			}
		}
		config.file = file;
		
		return config;
	}
	
	public void save() throws IOException{
		if (file == null)
			throw new UnsupportedOperationException("You didn't use a File to create this object.");
		super.save(file);
	}

}