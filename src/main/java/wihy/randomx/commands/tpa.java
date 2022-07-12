package wihy.randomx.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import wihy.randomx.Main;

import java.io.IOException;
import java.util.HashMap;

import static wihy.randomx.commands.util.color;

public class tpa implements CommandExecutor {
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {return true;}
        Player player = (Player) sender;
        if(cmd.getName().equals("tpa")) {
            int cooldownTime = 120;
            if(cooldowns.containsKey(sender.getName())) {
                long secondsLeft = ((cooldowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                if(secondsLeft>0) {
                    sender.sendMessage(color("&c&lERROR &cYou cant use this for another "+ secondsLeft +" seconds!"));
                    return true;
                }
            }
            if(args.length == 0) {
                player.sendMessage(color("&c&lERROR &cIncorrect usage! " + "&7/tpa <player>"));
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                player.sendMessage(color("&c&lERROR &cThe player " + args[0] + " is not online"));
                return true;
            }
            if(target == player) {
                player.sendMessage(color("&c&lERROR &cYou can't teleport to yourself!"));
                return true;
            }
            try {
                player.sendMessage(color("&a&lSUCCESS &aYou have sent a teleport request to &b" + target.getName()));
                target.sendMessage(color("&aYou have received a teleport request from &b" + player.getName()));
                target.sendMessage(color("&aType &7/tpaccept &ato accept the request"));
                target.setMetadata("tpa", new org.bukkit.metadata.FixedMetadataValue(Main.getPlugin(), player.getName()));
                new BukkitRunnable(){
                    public void run(){
                        if(target.hasMetadata("tpa")) {
                            target.removeMetadata("tpa", Main.getPlugin());
                            player.sendMessage(color("&c&lERROR &cThe teleport request has expired!"));
                        }
                    }
                }.runTaskLater(Main.getPlugin(), 1200);


                cooldowns.put(sender.getName(), System.currentTimeMillis());
                return true;
            } catch (CommandException e) {
                player.sendMessage(color("&c&lERROR &cThe player " + target.getName() + " is not online"));
                return true;
            }

        }
        if(cmd.getName().equals("tpaccept")) {
            if(player.hasMetadata("tpa")) {
                String target = player.getMetadata("tpa").get(0).asString();
                Player playerTarget = Bukkit.getPlayer(target);
                assert (playerTarget != null);
                playerTarget.removeMetadata("tpa", Main.getPlugin());
                playerTarget.teleport(player);
                playerTarget.sendMessage(color("&a&lSUCCESS &aYou have teleported to &b" + player.getName()));
                player.sendMessage(color("&a&lSUCCESS&a The player &b" + playerTarget.getName() + "&a has been teleported to you"));
                return true;
            } else {
                player.sendMessage(color("&c&lERROR &cYou have no teleport request!"));
                return true;
            }
        }
        return true;
    }
}
