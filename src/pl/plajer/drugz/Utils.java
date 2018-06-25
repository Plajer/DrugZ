package pl.plajer.drugz;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Plajer
 * <p>
 * Created at 25.06.2018
 */
public class Utils {

    private static Main plugin = JavaPlugin.getPlugin(Main.class);

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(message));
    }

    public static String colorRaw(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
