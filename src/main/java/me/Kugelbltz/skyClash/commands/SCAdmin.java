package me.Kugelbltz.skyClash.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.Kugelbltz.skyClash.SkyClash.plugin;

public class SCAdmin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length<1){
            if(commandSender instanceof Player){
                sendHelpMessage((Player) commandSender);
            }

        }else {
            if(strings.length==1){
                if(strings[0].equalsIgnoreCase("reload")){
                    plugin.reloadConfig();
                    commandSender.sendMessage("§3(Hopefully) Reloaded SkyClash config!");
                }
            }
        }

        return false;
    }
    private void sendHelpMessage(Player player){
        player.sendMessage("§c[SkyClash Admin Commands]");

        player.sendMessage("§c/scadmin §4reload -> Reloads skyclash config");

        player.sendMessage("§c-------------------------");
    }
}
