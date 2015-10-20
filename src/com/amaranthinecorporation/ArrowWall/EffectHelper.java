package com.amaranthinecorporation.ArrowWall;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectHelper implements Listener{
	public EffectHelper(ArrowWall plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Arrow && event.getEntity() instanceof LivingEntity) {
			Projectile arrow = (Projectile) event.getDamager();
			if (arrow.hasMetadata("Poison")) {
				LivingEntity entity = (LivingEntity) event.getEntity();
				entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 1));
			}
		}
	}
}
