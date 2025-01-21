package me.Kugelbltz.skyClash.commands;

import me.Kugelbltz.skyClash.player.ClassManagement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Choose implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            ClassManagement.openLexicon((Player) commandSender);
        }else {
            commandSender.sendMessage("§cThis command can only be executed by players.");
        }

        return false;
    }
}
