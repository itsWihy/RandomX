package wihy.randomx.listeners;

import com.google.common.util.concurrent.Service;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import wihy.randomx.Main;

public class tpa implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().removeMetadata("tpa", Main.getPlugin());
    }
}
