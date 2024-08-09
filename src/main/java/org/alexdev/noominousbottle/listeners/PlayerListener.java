package org.alexdev.noominousbottle.listeners;

import org.alexdev.noominousbottle.NoOminousBottles;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener {
    private final NoOminousBottles plugin;

    public PlayerListener(NoOminousBottles plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e)
    {

    }

}
