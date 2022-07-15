
package wihy.randomx;

import org.bukkit.plugin.java.JavaPlugin;
import wihy.randomx.commands.a;
import wihy.randomx.commands.tpa;
import wihy.randomx.commands.tplist;
import wihy.randomx.listeners.dmg;

import java.util.Objects;

public final class Main extends JavaPlugin {
    private static Main plugin;
    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Objects.requireNonNull(getCommand("tpaccept")).setExecutor(new tpa());
        Objects.requireNonNull(getCommand("tpa")).setExecutor(new tpa());
        Objects.requireNonNull(getCommand("a")).setExecutor(new a());
        Objects.requireNonNull(getCommand("tplist")).setExecutor(new tplist());

        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.tplist(), this);
        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.dmg(), this);
        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.tpa(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
