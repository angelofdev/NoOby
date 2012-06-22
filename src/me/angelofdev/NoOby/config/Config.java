package me.angelofdev.NoOby.config;

public class Config {

	public static void set(){
		if (!Configuration.config.contains("Rpg.messages")) {
			Configuration.config.set("Rpg.messages", true);
		}
		if (!Configuration.config.contains("Rpg.Glass hurts hands")) {
			Configuration.config.set("Rpg.Glass hurts bare hands", true);
		}
		if(!Configuration.config.contains("Drops.enabled")) {
			Configuration.config.set("Drops.enabled",true);
		}
		if(!Configuration.config.contains("Chance.obsidian")) {
			Configuration.config.set("Chance.obsidian",10);
		}
		if(!Configuration.config.contains("Chance.grass")) {
			Configuration.config.set("Chance.grass",10);
		}
		if(!Configuration.config.contains("Chance.glass")) {
			Configuration.config.set("Chance.glass",10);
		}
		if(!Configuration.config.contains("Chance.glowstone")) {
			Configuration.config.set("Chance.glowstone",10);
		}
		if(!Configuration.config.contains("Chance.thin glass")) {
			Configuration.config.set("Chance.thin glass",10);
		}
		if(!Configuration.config.contains("Chance.bookshelf")) {
			Configuration.config.set("Chance.bookshelf",10);
		}
		if(!Configuration.config.contains("Chance.ice")) {
			Configuration.config.set("Chance.ice",10);
		}
		if(!Configuration.config.contains("Chance.snow")) {
			Configuration.config.set("Chance.snow",10);
		}
		if(!Configuration.config.contains("Debug.enabled")) {
			Configuration.config.set("Debug.enabled", false);
		}
	}
}
