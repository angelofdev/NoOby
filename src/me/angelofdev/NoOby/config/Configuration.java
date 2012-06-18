package me.angelofdev.NoOby.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.angelofdev.NoOby.Log;

public class Configuration {

public static MyConfiguration config;

	static {
		config = new MyConfiguration();
		
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/NoOby/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void start(){
		Log.info("Static Configuration loading...");
	}

	private static void exclaim(String filename){
		Log.info("Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		Log.severe("On file "+ filename + ":");
		Log.severe("Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		Log.severe("On file "+ filename + ":");
		Log.severe("Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/NoOby/"+name);
		} catch (FileNotFoundException e) {
			return true;
		} catch (Exception e) {
			complain(name);
		}
		return false;
	}

	private static void save(MyConfiguration y){
		try {
			y.save();
			try {
				y.load("plugins/NoOby/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}