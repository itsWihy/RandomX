package wihy.randomx.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import wihy.randomx.Main;
import wihy.randomx.util;

import java.util.Objects;

public class dmg implements Listener {
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

            as.setCustomName(ChatColor.translateAlternateColorCodes('&', fColor + "" + event.getDamage() + fColor + "" + "DMG"));
            as.setCustomNameVisible(true);

            for(int i = 0; i < 11; i++) {
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> as.teleport(as.getLocation().add(0, 0.11, 0)), 2L);
            }
            as.damage(128518258, as.getKiller());
        }
    }
}
