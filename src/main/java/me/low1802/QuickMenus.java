package me.low1802;

import org.bukkit.plugin.Plugin;

public class QuickMenus {
    private static QuickMenus instanece;
    private Plugin plugin;

    private MenuHandler menuHandler;

    private QuickMenus() {}

    public static void start(Plugin plugin) {
        instanece = new QuickMenus();
        instanece.plugin = plugin;
        instanece.menuHandler = new MenuHandler(plugin);
    }

    public static QuickMenus getInstance() {
        return instanece;
    }

    public static Plugin getPlugin() {
        return instanece.plugin;
    }

    public static MenuHandler getMenuHandler() {
        return instanece.menuHandler;
    }
}