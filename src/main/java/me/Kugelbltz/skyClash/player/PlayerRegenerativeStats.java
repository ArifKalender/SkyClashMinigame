package me.Kugelbltz.skyClash.player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import static me.Kugelbltz.skyClash.SkyClash.plugin;

public class PlayerRegenerativeStats {

    public static HashMap<Player, Integer> mana = new HashMap<Player, Integer>();
    final static int maxMana = plugin.getConfig().getInt("SkyClash.Player.BaseMana");
    final static int manaIncrement = plugin.getConfig().getInt("SkyClash.Player.BaseManaRegenPerSecond");

    public static void displayPlayerStats() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    int maxHealth = (int) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
                    int currentHealth = (int) player.getHealth();

                    if (mana.get(player) != null) {
                        String message = "§c❤ Health: §4" + currentHealth + "§7/§4" + maxHealth + "          §b❈ Mana: §3" + mana.get(player) + "§7/§3" + maxMana;
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(message));

                    } else {
                        mana.put(player, (int) maxMana / 2);
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 10);
    }

    public static void regenerateStats() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (mana.get(player) != null) {
                        if (mana.get(player) + manaIncrement < maxMana) {
                            mana.put(player, mana.get(player) + manaIncrement);
                        } else {
                            mana.put(player, maxMana);
                        }
                    } else {
                        mana.put(player, (int) maxMana / 2);
                    }


                    int maxHealth = (int) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();

                    if (!player.isDead()) {
                        if (player.getHealth() + (maxHealth / 20) < maxHealth) {
                            player.setHealth(player.getHealth() + maxHealth / 20);
                        } else {
                            player.setHealth(maxHealth);
                        }

                    }
                }
            }
        }.runTaskTimer(plugin, 0, 20);
    }

}
