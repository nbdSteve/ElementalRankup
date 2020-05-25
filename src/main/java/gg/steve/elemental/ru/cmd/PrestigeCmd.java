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

public class PrestigeCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                CommandDebug.ONLY_PLAYERS_ACCESSIBLE.message(sender);
                return true;
            }
            if (!PermissionNode.PRESTIGE.hasPermission(sender)) {
                CommandDebug.INSUFFICIENT_PERMISSION.message(sender, PermissionNode.PRESTIGE.get());
            } else {
                if (!PermissionNode.MAX_RANK.hasPermission(sender)) {
                    CommandDebug.NOT_MAX_RANK.message(sender);
                } else {
                    CommandUtil.execute(Files.CONFIG.get().getStringList("prestige"), (Player) sender);
                    MessageType.PRESTIGE.message(sender);
                }
            }
            return true;
        } else {
            CommandDebug.INVALID_COMMAND.message(sender);
        }
//        switch (args[0].toLowerCase()) {
//            case "help": case "h":
//                if (!PermissionNode.HELP.hasPermission(sender)) {
//                    CommandDebug.INSUFFICIENT_PERMISSION.message(sender, PermissionNode.HELP.get());
//                } else {
//                    MessageType.HELP.message(sender);
//                }
//                break;
//            case "reload": case "r":
//                if (!PermissionNode.RELOAD.hasPermission(sender)) {
//                    CommandDebug.INSUFFICIENT_PERMISSION.message(sender, PermissionNode.RELOAD.get());
//                } else {
//                    Files.reload();
//                    Bukkit.getPluginManager().disablePlugin(Rankup.get());
//                    Bukkit.getPluginManager().enablePlugin(Rankup.get());
//                    MessageType.RELOAD.message(sender);
//                }
//                case ""
//        }
        return true;
    }
}
