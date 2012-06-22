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
