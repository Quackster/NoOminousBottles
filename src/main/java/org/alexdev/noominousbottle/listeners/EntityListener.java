package org.alexdev.noominousbottle.listeners;

import org.alexdev.noominousbottle.NoOminousBottles;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Illager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityListener implements Listener {
    private final NoOminousBottles plugin;

    public EntityListener(NoOminousBottles plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPillagerDeathEvent(EntityDeathEvent event) {
        if (event.getEntityType() != EntityType.PILLAGER) {
            return;
        }

        var illager = (Illager) event.getEntity();

        if (!illager.isPatrolLeader()) {
            return;
        }

        if (illager.getRaid() != null) {
            return;
        }

        if (event.getEntity().getKiller() != null) {
            this.removeOminousBottle(event);
            this.addBadOmenEffect(event.getEntity().getKiller());
        }
    }

    private void addBadOmenEffect(Player killer) {
        killer.addPotionEffect(new PotionEffect(PotionEffectType.BAD_OMEN, 100 * 20, 1));
    }

    private void removeOminousBottle(EntityDeathEvent event) {
        event.getDrops().removeIf(stack -> stack.getType() == Material.OMINOUS_BOTTLE);
    }
}
