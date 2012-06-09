package me.angelofdev.NoOby;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
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

	public NoObyBlockListener(NoOby paramNoOby) {
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Location loc = player.getLocation();
		World w = loc.getWorld();

    if ((block.getType() == Material.OBSIDIAN)) {
    	final double random = Math.random();
    	if (random > 0.8) {
	    	block.setType(Material.AIR); {
	            for (double x = loc.getX() - 1.0D; x <= loc.getX() + 1.0D; x += 1.0D) {
	                for (double y = loc.getY() - 1.0D; y <= loc.getY() + 1.0D; y += 1.0D) {
	                	for (double z = loc.getZ() - 1.0D; z <= loc.getZ() + 1.0D; z += 1.0D) {
	                		w.playEffect(new Location(w, x, y, z), Effect.SMOKE, 1);
	                		w.playEffect(new Location(w,x,y,z), Effect.GHAST_SHOOT, 1);
	                	}
	                }
	            }
	    	}
	    	event.setCancelled(true); //disables original block from dropping.
    		player.sendMessage(ChatColor.GOLD + "You're mining so hard, even Obsidian can't withstand it.");
		} else if (random < 0.8) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.OBSIDIAN, 1));
	    	event.setCancelled(true);
			}
		}
		else if (/*(player.hasPermission("nooby.glowstone")) && */(block.getType() == Material.GLOWSTONE)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLOWSTONE, 1));
	    	event.setCancelled(true);
		}
		else if ((block.getType() == Material.GLASS)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS, 1));
	    	event.setCancelled(true);
		}
		else if ((block.getType() == Material.GRASS)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GRASS, 1));
	    	event.setCancelled(true);
		}
		else if ((block.getType() == Material.THIN_GLASS)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.THIN_GLASS, 1));
	    	event.setCancelled(true);
		}
		else if ((block.getType() == Material.BOOKSHELF)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BOOKSHELF, 1));
	    	event.setCancelled(true);
		}
		else if ((block.getType() == Material.ICE)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ICE, 1));
	    	event.setCancelled(true);
		}
		else if ((block.getType() == Material.SNOW_BLOCK)) {
	    	block.setType(Material.AIR);
	    	block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SNOW_BLOCK, 1));
	    	event.setCancelled(true);
		}
	}

}