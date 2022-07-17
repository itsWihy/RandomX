package wihy.randomx.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Objects;

import static wihy.randomx.util.color;

public class tplist implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {return true;}
        Player player = (Player) sender;

        if(command.getName().equals("tplist")) {
            if(player.hasPermission("tplist")) {
                ArrayList<String> list;

                list = new ArrayList<>();

                for (Player p : Bukkit.getOnlinePlayers()) {


                    if (!p.getName().equals(player.getName())) {
                        list.add(p.getDisplayName());
                    }
                }
                Inventory inventory = Bukkit.createInventory(null, 54, "Player list");

                for (int i = 0; i < list.size(); i++) {
                    ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta head = (SkullMeta) item.getItemMeta();
                    assert head != null;
                    head.setOwner(String.valueOf(list.get(i)));
                    head.setDisplayName(list.get(i));

                    Location loc = Objects.requireNonNull(Bukkit.getPlayer(list.get(i))).getLocation();
                    int x = loc.getBlockX();
                    int y = loc.getBlockY();
                    int z = loc.getBlockZ();

                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(color("&bClick to teleport to &a" + list.get(i)));
                    lore.add(color("&aLocation: &f" + x + " " + y + " " + z));

                    head.setLore(lore);
                    item.setItemMeta(head);
                    inventory.setItem(i, item);

                }
                player.openInventory(inventory);
            }
        }

        return true;
    }
}
