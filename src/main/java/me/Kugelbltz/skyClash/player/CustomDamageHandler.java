package me.Kugelbltz.skyClash.player;

import org.bukkit.Sound;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.util.Vector;

public class CustomDamageHandler implements Listener {

    @EventHandler
    private void onDeath(PlayerDeathEvent event){
        Player player=event.getEntity();
        player.setRespawnLocation(player.getLocation());
        Entity killer = event.getEntity().getKiller();
        /*player.getBedLocation().setY(player.getLocation().getY());
        player.getBedLocation().setX(player.getLocation().getX());
        player.getBedLocation().setZ(player.getLocation().getZ());
        player.getBedLocation().setDirection(player.getEyeLocation().getDirection());
        player.getBedLocation().setPitch(player.getEyeLocation().getPitch());
        player.getBedLocation().setYaw(player.getEyeLocation().getYaw());
        player.getBedLocation().setWorld(player.getWorld());*/

        //player.spigot().respawn();

        if (killer instanceof Player) {
            killer.getWorld().playSound(killer, Sound.ITEM_GOAT_HORN_SOUND_1, 1, 1);
            ((Player) killer).sendTitle("§6Congratulations!", "§7You killed §b" + player.getName(), 10, 40, 10);
            player.sendTitle("§cYikes! You died!", "§7You were killed by §b" + killer.getName());
            player.getWorld().playSound(player, Sound.BLOCK_SCULK_SHRIEKER_SHRIEK , 1, 1);
            player.setVelocity(new Vector(0,1.5,0));
        } else {
            player.sendTitle("§cYikes! You died!", "§7And you did it on your own! §c§oDisgrace...", 10, 40, 10);
            player.setVelocity(new Vector(0,1.5,0));
            player.getWorld().playSound(player, Sound.BLOCK_SCULK_SHRIEKER_SHRIEK , 1, 0);
        }
    }


    @EventHandler
    private void onDamage(EntityDamageEvent event){
        if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
            if(event.getEntity() instanceof Player){
                event.setCancelled(true);
            }
        }
    }

}
