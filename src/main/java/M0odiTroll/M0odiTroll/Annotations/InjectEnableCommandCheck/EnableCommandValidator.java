package M0odiTroll.M0odiTroll.Annotations.InjectEnableCommandCheck;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.M0odiTroll;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

public final class EnableCommandValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        final InjectEnableCommandCheck injectEnableCommandCheck = (InjectEnableCommandCheck) annotation;

        if (!M0odiTroll.getInstance().getConfig().getBoolean(injectEnableCommandCheck.command() + ".ENABLE")) {
            MessageStorage.COMMAND_NOT_ACTIVATED.sendMessage(sender);
            return false;
        }

        return true;

    }

}
