package M0odiTroll.M0odiTroll.Annotations.InjectPVPCheck;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.Events.DamageEvent;
import M0odiTroll.M0odiTroll.M0odiTroll;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.annotation.Annotation;

public final class PVPValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        final InjectPVPCheck injectPVPCheck = (InjectPVPCheck) annotation;

        if (M0odiTroll.getInstance().getConfig().getBoolean(injectPVPCheck.command() + ".FEASIBILITY_IN_PVP")) return true;

        for (Player player : DamageEvent.players) {
            if (player.getName().equalsIgnoreCase(args[injectPVPCheck.argPosition()])) {
                MessageStorage.IS_PVP_PLAYER.sendMessage(sender);
                return false;
            }
        }

        return true;

    }

}
