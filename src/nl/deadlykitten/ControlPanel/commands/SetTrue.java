package nl.deadlykitten.ControlPanel.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import nl.deadlykitten.ControlPanel.Main;
import nl.deadlykitten.ControlPanel.gui.MainGUI;
import nl.deadlykitten.ControlPanel.utils.Utils;

public class SetTrue implements CommandExecutor {
	private Main plugin;
	public SetTrue(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("set-true").setExecutor(this);
		
}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if (!(sender instanceof Player)) {
			plugin.getConfig().set("attractie_1.status", true);
			plugin.saveConfig();
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&a " + plugin.getConfig().getBoolean("attractie_1.status")));
			for (Player player : Bukkit.getOnlinePlayers()) {
			    if(player.getOpenInventory().getTitle().equals(MainGUI.inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			}
			return true;
		}
		Player p = (Player) sender;
		if(p.hasPermission("Menu.cmd")) {
			plugin.getConfig().set("attractie_1.status", true);
			plugin.saveConfig();
				p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&a " + plugin.getConfig().getBoolean("attractie_1.status")));
			for (Player player : Bukkit.getOnlinePlayers()) {
			    if(player.getOpenInventory().getTitle().equals(MainGUI.inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			}
		}
		return false;
	}
}
