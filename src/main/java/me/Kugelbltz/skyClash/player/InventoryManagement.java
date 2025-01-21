package me.Kugelbltz.skyClash.player;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

import static me.Kugelbltz.skyClash.SkyClash.plugin;

public class InventoryManagement {

    ItemStack cockroach, followingCharge, lineTimedCharge, turret, shatteringCharge, sculkArmor, timeWarp,flight,dash,backDash;
    ItemMeta cockroachMeta, followingChargeMeta, lineTimedChargeMeta, turretMeta, shatteringChargeMeta,
            sculkArmorMeta, timeWarpMeta, flightMeta, dashMeta, backDashMeta;
    public InventoryManagement() {
        cockroach = new ItemStack(Material.DONKEY_SPAWN_EGG);
        followingCharge = new ItemStack(Material.ENDER_EYE);
        lineTimedCharge = new ItemStack(Material.STRING);
        turret = new ItemStack(Material.DISPENSER);
        shatteringCharge=new ItemStack(Material.COCOA_BEANS);
        sculkArmor=new ItemStack(Material.SCULK_VEIN);
        timeWarp=new ItemStack(Material.END_CRYSTAL);
        flight=new ItemStack(Material.NETHER_STAR);
        dash=new ItemStack(Material.SPECTRAL_ARROW);
        backDash=new ItemStack(Material.ARROW);

        cockroachMeta= cockroach.getItemMeta();
        followingChargeMeta=followingCharge.getItemMeta();
        lineTimedChargeMeta=lineTimedCharge.getItemMeta();
        turretMeta=turret.getItemMeta();
        shatteringChargeMeta= shatteringCharge.getItemMeta();
        sculkArmorMeta=sculkArmor.getItemMeta();
        timeWarpMeta=timeWarp.getItemMeta();
        flightMeta=flight.getItemMeta();
        dashMeta=dash.getItemMeta();
        backDashMeta=backDash.getItemMeta();

        cockroachMeta.setDisplayName("§8Cockroach");
        followingChargeMeta.setDisplayName("§9Following Charge");
        lineTimedChargeMeta.setDisplayName("§7Line Charge");
        turretMeta.setDisplayName("§1Turret");
        shatteringChargeMeta.setDisplayName("§4Shattering Charge");
        sculkArmorMeta.setDisplayName("§9Sculk Armor");
        timeWarpMeta.setDisplayName("§dTime Warp");
        flightMeta.setDisplayName("§6Flight");
        dashMeta.setDisplayName("§3Dash!");
        backDashMeta.setDisplayName("§3Back dash");

        cockroachMeta.setLore(Arrays.asList("","§6Usage: §eRIGHT CLICK"));
        followingChargeMeta.setLore(Arrays.asList("","§6Usage: §eRIGHT CLICK"));
        lineTimedChargeMeta.setLore(Arrays.asList("","§6Usage: §eOFFHAND SWAP"));
        turretMeta.setLore(Arrays.asList("","§6Usage: §eRIGHT CLICK"));
        shatteringChargeMeta.setLore(Arrays.asList("","§6Usage: §eSNEAK + OFFHAND SWAP"));
        timeWarpMeta.setLore(Arrays.asList("","§6Usage: §eSNEAK + OFFHAND SWAP"));
        sculkArmorMeta.setLore(Arrays.asList("","§6Usage: §eSNEAK + OFFHAND SWAP"));

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    fillWithAir(player.getInventory());

                }
            }
        }.runTaskTimer(plugin, 0, 5);
    }

    private void fillWithAir(Inventory inventory) {
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, new ItemStack(Material.AIR));
        }
        inventory.setItem(31, new ItemStack(Material.AIR));
    }
}
