package me.low1802.button;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;
import java.util.Objects;

public class Button {
    public String getDisplayName(Player player) {
        return "";
    }

    public List<String> getDescription(Player player) {
        return Lists.newArrayList();
    };

    public Material getMaterial(Player player) {
        return Material.AIR;
    }

    public ItemStack getItemStack(Player player) {
        return null;
    }

    public boolean onClick(Player player, ClickType clickType) {
        return true;
    }

    public ItemStack toItemStack(Player player) {
        if(Objects.nonNull( getItemStack(player) )) {
            return getItemStack(player);
        }

        Material material = getMaterial(player);
        List<String> lore = getDescription(player);
        String name = getDisplayName(player);

        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        meta.setDisplayName(name);

        item.setItemMeta(meta);

        return item;
    }
}
