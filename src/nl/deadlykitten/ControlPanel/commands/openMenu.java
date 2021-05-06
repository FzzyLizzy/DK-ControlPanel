package nl.deadlykitten.ControlPanel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.deadlykitten.ControlPanel.Main;
import nl.deadlykitten.ControlPanel.gui.MainGUI;
import nl.deadlykitten.ControlPanel.utils.Utils;

public class openMenu implements CommandExecutor {

	public static String attractie_1;
	public static Boolean attractie_1_s;
	@SuppressWarnings("unused")
	private Main plugin;
	public openMenu(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("menu").setExecutor(this);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + "&cKan geen beeldscherm vinden"));
			return true;
		}
		
		Player p = (Player) sender;
		if(p.hasPermission("Menu.open")) {
			attractie_1 = plugin.getConfig().getString("attractie_1.naam");
			attractie_1_s = plugin.getConfig().getBoolean("attractie_1.status");
			p.openInventory(MainGUI.GUI(p));
		}
		return false;
	}
}
