package nl.deadlykitten.ControlPanel.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.deadlykitten.ControlPanel.Main;
import nl.deadlykitten.ControlPanel.bools.bools;
import nl.deadlykitten.ControlPanel.gui.MainGUI;

public class blokupdate implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	public blokupdate(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("set").setExecutor(this);
		
}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if (!(sender instanceof Player)) {
			if(bools.status = false) {
				bools.status = true;
				sender.sendMessage("set to " + bools.status);
			}else{
				bools.status = true;
				sender.sendMessage("setto" + bools.status);
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
			    if(player.getOpenInventory().getTitle().equals(MainGUI.inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			}
			return true;
		}
		Player p = (Player) sender;
		if(p.hasPermission("Menu.cmd")) {
			if(bools.status = false) {
				bools.status = true;
				p.sendMessage("set to " + bools.status);
			}else{
				bools.status = true;
				p.sendMessage("setto" + bools.status);
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
			    if(player.getOpenInventory().getTitle().equals(MainGUI.inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			}
		}
		return false;
	}
}
	

