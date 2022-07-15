package wihy.randomx;

import org.bukkit.ChatColor;

import java.util.Random;

public class util {
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
