package wihy.randomx.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import wihy.randomx.Main;
import wihy.randomx.util;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

public class dmg implements Listener {

    private static final DecimalFormat df = new DecimalFormat("0.0");

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            ArmorStand as = Objects.requireNonNull(event.getEntity().getLocation().getWorld()).spawn(event.getEntity().getLocation().add(0, 1, 0), ArmorStand.class);
            as.setInvisible(true);
            as.setSmall(true);
            as.setGravity(false);
            as.setMarker(true);
            String[] color = ("0123456789ABCDEF").split("");

            String fColor = "&" + util.getRandom(color);



            as.setCustomName(ChatColor.translateAlternateColorCodes('&', fColor + "" + df.format(event.getDamage()) + fColor + "" + "DMG"));
            as.setCustomNameVisible(true);
            long integer = 1L;
            for(int i = 0; i < 11; i++) {
                integer++;
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> as.teleport(as.getLocation().add(0, 0.11, 0)), integer);
            }
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), as::remove, 40L);
        }
    }
}
