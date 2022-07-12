package wihy.randomx.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class util {
    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static Location getTargetLocation(Player player) {
        return player.getTargetBlock(null, 50).getLocation();
    }
}
