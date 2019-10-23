package nl.deadlykitten.ControlPanel.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import nl.deadlykitten.ControlPanel.utils.Utils;

public class MainGUI {
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 1 * 9;
	public static Boolean status = null;
	
	public static void initialize() {
		inventory_name = Utils.chat("&1Main Menu");
		inv = Bukkit.createInventory(null, inv_rows);
	}
	public static Inventory GUI (Player P) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
		if(status == false) {
		Utils.createItemByte(inv, 251, 5, 1, 0, "&aOpen");
		}else {
	    Utils.createItemByte(inv, 251, 14, 1, 0, "&cNiet Open");
		}
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&aOpen"))) {
			status = true;
			Utils.createItemByte(inv, 251, 14, 1, 0, "&cNiet Open");
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(Utils.chat("&f[&4DK MENU&f] &cDit Ding is nu dicht door &f" + p.getName()));
			    if(player.getOpenInventory().getTitle().equals(inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			}
		}
		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cNiet Open"))) {
			status = false;
			Utils.createItemByte(inv, 251, 5, 1, 0, "&aOpen");
			for (Player player : Bukkit.getOnlinePlayers()) {
				if(player.equals(p)) {
					player.sendMessage(Utils.chat("&f[&4DK MENU&f] &aJe hebt dit ding geopend&f")); 
				}else {
					player.sendMessage(Utils.chat("&f[&4DK MENU&f] &aDit Ding is nu Open door &f" + p.getName())); 
				}
				
			    if(player.getOpenInventory().getTitle().equals(inventory_name)) {
			    player.openInventory(MainGUI.GUI(player));
			    }
			    }
			}
		}
	}
