package me.Kugelbltz.skyClash.player;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;

public enum PlayerClass implements Keyed {

    SHATTERMAN("Shatterman"),
    SPEEDSTER("Speedster"),
    TANK("Tank");


    private PlayerClass(String key) {
    }

    @Override
    public NamespacedKey getKey() {
        return null;
    }
}
