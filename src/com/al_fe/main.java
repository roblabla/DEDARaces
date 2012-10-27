package com.al_fe;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Player;

public class main extends JavaPlugin {
	
    public void onEnable(){ 
    	getLogger().info("The races found their home. [DEDARaces enabled]");
    }
     
    public void onDisable(){ 
    	getLogger().info("The races were banished. [DEDARaces disabled]");
    }

	public boolean isPermissionSet(String name){
    	Player player = Bukkit.getServer().getPlayerExact(getName());
    	if(player.hasPermission("dedaraces.cof.fireimmune")) {
    		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0));
    		return true;
    	}
    	if(player.hasPermission("dedaraces.cof.waterdamage")) {
    		if(player.getLocation().getBlock().isLiquid()) {
    			player.setHealth(0);
    			return true;
    		}
    	}
    	if(player.hasPermission("dedaraces.cow.nodrain")) {
    		player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100, 0));
    		return true;
    	}
    	if(player.hasPermission("dedaraces.cow.waterspeed")) {
    		if(player.getLocation().getBlock().isLiquid()) {
    			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0));
    		}
    		return true;
    	}
    	if(player.hasPermission("dedaraces.all.denypotions")) {
    		if(player.getInventory().contains(373)) {
    			player.getInventory().remove(373);
    		}
    		return true;
    	}
		return false;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("dedaraces version")){
    		if(sender.hasPermission("dedaraces.version")){
    		sender.sendMessage(Bukkit.getVersion());
    		}
    		return true;
       }
    	return false;
    }
}