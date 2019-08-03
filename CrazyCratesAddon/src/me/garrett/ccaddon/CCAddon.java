package me.garrett.ccaddon;

import me.garrett.ccaddon.hooks.CrazyCratesSupport;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CCAddon extends JavaPlugin {
	
	public static Plugin plugin;
	public static CrateSupport crateSupport;
	
	@Override
	public void onEnable() {
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
		if(pluginManager.getPlugin("CrazyCrates").isEnabled()){
			crateSupport = new CrazyCratesSupport();
		}
		if(crateSupport != null) {
			System.out.println("[CCAddon] The crate plugin " + crateSupport.getPluginName() + " has been found.");
			new PlaceHolders(this).register();
		}else{
			System.out.println("[CCAddon] Disabling plugin due to no supported Crate plugin found.");
			getPluginLoader().disablePlugin(this);
		}
	}
}
