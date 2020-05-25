package gg.steve.elemental.ru.cmd;

import gg.steve.elemental.ru.Rankup;
import gg.steve.elemental.ru.managers.Files;
import gg.steve.elemental.ru.message.CommandDebug;
import gg.steve.elemental.ru.message.MessageType;
import gg.steve.elemental.ru.permission.PermissionNode;
import gg.steve.elemental.ru.utils.CommandUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankupCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                CommandDebug.ONLY_PLAYERS_ACCESSIBLE.message(sender);
                return true;
            }
            if (!PermissionNode.USE.hasPermission(sender)) {
                CommandDebug.INSUFFICIENT_PERMISSION.message(sender, PermissionNode.USE.get());
            } else {
                if (PermissionNode.MAX_RANK.hasPermission(sender)) {
                    CommandDebug.MAX_RANK.message(sender);
                } else {
                    Player player = (Player) sender;
                    double price = Files.CONFIG.get().getInt("price." + getRank(player));
                    if (Rankup.eco().getBalance(player) < price) {
                        MessageType.INSUFFICIENT_FUNDS.message(player);
                        return true;
                    }
                    Rankup.eco().withdrawPlayer(player, price);
                    CommandUtil.execute(Files.CONFIG.get().getStringList("rankup"), (Player) sender);
                    MessageType.RANKUP.message(player, getNextRank(player).toUpperCase());
                }
            }
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "help":
            case "h":
                if (!PermissionNode.HELP.hasPermission(sender)) {
                    CommandDebug.INSUFFICIENT_PERMISSION.message(sender, PermissionNode.HELP.get());
                } else {
                    MessageType.HELP.message(sender);
                }
                break;
            case "reload":
            case "r":
                if (!PermissionNode.RELOAD.hasPermission(sender)) {
                    CommandDebug.INSUFFICIENT_PERMISSION.message(sender, PermissionNode.RELOAD.get());
                } else {
                    Files.reload();
                    Bukkit.getPluginManager().disablePlugin(Rankup.get());
                    Bukkit.getPluginManager().enablePlugin(Rankup.get());
                    MessageType.RELOAD.message(sender);
                }
                break;
            default:
                CommandDebug.INVALID_COMMAND.message(sender);
        }
        return true;
    }

    public String getRank(Player player) {
        if (player.hasPermission("emc.rankup.z")) return "z";
        if (player.hasPermission("emc.rankup.y")) return "y";
        if (player.hasPermission("emc.rankup.x")) return "z";
        if (player.hasPermission("emc.rankup.w")) return "w";
        if (player.hasPermission("emc.rankup.v")) return "v";
        if (player.hasPermission("emc.rankup.u")) return "u";
        if (player.hasPermission("emc.rankup.t")) return "t";
        if (player.hasPermission("emc.rankup.s")) return "s";
        if (player.hasPermission("emc.rankup.r")) return "r";
        if (player.hasPermission("emc.rankup.q")) return "q";
        if (player.hasPermission("emc.rankup.p")) return "p";
        if (player.hasPermission("emc.rankup.o")) return "o";
        if (player.hasPermission("emc.rankup.n")) return "n";
        if (player.hasPermission("emc.rankup.m")) return "m";
        if (player.hasPermission("emc.rankup.l")) return "l";
        if (player.hasPermission("emc.rankup.k")) return "k";
        if (player.hasPermission("emc.rankup.j")) return "j";
        if (player.hasPermission("emc.rankup.i")) return "i";
        if (player.hasPermission("emc.rankup.h")) return "h";
        if (player.hasPermission("emc.rankup.g")) return "g";
        if (player.hasPermission("emc.rankup.f")) return "f";
        if (player.hasPermission("emc.rankup.e")) return "e";
        if (player.hasPermission("emc.rankup.d")) return "d";
        if (player.hasPermission("emc.rankup.c")) return "c";
        if (player.hasPermission("emc.rankup.b")) return "b";
        if (player.hasPermission("emc.rankup.a")) return "a";
        return "a";
    }

    public String getNextRank(Player player) {
        if (player.hasPermission("emc.rankup.z")) return "prestige";
        if (player.hasPermission("emc.rankup.y")) return "z";
        if (player.hasPermission("emc.rankup.x")) return "y";
        if (player.hasPermission("emc.rankup.w")) return "x";
        if (player.hasPermission("emc.rankup.v")) return "w";
        if (player.hasPermission("emc.rankup.u")) return "v";
        if (player.hasPermission("emc.rankup.t")) return "u";
        if (player.hasPermission("emc.rankup.s")) return "t";
        if (player.hasPermission("emc.rankup.r")) return "s";
        if (player.hasPermission("emc.rankup.q")) return "r";
        if (player.hasPermission("emc.rankup.p")) return "q";
        if (player.hasPermission("emc.rankup.o")) return "p";
        if (player.hasPermission("emc.rankup.n")) return "o";
        if (player.hasPermission("emc.rankup.m")) return "n";
        if (player.hasPermission("emc.rankup.l")) return "m";
        if (player.hasPermission("emc.rankup.k")) return "l";
        if (player.hasPermission("emc.rankup.j")) return "k";
        if (player.hasPermission("emc.rankup.i")) return "j";
        if (player.hasPermission("emc.rankup.h")) return "i";
        if (player.hasPermission("emc.rankup.g")) return "h";
        if (player.hasPermission("emc.rankup.f")) return "g";
        if (player.hasPermission("emc.rankup.e")) return "f";
        if (player.hasPermission("emc.rankup.d")) return "e";
        if (player.hasPermission("emc.rankup.c")) return "d";
        if (player.hasPermission("emc.rankup.b")) return "c";
        if (player.hasPermission("emc.rankup.a")) return "b";
        return "a";
    }
}
