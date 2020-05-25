package gg.steve.elemental.ru;

import gg.steve.elemental.ru.managers.FileManager;
import gg.steve.elemental.ru.managers.SetupManager;
import gg.steve.elemental.ru.utils.LogUtil;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rankup extends JavaPlugin {
    private static Rankup instance;
    private static Economy economy;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        // setup shit
        SetupManager.setupFiles(new FileManager(instance));
        SetupManager.registerCommands(instance);
        SetupManager.registerEvents(instance);
        // verify that the server is running vault so that eco features can be used
        if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
            economy = getServer().getServicesManager().getRegistration(Economy.class).getProvider();
        } else {
            LogUtil.info("Unable to find economy instance, disabling economy features.");
            economy = null;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Rankup get() {
        return instance;
    }

    public static Economy eco() {
        return economy;
    }
}
