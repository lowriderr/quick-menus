package me.low1802.menu;

import com.google.common.collect.Maps;
import me.low1802.QuickMenus;
import me.low1802.button.Button;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Map;
import java.util.Objects;

public class Menu {
    public int getRows(Player player) {
        return 3;
    }

    public String getDisplayName(Player player) {
        return "";
    }

    public Map<Integer, Button> getButtons(Player player) {
        return Maps.newHashMap();
    }

    public void onClose(Player player) {}

    public void onOpen(Player player) {}

    public void showMenu(Player player) {
        String displayName = getDisplayName(player);
        int rows = getRows(player);

        Inventory inv = QuickMenus.getPlugin().getServer().createInventory(null, rows * 9, displayName);

        for (Map.Entry<Integer, Button> entry : getButtons(player).entrySet()) {
            int position = entry.getKey();
            Button button = entry.getValue();

            inv.setItem(position, button.toItemStack(player));
        }

        if(Objects.nonNull(player.openInventory(inv)))
            player.closeInventory();

        player.openInventory(inv);
        QuickMenus.getMenuHandler().registerPlayer(player, this);
        this.onOpen(player);
    }
}
