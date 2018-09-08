package com.will.askCharlie;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		System.out.print("Running Plugin 3jf#54");
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(this, this);
		return;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equals("askcharlie")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (!player.hasPermission("askcharlie.chatbypass")) {
					if (args[0].equalsIgnoreCase("Hello")) {
						player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Charlie" + ChatColor.GRAY + "]:" + ChatColor.WHITE + "Hey, Hows your day?");
					} else if (args[0].equalsIgnoreCase("hey")) {
						player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Charlie" + ChatColor.GRAY + "]:" + ChatColor.WHITE + "Can I ban you?");
					} else {
						player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Charlie" + ChatColor.GRAY + "]:" + ChatColor.WHITE + "Help me, I'm trapped");
					}
				}else {
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Charlie" + ChatColor.GRAY + "]:" + ChatColor.WHITE + "Admins are not fun to troll");
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onMove(PlayerBedEnterEvent e) {
		Player player = e.getPlayer();
		e.setCancelled(true);
		player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Charlie" + ChatColor.GRAY + "]:" + ChatColor.WHITE + "Don't go to sleep, come hang out with me");
	}
	@EventHandler
	public void onMove(PlayerEggThrowEvent e) {
		Player player = e.getPlayer();
		player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Charlie" + ChatColor.GRAY + "]:" + ChatColor.WHITE + "I wonder where those eggs came from");	
	}
}
