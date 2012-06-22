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
