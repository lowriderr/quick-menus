package me.low1802;

import me.low1802.button.Button;
import me.low1802.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Map;
import java.util.Objects;

public class MenuListener implements Listener {
    private final MenuHandler handler;

    public MenuListener(MenuHandler handler) {
        this.handler = handler;
    }

    @EventHandler
    public void handleClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        ClickType clickType = event.getClick();

        if(!handler.isInMenu(player)) return;

        Menu menu = handler.getMenu(player);
        Map<Integer, Button> buttons = menu.getButtons(player);

        int position = event.getRawSlot();
        if(position > menu.getRows(player) * 9) return; // this is to avoid fire this in the below inventory

        Button button = buttons.get(position);

        if(Objects.isNull(button)) return;

        boolean cancel = button.onClick(player, clickType);
        event.setCancelled(cancel);
    }
}
