package nl.deadlykitten.ControlPanel.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {

	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	@SuppressWarnings("deprecation")
	public static ItemStack createItem(Inventory inv, int meterialId, int amount, int invSlot, String displayName, String...loreString) {
		ItemStack item;
		List<String> lore = new ArrayList<String>();
		
		item = new ItemStack(Material.getMaterial(meterialId),amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat(displayName));
		for(String s : loreString) {
			lore.add(Utils.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(invSlot, item);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItemByte(Inventory inv, int meterialId, int byteId, int amount, int invSlot, String displayName, String...loreString) {
		ItemStack item;
		List<String> lore = new ArrayList<String>();
		
		item = new ItemStack(Material.getMaterial(meterialId),amount, (short) byteId);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat(displayName));
		for(String s : loreString) {
			lore.add(Utils.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(invSlot, item);
		return item;
	}
	
}
