package me.Kugelbltz.skyClash.player;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.HashMap;

import static me.Kugelbltz.skyClash.SkyClash.plugin;

public class ClassManagement implements Listener {

    public static HashMap<Player, PlayerClass> playerClass = new HashMap<Player, PlayerClass>();

    public static void classTick() {
        new BukkitRunnable() {
            public int speed, jump, health;

            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (playerClass.get(player) != null) {
                        if (playerClass.get(player) == PlayerClass.SPEEDSTER) {
                            this.speed = plugin.getConfig().getInt("SkyClash.Player.Classes.Speedster.Speed");
                            this.jump = plugin.getConfig().getInt("SkyClash.Player.Classes.Speedster.JumpBoost");
                            this.health= plugin.getConfig().getInt("SkyClash.Player.Classes.Speedster.Health");
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, speed));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 30, jump));
                            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);

                        } else if (playerClass.get(player) == PlayerClass.TANK) {
                            this.speed = plugin.getConfig().getInt("SkyClash.Player.Classes.Tank.Speed");
                            this.jump = plugin.getConfig().getInt("SkyClash.Player.Classes.Tank.JumpBoost");
                            this.health= plugin.getConfig().getInt("SkyClash.Player.Classes.Tank.Health");
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, speed));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 30, jump));
                            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);

                        } else if (playerClass.get(player) == PlayerClass.SHATTERMAN) {
                            this.speed = plugin.getConfig().getInt("SkyClash.Player.Classes.Shatterman.Speed");
                            this.jump = plugin.getConfig().getInt("SkyClash.Player.Classes.Shatterman.JumpBoost");
                            this.health= plugin.getConfig().getInt("SkyClash.Player.Classes.Shatterman.Health");
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, speed));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 30, jump));
                            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);

                        }
                    }

                }
            }
        }.runTaskTimer(plugin, 0, 20);
    }


    @EventHandler
    private void joinEvent(PlayerJoinEvent event){
        event.getPlayer().setHealthScale(20);
    }

    public static void openLexicon(Player player) {
        Inventory lex = Bukkit.createInventory(player, 27);
        ItemStack panel = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        for (int i = 0; i < 27; i++) {
            lex.setItem(i, panel);
        }
        ItemStack speedster = new ItemStack(Material.FEATHER, 1);
        ItemStack tank = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack shatterman = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta speedsterMeta = speedster.getItemMeta();
        ItemMeta tankMeta = tank.getItemMeta();
        ItemMeta shattermanMeta = shatterman.getItemMeta();
        speedsterMeta.setDisplayName("§bSpeedster!");
        tankMeta.setDisplayName("§aTank!");
        shattermanMeta.setDisplayName("§cShatterman!");
        speedsterMeta.setLore(Arrays.asList("", "§3Speedster can move faster than other classes!", "",
                "§3Speed: §a■■■■■",
                "§3Damage: §a■■■§8■■",
                "§3Defense: §a■§8■■■■"));

        tankMeta.setLore(Arrays.asList("", "§2Tanks take less damage than other classes!", "",
                "§2Speed: §a■§8■■■■",
                "§2Damage: §a■■§8■■■",
                "§2Defense: §a■■■■■"));

        shattermanMeta.setLore(Arrays.asList("", "§4Shattermen deal higher damage than other classes!", "",
                "§4Speed: §a■■■§8■■",
                "§4Damage: §a■■■■§8■",
                "§4Defense: §a■■■§8■■"));

        tank.setItemMeta(tankMeta);
        shatterman.setItemMeta(shattermanMeta);
        speedster.setItemMeta(speedsterMeta);

        lex.setItem(11, speedster);
        lex.setItem(13, shatterman);
        lex.setItem(15, tank);

        player.openInventory(lex);

    }

    @EventHandler
    private void inventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() != null) {
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpeedster!")) {
                        event.setCancelled(true);
                        playerClass.put((Player) event.getWhoClicked(), PlayerClass.SPEEDSTER);
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTank!")) {
                        event.setCancelled(true);
                        playerClass.put((Player) event.getWhoClicked(), PlayerClass.TANK);
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cShatterman!")) {
                        event.setCancelled(true);
                        playerClass.put((Player) event.getWhoClicked(), PlayerClass.SHATTERMAN);
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    private void setPlayerClass(String playerName, String className){


    }
}
