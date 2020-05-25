package gg.steve.elemental.ru.utils;


import gg.steve.elemental.ru.Rankup;

public class LogUtil {

    public static void info(String message) {
        Rankup.get().getLogger().info(message);
    }

    public static void warning(String message) {
        Rankup.get().getLogger().warning(message);
    }
}
