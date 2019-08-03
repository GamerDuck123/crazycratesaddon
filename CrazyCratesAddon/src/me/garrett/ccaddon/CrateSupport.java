package me.garrett.ccaddon;

import org.bukkit.inventory.ItemStack;

public interface CrateSupport {
	
	String getPluginName();
	
	boolean isCrate(String name);
	
	int getPrizeSize(String crate);
	
	ItemStack getDisplayItem(String crate, int prize);
	
	ItemStack getDisplayItem(String crate, String prize);
	
}