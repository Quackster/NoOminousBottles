package org.alexdev.noominousbottle;

import org.alexdev.noominousbottle.listeners.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class NoOminousBottles extends JavaPlugin {
    private static NoOminousBottles instance;

    private Logger logger;

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();

        registerListeners();
    }

    /**
     * Register the listeners.
     */
    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new EntityListener(this), this);
    }

    @Override
    public void onDisable() {

    }
}
