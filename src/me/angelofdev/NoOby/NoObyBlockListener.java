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

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class NoObyBlockListener implements Listener {

	public NoObyBlockListener() {
	}

	public HashMap<String, Player> playerhas = new HashMap<String, Player>();

	Random random = new Random();
	int rand = random.nextInt(10);
	int obby = Configuration.config.getInt("Chance.obsidian");
	int glow = Configuration.config.getInt("Chance.glowstone");
	int glass = Configuration.config.getInt("Chance.glass");
	int grass = Configuration.config.getInt("Chance.grass");
	int tglass = Configuration.config.getInt("Chance.thin glass");
	int shelf = Configuration.config.getInt("Chance.bookself");
	int ice = Configuration.config.getInt("Chance.ice");
	int snow = Configuration.config.getInt("Chance.snow");
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		String playername = player.getName();
		Block block = event.getBlock();
		Location loc = player.getLocation();
		World w = loc.getWorld();
		
		if (player.getGameMode() == GameMode.SURVIVAL && Configuration.config.getBoolean("Drops.enabled", true)) {
			if ((block.getType() == Material.OBSIDIAN)) {
				playerhas.put(playername, player);
		    		if (rand > obby) {
			    		block.setType(Material.AIR); {
						if (playerhas.containsKey(playername)) {
							for (double x = loc.getX() - 1.0D; x <= loc.getX() + 1.0D; x += 1.0D) {
								for (double y = loc.getY() - 1.0D; y <= loc.getY() + 1.0D; y += 1.0D) {
									for (double z = loc.getZ() - 1.0D; z <= loc.getZ() + 1.0D; z += 1.0D) {
										w.playEffect(new Location(w, x, y, z), Effect.SMOKE, 1);
									}
								}
							}
						}
			    		}
			    		event.setCancelled(true); //disables original block from dropping.
			    		player.sendMessage(ChatColor.GOLD + "You're mining so hard, even Obsidian can't withstand it.");
		    			if (Configuration.config.getBoolean("Debug.enabled", true)) {
			    			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Random is " + rand + " Config Set " + Configuration.config.getInt("Chance.obsidian"));
		    			}
			    		playerhas.remove(playername);
		    		} else if (rand < obby) {
		    			if (Configuration.config.getBoolean("Debug.enabled", true)) {
		    				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Random is " + rand + " Config Set " + Configuration.config.getInt("Chance.obsidian"));
		    			}
		    		playerhas.remove(playername);
		    		}
		    	
		    	//Glowstone	
			} else if ((block.getType() == Material.GLOWSTONE)) {
				if (player.getInventory().getItemInHand().getType().equals(Material.GOLD_PICKAXE)) {
			    		if (rand > glow) {
			    		} else if (rand < glow) {
			    			block.setType(Material.AIR);
			    			block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLOWSTONE, 1));
			    			if (Configuration.config.getBoolean("Debug.enabled", true)) {
			    				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Random is " + rand + " Config Set " + Configuration.config.getInt("Chance.obsidian"));
			    			}
			    		}
				}
				
			//Glass	
			} else if ((block.getType() == Material.GLASS)) {
		    		if (rand > glass) {
		    		} else if (rand < glass) {
		    			if (player.getInventory().getItemInHand().getType().equals(Material.AIR)) {
		    				if (Configuration.config.getBoolean("Rpg.Glass hurts bare hands", true)) {
		    					player.damage(1);
		    					if (Configuration.config.getBoolean("Rpg.messages", true)) {
		    						player.sendMessage(ChatColor.GOLD + "Are you mad? Don't break glass with your bare hands.");
		    					}
		    				}
		    			} else {
			    			block.setType(Material.AIR);
		    				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS, 1));
		    			}
		    		}
		    
			//Grass   	
			} else if ((block.getType() == Material.GRASS)) {
		    		if (rand > grass) {
		    		} else if (rand < grass) {
		    			if (player.getInventory().getItemInHand().getType().equals(Material.GOLD_SPADE)) {
		    				block.setType(Material.AIR);
		    				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GRASS, 1));
		    			}
		    		}
		    	
			//Thin Glass	
			} else if ((block.getType() == Material.THIN_GLASS)) {
		    		if (rand > tglass) {
		    		} else if (rand < tglass) {
		    			if (player.getInventory().getItemInHand().getType().equals(Material.AIR)) {
		    				if (Configuration.config.getBoolean("Rpg.Glass hurts bare hands", true)) {
		    					player.damage(1);
		    					if (Configuration.config.getBoolean("Rpg.messages", true)) {
		    						player.sendMessage(ChatColor.GOLD + "Are you mad? Don't break glass with your bare hands.");
		    					}
		    				}
		    			} else {
			    			block.setType(Material.AIR);
		    				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.THIN_GLASS, 1));
		    			}
		    		}
			   	
		   	//Bookshelf	
			} else if ((block.getType() == Material.BOOKSHELF)) {
		    		if (rand > shelf) {
		    		} else if (rand < shelf) {
		    			if (player.getInventory().getItemInHand().getType().equals(Material.GOLD_AXE)) {
		    				block.setType(Material.AIR);
		    				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BOOKSHELF, 1));
		    			}
		    		}
		    	
		    	//Ice	
			} else if ((block.getType() == Material.ICE)) {
		    		if (rand > ice) {
		    		} else if (rand < ice) {
		    			if (player.getInventory().getItemInHand().getType().equals(Material.GOLD_PICKAXE)) {
		    				block.setType(Material.AIR);
		    				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ICE, 1));
		    			}
		    		}
			
		  	  //Snow
			} else if ((block.getType() == Material.SNOW_BLOCK)) {
		    		if (rand > snow) {
		    		} else if (rand < snow) {
		    			if (player.getInventory().getItemInHand().getType().equals(Material.GOLD_SPADE)) {
		    				block.setType(Material.AIR);
		    				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SNOW_BLOCK, 1));
		    			}
		    		}
			}
		}
	}
}