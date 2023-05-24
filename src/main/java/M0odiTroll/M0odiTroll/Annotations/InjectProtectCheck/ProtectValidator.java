package M0odiTroll.M0odiTroll.Annotations.InjectProtectCheck;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

public final class ProtectValidator implements Validator {

    @Override @SuppressWarnings("ConstantConditions")
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        final InjectProtectCheck injectProtectCheck = (InjectProtectCheck) annotation;

        if (Bukkit.getPlayer(args[injectProtectCheck.argPosition()]).hasPermission("M0odiTroll.PROTECT")) {
            MessageStorage.IS_PROTECTED_PLAYER.sendMessage(sender);
            return false;
        }

        return true;

    }

}
