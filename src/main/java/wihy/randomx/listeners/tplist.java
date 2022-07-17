package wihy.randomx.listeners;


import org.bukkit.Bukkit;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static wihy.randomx.util.color;

public class tplist implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("Player list")) {
            if(event.getInventory().getItem(event.getSlot()) != null) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                String playerToTP = Objects.requireNonNull(Objects.requireNonNull(event.getInventory().getItem(event.getSlot())).getItemMeta()).getDisplayName();
                player.teleport(Objects.requireNonNull(Bukkit.getPlayer(playerToTP)));
                player.sendMessage(color("&aTelepored to " + playerToTP));

            }
        }
    }

}
