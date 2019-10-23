package nl.deadlykitten.ControlPanel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.deadlykitten.ControlPanel.Main;
import nl.deadlykitten.ControlPanel.gui.MainGUI;

public class openMenu implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	public openMenu(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("menu").setExecutor(this);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if (!(sender instanceof Player)) {
			return true;
		}
		
		Player p = (Player) sender;
		if(p.hasPermission("Menu.open")) {
			p.openInventory(MainGUI.GUI(p));
		}
		return false;
	}
}
