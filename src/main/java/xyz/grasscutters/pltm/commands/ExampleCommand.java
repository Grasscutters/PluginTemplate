package xyz.grasscutters.pltm.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import xyz.grasscutters.pltm.PluginTemplate;

import java.util.List;

/**
 * Commands are comprised of 3 things:
 * 1. The {@link Command} annotation.
 * 2. Implementing the {@link CommandHandler} interface.
 * 3. Implementing the {@link CommandHandler#execute(Player, Player, List)} method.
 * 
 * The {@link Command} annotation should contain:
 * 1. A command label. ('example' in this case makes '/example' runnable in-game or on the console)
 * 2. A description of the command. (this is shown in the `/help` command description)
 * 3. A permission node. (this is used to check if the player has permission to use the command)
 * Other optional fields can be found in the {@link Command} annotation interface.
 */

@Command(label = "example", description = "An example of a plugin command.", 
        usage = "example <toLog>", permission = "pltm.example")
public final class ExampleCommand implements CommandHandler {
    /**
     * Called when `/example` is run either in-game or on the server console.
     * @param sender The player/console that invoked the command.
     * @param targetPlayer The player that the sender was targeting.
     * @param args The arguments to the command.
     *             
     * If {@param sender} is null, the command was run on the server console.
     * {@param targetPlayer} can be null if the sender did not specify a target.
     * For sending feedback to the sender, use {@link CommandHandler#sendMessage(Player, String)}
     */
    @Override public void execute(Player sender, Player targetPlayer, List<String> args) {
        var joined = String.join(" ", args);
        PluginTemplate.getInstance().getLogger().info(joined);
        
        if(sender != null)
            CommandHandler.sendMessage(sender, "Logged the message to the console.");
    }
}
