package me.garrett.ccaddon;


import org.bukkit.entity.Player;

import me.badbones69.crazycrates.api.CrazyCrates;
import me.badbones69.crazycrates.api.objects.Crate;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PlaceHolders
  extends PlaceholderExpansion
{
	public int i;
	//private final CCAddon plugin;
	public PlaceHolders(CCAddon plugin) {
   //     this.plugin = plugin;
		i = 0;
    }
	public String prize;
	public Crate c;
  public boolean canRegister()
  {
    return true;
  }
  
  public String getAuthor()
  {
    return "gamerduck";
  }
  
  public String getIdentifier()
  {
    return "ccaddon";
  }
  
  public String getPlugin()
  {
    return null;
  }
  
  public String getVersion()
  {
    return "1.0.0";
  }
  
  public String onPlaceholderRequest(Player p, String identifier)
  {		
	  if (identifier.contains("rewards")) {
		  String[] id = identifier.split("_");
		  c = CrazyCrates.getInstance().getCrateFromName(id[1]);
		  i++;
		  int e = c.getPrizes().size();
		  if (i == e) {
			  i = 0;
		  }
		  return c.getPrizes().get(i).getDisplayItem().getItemMeta().getDisplayName();
	    }
	return identifier;
    
  }
}
