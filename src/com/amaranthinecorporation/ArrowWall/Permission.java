package com.amaranthinecorporation.ArrowWall;

import com.nijikokun.bukkit.Permissions.Permissions;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Permission {

	@SuppressWarnings("unused")
	
	private static Permissions permissionsPlugin;
	private static boolean permissionsEnabled = false;

	public static void initialize(Server server) {
		Plugin test = server.getPluginManager().getPlugin("Permissions");
		if (test != null) {
			Logger log = Logger.getLogger("Minecraft");
			permissionsPlugin = (Permissions) test;
			permissionsEnabled = true;
			log.log(Level.INFO, "[ArrowWall]: Permissions enabled.");
		} else {
			Logger log = Logger.getLogger("Minecraft");
			log.log(Level.SEVERE,
					"[ArrowWall]: Permissions isn't loaded, commands can only be used by ops.");
		}
	}

	public static boolean isAdmin(Player player) {
		if (permissionsEnabled) {
			return permission(player, "");
		}
		return player.isOp();
	}

	private static boolean permission(Player player, String string) {
		return Permissions.Security.permission(player, string);
	}

	public static boolean check(Player player) {
		if (permissionsEnabled) {
			return permission(player, "");
		}
		return player.isOp();
	}

	public static boolean generic(Player player, String string) {
		if (permissionsEnabled) {
			return permission(player, string);
		}
		return player.isOp();
	}

}
