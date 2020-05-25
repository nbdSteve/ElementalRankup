package gg.steve.elemental.ru.permission;

import gg.steve.elemental.ru.managers.Files;
import org.bukkit.command.CommandSender;

public enum PermissionNode {
    HELP("command.help"),
    RELOAD("command.reload"),
    PRESTIGE("command.prestige"),
    MAX_RANK("misc.z-rank"),
    USE("command.rankup");

    private String path;

    PermissionNode(String path) {
        this.path = path;
    }

    public String get() {
        return Files.PERMISSIONS.get().getString(this.path);
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(get());
    }
}