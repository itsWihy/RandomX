package wihy.randomx.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class a implements CommandExecutor {
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equals("a")) {
            if (player.hasPermission("a")) {
                for (int i = 0; i < 4; i++) {
                    util.getTargetLocation(player).add(0, i, 0).getBlock().setType(Material.STONE);
                    util.getTargetLocation(player).add(0, i, 3).getBlock().setType(Material.STONE);
                }
                for (int i = 2; i < 6; i = i+2) {
                    util.getTargetLocation(player).add(0, i, 1).getBlock().setType(Material.STONE);
                    util.getTargetLocation(player).add(0, i, 2).getBlock().setType(Material.STONE);
                }

                return true;
            }
        }
        return true;
    }
}
