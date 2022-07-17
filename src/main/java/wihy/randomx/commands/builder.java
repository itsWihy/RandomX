package wihy.randomx.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static wihy.randomx.util.color;
import static wihy.randomx.util.rename;

public class builder implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {return true;}
        Player player = (Player) sender;
        if(player.hasPermission("builder")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(color("&7Your gamemode was set to &aCreative"));

            Inventory inventory = Bukkit.createInventory(null, 45, "Builder Inventory");
            inventory.setItem(10, new ItemStack(Material.COMMAND_BLOCK));
            inventory.setItem(11, new ItemStack(Material.STONE_BUTTON));
            inventory.setItem(12, new ItemStack(Material.DEBUG_STICK));
            inventory.setItem(13, new ItemStack(Material.BARRIER));
            inventory.setItem(14, new ItemStack(Material.SOUL_LANTERN));
            inventory.setItem(15, new ItemStack(Material.ITEM_FRAME));
            inventory.setItem(16, new ItemStack(Material.WOODEN_AXE));

            inventory.setItem(30, rename(new ItemStack(Material.GRASS_BLOCK), "CREATIVE"));
            inventory.setItem(31, rename(new ItemStack(Material.SPLASH_POTION), "SPECTATOR"));
            inventory.setItem(32, rename(new ItemStack(Material.APPLE), "SURVIVAL"));

            player.openInventory(inventory);
            return true;
        }
        return true;

    }
}
