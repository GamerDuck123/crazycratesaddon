package me.garrett.ccaddon.hooks;

import me.badbones69.crazycrates.api.CrazyCrates;
import me.garrett.ccaddon.CrateSupport;
import org.bukkit.inventory.ItemStack;

public class CrazyCratesSupport implements CrateSupport {
	
	private CrazyCrates cc = CrazyCrates.getInstance();
	
	@Override
	public String getPluginName() {
		return "CrazyCrates";
	}
	
	@Override
	public boolean isCrate(String name) {
		return cc.getCrateFromName(name) != null;
	}
	
	@Override
	public int getPrizeSize(String crate) {
		return cc.getCrateFromName(crate).getPrizes().size();
	}
	
	@Override
	public ItemStack getDisplayItem(String crate, int prize) {
		return cc.getCrateFromName(crate).getPrizes().get(prize).getDisplayItem();
	}
	
	@Override
	public ItemStack getDisplayItem(String crate, String prize) {
		return cc.getCrateFromName(crate).getPrize(prize).getDisplayItem();
	}
	
}