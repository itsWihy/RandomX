
package wihy.randomx;

import org.bukkit.plugin.java.JavaPlugin;
import wihy.randomx.commands.builder;
import wihy.randomx.commands.tpa;
import wihy.randomx.commands.tplist;

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
        Objects.requireNonNull(getCommand("tplist")).setExecutor(new tplist());
        Objects.requireNonNull(getCommand("builder")).setExecutor(new builder());

        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.builder(), this);
        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.tplist(), this);
        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.dmg(), this);
        getServer().getPluginManager().registerEvents(new wihy.randomx.listeners.tpa(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
