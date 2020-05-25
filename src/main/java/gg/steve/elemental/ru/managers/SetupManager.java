package gg.steve.elemental.ru.managers;

import gg.steve.elemental.ru.Rankup;
import gg.steve.elemental.ru.cmd.MaxCmd;
import gg.steve.elemental.ru.cmd.PrestigeCmd;
import gg.steve.elemental.ru.cmd.RankupCmd;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 * Class that handles setting up the plugin on start
 */
public class SetupManager {

    private SetupManager() throws IllegalAccessException {
        throw new IllegalAccessException("Manager class cannot be instantiated.");
    }

    /**
     * Loads the files into the file manager
     *
     * @param fileManager FileManager, the plugins file manager
     */
    public static void setupFiles(FileManager fileManager) {
        // general files
        for (Files file : Files.values()) {
            file.load(fileManager);
        }
    }

    public static void registerCommands(Rankup instance) {
        instance.getCommand("prestige").setExecutor(new PrestigeCmd());
        instance.getCommand("rankup").setExecutor(new RankupCmd());
        instance.getCommand("maxrankup").setExecutor(new MaxCmd());
    }

    /**
     * Register all of the events for the plugin
     *
     * @param instance Plugin, the main plugin instance
     */
    public static void registerEvents(Plugin instance) {
        PluginManager pm = instance.getServer().getPluginManager();
    }
}
