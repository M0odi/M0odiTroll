package M0odiTroll.M0odiTroll.Annotations.InjectYourSelfCheck;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

public final class YourSelfValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        final InjectYourSelfCheck injectYourSelfCheck = (InjectYourSelfCheck) annotation;

        if (sender.getName().equalsIgnoreCase(args[injectYourSelfCheck.argPosition()])) {
            MessageStorage.YOUR_SELF_ACTION.sendMessage(sender);
            return false;
        }

        return true;

    }

}
