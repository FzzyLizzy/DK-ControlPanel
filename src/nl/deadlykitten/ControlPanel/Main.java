package nl.deadlykitten.ControlPanel;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import nl.deadlykitten.ControlPanel.commands.SetFalse;
import nl.deadlykitten.ControlPanel.commands.SetTrue;
import nl.deadlykitten.ControlPanel.commands.openMenu;
import nl.deadlykitten.ControlPanel.gui.MainGUI;
import nl.deadlykitten.ControlPanel.listener.InventoryClickListener;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		FileConfiguration config = this.getConfig();
		config.addDefault("prefix", "&f[&4ControlMenu&f]");
		
		new openMenu(this);
		new SetTrue(this);
		new SetFalse(this);
		new InventoryClickListener(this);
		MainGUI.initialize();
	}
	
	

}
