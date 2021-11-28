package gargant.armor.main;

import org.bukkit.plugin.java.JavaPlugin;

import gargant.armor.listeners.ArmorPickupEvent;
import gargant.armor.listeners.RightClickEvent;
import masecla.mlib.main.MLib;

public class AutoArmorPlus extends JavaPlugin{

	private MLib lib;
	
	@Override
	public void onEnable() {
		this.lib = new MLib(this);
		
		lib.getConfigurationAPI().requireAll();
		
		new RightClickEvent(lib, this).register();
		new ArmorPickupEvent(lib, this).register();
	}
	
	public boolean enabled() {
		return (boolean) lib.getConfigurationAPI().getConfig().get("enabled", true);
	}
}
