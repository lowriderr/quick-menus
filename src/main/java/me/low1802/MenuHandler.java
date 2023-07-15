package me.low1802;

import com.google.common.collect.Maps;
import me.low1802.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.UUID;

public class MenuHandler {
    private final Map<UUID, Menu> menus;

    public MenuHandler(Plugin plugin) {
        menus = Maps.newHashMap();
        plugin.getServer().getPluginManager().registerEvents(new MenuListener(this), plugin);
    }

    public Menu getMenu(UUID uuid) {
        return menus.get(uuid);
    }

    public Menu getMenu(Player player) {
        return menus.get(player.getUniqueId());
    }

    public void registerPlayer(Player player, Menu menu) {
        this.menus.put(player.getUniqueId(), menu);
    }

    public void unRegisterPlayer(Player player) {
        this.menus.remove(player.getUniqueId());
    }

    public boolean isInMenu(UUID uuid) {
        return menus.containsKey(uuid);
    }

    public boolean isInMenu(Player player) {
        return menus.containsKey(player.getUniqueId());
    }
}
