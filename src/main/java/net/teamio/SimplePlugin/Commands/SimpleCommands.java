package net.teamio.SimplePlugin.Commands;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.CommandPermissions;
import org.spout.api.exception.CommandException;

import net.teamio.SimplePlugin.SimpleSpoutPlugin;

public class SimpleCommands {

	@SuppressWarnings("unused")
	private final SimpleSpoutPlugin plugin;

	public SimpleCommands(SimpleSpoutPlugin p) {
		plugin = p;
	}

	// aliases - commands to register
	// usage - oh come on, that's given.
	// desc - again, given
	// max - maximum arguments. in this case, this command takes 0 arguments
	// commandpermissions - does this person have perms to execute this cmd?
	
	@Command(aliases = {"hello", "greeting", "helloworld"}, usage = "No arguments necessary.",
			desc = "Feel good message", max = 0)
	@CommandPermissions("simple.helloworld")
	public void gamemode(CommandContext args, CommandSource source) throws CommandException {
		source.sendMessage("Hello World! And you too, " + source.getName()+"!");
	}

}
