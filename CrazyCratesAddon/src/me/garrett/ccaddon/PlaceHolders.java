package me.garrett.ccaddon;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

public class PlaceHolders
extends PlaceholderExpansion {
	
	public int i = 0;
	public Plugin plugin;
	public String prize;
	private CrateSupport crateSupport = CCAddon.crateSupport;
	
	public PlaceHolders(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public String getAuthor() {
		return "gamerduck";
	}
	
	@Override
	public String getIdentifier() {
		return "ccaddon";
	}
	
	@Override
	public String getVersion() {
		return plugin.getDescription().getVersion();
	}
	
	@Override
	public String onRequest(OfflinePlayer player, String identifier) {
		if(identifier.contains("rewards")) {
			String[] id = identifier.split("_");
			if(id.length >= 1) {
				String crateName = id[1];
				if(crateSupport.isCrate(crateName)) {
					i++;
					if(i == crateSupport.getPrizeSize(crateName)) {
						i = 0;
					}
					return crateSupport.getDisplayItem(crateName, i).getItemMeta().getDisplayName();
				}
			}
		}
		return identifier;
	}
	
}
