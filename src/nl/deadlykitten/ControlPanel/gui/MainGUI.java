package nl.deadlykitten.ControlPanel.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import nl.deadlykitten.ControlPanel.Main;
import nl.deadlykitten.ControlPanel.commands.openMenu;
import nl.deadlykitten.ControlPanel.utils.Utils;

public class MainGUI {
	public static Main plugin;
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 1 * 9;
	
	public static void initialize() {
		inventory_name = Utils.chat("&1Main Menu");
		inv = Bukkit.createInventory(null, inv_rows);
	}
	public static Inventory GUI (Player P) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
		if(openMenu.attractie_1_s == false) {
			Utils.createItemByte(inv, 251, 5, 1, 0, openMenu.attractie_1, "&aOpen");
		}else {
			Utils.createItemByte(inv, 251, 14, 1, 0,openMenu.attractie_1, "&cGesloten");
		}
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat(openMenu.attractie_1))) {
			plugin.getConfig().set("attractie_1.status", true);
			plugin.saveConfig();
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " &c"+ openMenu.attractie_1 +" is nu dicht door &f" + p.getName()));
			    if(player.getOpenInventory().getTitle().equals(inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			}
		}
	}
}
