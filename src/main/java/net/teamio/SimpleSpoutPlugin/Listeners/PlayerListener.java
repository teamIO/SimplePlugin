package net.teamio.SimpleSpoutPlugin.Listeners;

import net.teamio.SimpleSpoutPlugin.SimpleSpoutPlugin;

import org.spout.api.Game;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

	private final SimpleSpoutPlugin plugin;
	private final Game game;
	
	public PlayerListener(SimpleSpoutPlugin p){
		plugin = p;
		game = p.getGame();
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		e.getPlayer().sendMessage("Hello there, +"
				+ e.getPlayer().getName() + "!");
		game.broadcastMessage("Say hello to "+e.getPlayer().getName()+"!");
		plugin.getLogger().info(e.getPlayer().getName()+" fired a join event.");
	}
	
}
