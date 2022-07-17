package wihy.randomx.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class builder implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("Builder Inventory")) {
            if(event.getInventory().getItem(event.getSlot()) != null) {
                event.setCancelled(true);
                if(event.getSlot() < 25) {
                   event.getWhoClicked().getInventory().addItem(event.getInventory().getItem(event.getSlot()));
                   event.getWhoClicked().sendMessage("Added item to inventory");
                } else {
                    String gamemode = event.getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName();
                    event.getWhoClicked().setGameMode(org.bukkit.GameMode.valueOf(gamemode));
                }

            }
        }
    }

}
