package nl.deadlykitten.ControlPanel.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import nl.deadlykitten.ControlPanel.Main;
import nl.deadlykitten.ControlPanel.gui.MainGUI;

public class InventoryClickListener implements Listener {

	@SuppressWarnings("unused")
	private Main plugin;
	public InventoryClickListener(Main plugin) {
		this.plugin = plugin;	
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		String title = e.getInventory().getTitle();
		if(title.equals(MainGUI.inventory_name)) {
			e.setCancelled(true);
			if(e.getCurrentItem() == null) {
				return;
				}
			if(title.equals(MainGUI.inventory_name)) {
				MainGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
				
			}
			
		}
		
	}
}
