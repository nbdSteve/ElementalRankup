package gg.steve.elemental.ru.cmd;

import gg.steve.elemental.ru.Rankup;
import gg.steve.elemental.ru.managers.Files;
import gg.steve.elemental.ru.message.CommandDebug;
import gg.steve.elemental.ru.message.MessageType;
import gg.steve.elemental.ru.permission.PermissionNode;
import gg.steve.elemental.ru.utils.CommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaxCmd implements CommandExecutor {

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
                    MessageType.RANKUP.message(player, getNextRank(recursiveRankup(player, getRank(player))).toUpperCase());
                }
            }
            return true;
        } else {
            CommandDebug.INVALID_COMMAND.message(sender);
        }
        return true;
    }

    public String recursiveRankup(Player player, String rank) {
        if (rank.equalsIgnoreCase("prestige")) return "z";
        double price = Files.CONFIG.get().getInt("price." + rank);
        if (Rankup.eco().getBalance(player) < price) {
            return rank;
        } else if (price == 0) {
            return rank;
        } else {
            Rankup.eco().withdrawPlayer(player, price);
            CommandUtil.execute(Files.CONFIG.get().getStringList("rankup"), player);
            return recursiveRankup(player, getNextRank(rank));
        }
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

    public String getNextRank(String rank) {
        if (rank.equalsIgnoreCase("z")) return "prestige";
        if (rank.equalsIgnoreCase("y")) return "z";
        if (rank.equalsIgnoreCase("x")) return "y";
        if (rank.equalsIgnoreCase("w")) return "x";
        if (rank.equalsIgnoreCase("v")) return "w";
        if (rank.equalsIgnoreCase("u")) return "v";
        if (rank.equalsIgnoreCase("t")) return "u";
        if (rank.equalsIgnoreCase("s")) return "t";
        if (rank.equalsIgnoreCase("r")) return "s";
        if (rank.equalsIgnoreCase("q")) return "r";
        if (rank.equalsIgnoreCase("p")) return "q";
        if (rank.equalsIgnoreCase("o")) return "p";
        if (rank.equalsIgnoreCase("n")) return "o";
        if (rank.equalsIgnoreCase("m")) return "n";
        if (rank.equalsIgnoreCase("l")) return "m";
        if (rank.equalsIgnoreCase("k")) return "l";
        if (rank.equalsIgnoreCase("j")) return "k";
        if (rank.equalsIgnoreCase("i")) return "j";
        if (rank.equalsIgnoreCase("h")) return "i";
        if (rank.equalsIgnoreCase("g")) return "h";
        if (rank.equalsIgnoreCase("f")) return "g";
        if (rank.equalsIgnoreCase("e")) return "f";
        if (rank.equalsIgnoreCase("d")) return "e";
        if (rank.equalsIgnoreCase("c")) return "d";
        if (rank.equalsIgnoreCase("b")) return "c";
        if (rank.equalsIgnoreCase("a")) return "b";
        return "a";
    }
}
