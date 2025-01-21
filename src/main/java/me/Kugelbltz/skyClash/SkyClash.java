package me.Kugelbltz.skyClash;

import me.Kugelbltz.skyClash.commands.Choose;
import me.Kugelbltz.skyClash.commands.SCAdmin;
import me.Kugelbltz.skyClash.player.ClassManagement;
import me.Kugelbltz.skyClash.player.PlayerRegenerativeStats;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyClash extends JavaPlugin {

    /*
    * - Scattering low damage charge
    * - Miniplayer charge
    * - Ground following charge
    * - Air following charge
    *
    */
    /*
    *
    * En son custom config dosyası yapıyordun
    * ve ClassManagement'ta setPlayerClass metotunu tamamlıyordun, bu metot
    * yeni config dosyasına oyuncunun classını yazacak veritabanı gibi.
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

        getServer().getPluginManager().registerEvents(new ClassManagement(),this);

        getCommand("choose").setExecutor(new Choose());
        getCommand("skyclashadmin").setExecutor(new SCAdmin());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
