package me.angelofdev.NoOby.config;

import java.util.Arrays;

public class Config {

	public static void set(){
		if (!Configuration.config.contains("Rpg.reminder")) {
			Configuration.config.set("Rpg.reminder", true);
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
		if(!Configuration.config.contains("Gamemode Force.players")) {
			Configuration.config.set("Gamemode Force.players", Arrays.asList(
					"##admin",
					"##mod"));
		}
		if(!Configuration.config.contains("Worlds on Enter force Survival.worlds")) {
			Configuration.config.set("Worlds on Enter force Survival.worlds", Arrays.asList(
					"#world",
					"#nether"));
		}
		if(!Configuration.config.contains("Worlds on Enter force Creative.worlds")) {
			Configuration.config.set("Worlds on Enter force Creative.worlds", Arrays.asList(
					"#world",
					"#nether"));
		}
		if(!Configuration.config.contains("Debug.enabled")) {
			Configuration.config.set("Debug.enabled", false);
		}
	}
}

