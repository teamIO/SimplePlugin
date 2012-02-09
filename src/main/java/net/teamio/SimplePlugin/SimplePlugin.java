package net.teamio.SimplePlugin;

import net.teamio.SimplePlugin.Commands.SimpleCommands;
import net.teamio.SimplePlugin.Listeners.PlayerListener;

import org.spout.api.Game;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.plugin.CommonPlugin;

public class SimplePlugin extends CommonPlugin {

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// the server
		Game game = this.getGame();
		game.getLogger().info(this.getDescription().getFullName() + " is now loading.");
		
		// let's say hello to every person who enters the server.
		game.getEventManager().registerEvents(new PlayerListener(this), this);
		
		// also provide a /greeting command to people who want to feel good.
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(new SimpleInjector(this), new SimpleAnnotatedCommandExecutorFactory());

		game.getRootCommand().addSubCommands(game, SimpleCommands.class, commandRegFactory);
		
	}

}
