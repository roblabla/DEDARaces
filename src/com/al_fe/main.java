package com.al_fe;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.PlayerMoveEvent;
import org.bukkit.event.PlayerJoinEvent;

public class main extends JavaPlugin implements Listener {
    public void onEnable(){ 
    	getLogger().info("The races found their home. [DEDARaces enabled]");
    	this.getServer().getScheduler().scheduleSyncRepeatingTask(myPlugin, new Runnable() {
			public void run() {
    			for (Player player: Bukkit.getServer().getOnlinePlayers()) {
    				main.applyEffects(player.getName());
    			}
			}
		}, 0L, 90L);
    }

    public void onDisable(){ 
    	getLogger().info("The races were banished. [DEDARaces disabled]");
    }

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		if (event.getPlayer().hasPermission("dedaraces.cof.waterdamage") && event.getTo().getBlock().isLiquid()) {
			player.setHealth(0);
		}
		if (event.getPlayer().hasPermission("dedaraces.cof.waterspeed") && event.getTo().getBlock().isLiquid()) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2, 0));
		}
	}
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		applyEffects(event.getPlayer().getName());
	}
	
	public static boolean applyEffects(String name){
    	Player player = Bukkit.getServer().getPlayerExact(getName());
    	if(player.hasPermission("dedaraces.cof.fireimmune")) {
    		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0));
    		return true;
    	}
    	if(player.hasPermission("dedaraces.cow.nodrain")) {
    		player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100, 0));
			return true;
    	}
		return false;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("dedaraces") && args[0] == "version") {
    		if(sender.hasPermission("dedaraces.version")){
 		   		sender.sendMessage(Bukkit.getVersion());
    		}
    		return true;
       }
    	return false;
    }
}