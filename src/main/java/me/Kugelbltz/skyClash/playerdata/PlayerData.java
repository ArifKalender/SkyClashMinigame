package me.Kugelbltz.skyClash.playerdata;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static me.Kugelbltz.skyClash.SkyClash.plugin;

public class PlayerData {

    public static File file;
    public static FileConfiguration PData;

    public PlayerData(){
        file=new File(plugin.getDataFolder(),"PlayerData.yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PData = YamlConfiguration.loadConfiguration(file);
    }

    public static void saveConfig(){
        try{
            PData.save(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void reloadConfig(){
        PData = YamlConfiguration.loadConfiguration(file);
    }

}
