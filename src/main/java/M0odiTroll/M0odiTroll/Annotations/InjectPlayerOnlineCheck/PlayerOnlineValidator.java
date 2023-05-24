package M0odiTroll.M0odiTroll.Annotations.InjectPlayerOnlineCheck;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

public final class PlayerOnlineValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        final InjectPlayerOnlineCheck injectPlayerOnlineCheck = (InjectPlayerOnlineCheck) annotation;

        if (Bukkit.getPlayer(args[injectPlayerOnlineCheck.argPosition()]) == null) {
            MessageStorage.PLAYER_NOT_ONLINE.sendMessage(sender);
            return false;
        }

        return true;

    }

}
