package M0odiTroll.M0odiTroll.Annotations.InjectRequirements;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.lang.annotation.Annotation;

public final class RequirementsValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        final InjectRequirements injectRequirements = (InjectRequirements) annotation;

        if (sender instanceof ConsoleCommandSender && injectRequirements.forPlayersOnly()) {
            MessageStorage.COMMAND_FOR_PLAYERS_ONLY.sendMessage(sender);
            return false;
        }

        if (!sender.hasPermission(injectRequirements.permission())) {
            MessageStorage.NOT_PERMS.sendMessage(sender);
            return false;
        }

        if (args.length < injectRequirements.usageLength()) {
            injectRequirements.usageMessage().sendMessage(sender);
            return false;
        }

        return true;

    }

}
