package gargant.armor.main;

import org.bukkit.plugin.java.JavaPlugin;

import masecla.mlib.main.MLib;

public class AutoArmorPlus extends JavaPlugin{

	private MLib lib;
	
	@Override
	public void onEnable() {
		this.lib = new MLib(this);
	}
	
	public boolean enabled() {
		return (boolean) lib.getConfigurationAPI().getConfig().get("enabled", true);
	}
}
