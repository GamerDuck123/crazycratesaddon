package me.garrett.ccaddon;

import org.bukkit.plugin.java.JavaPlugin;

public class CCAddon extends JavaPlugin {
	@Override
	public void onEnable() {
		new PlaceHolders(this).register();
	}
}
