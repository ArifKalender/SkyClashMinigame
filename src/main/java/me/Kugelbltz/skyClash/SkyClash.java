package me.Kugelbltz.skyClash;

import me.Kugelbltz.skyClash.commands.*;
import me.Kugelbltz.skyClash.commands.SCAdmin;
import me.Kugelbltz.skyClash.player.ClassManagement;
import me.Kugelbltz.skyClash.player.InventoryManagement;
import me.Kugelbltz.skyClash.player.PlayerRegenerativeStats;
import me.Kugelbltz.skyClash.player.CustomDamageHandler;
import me.Kugelbltz.skyClash.playerdata.PlayerData;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyClash extends JavaPlugin {

    /*
    *
    * En son envanter yönetimini ayarlayacaktın.
    *
    */
    public static Plugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        setFields();
        saveDefaultConfig();

    }

    private void setFields(){
        ClassManagement.classTick();
        PlayerRegenerativeStats.displayPlayerStats();
        PlayerRegenerativeStats.regenerateStats();
        new InventoryManagement();

        getServer().getPluginManager().registerEvents(new ClassManagement(),this);
        getServer().getPluginManager().registerEvents(new CustomDamageHandler(),this);

        getCommand("choose").setExecutor(new Choose());
        getCommand("skyclashadmin").setExecutor(new SCAdmin());

        new PlayerData();
    }

    
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
