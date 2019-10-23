package nl.deadlykitten.ControlPanel;

import org.bukkit.plugin.java.JavaPlugin;

import nl.deadlykitten.ControlPanel.commands.blokupdate;
import nl.deadlykitten.ControlPanel.commands.openMenu;
import nl.deadlykitten.ControlPanel.gui.MainGUI;
import nl.deadlykitten.ControlPanel.listener.InventoryClickListener;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		new openMenu(this);
		new blokupdate(this);
		new InventoryClickListener(this);
		MainGUI.initialize();
	}
	
	

}
