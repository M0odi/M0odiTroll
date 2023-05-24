package M0odiTroll.M0odiTroll.Annotations.InjectCooldownCheck;

import M0odiTroll.M0odiTroll.Annotations.Validator;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;
import java.util.Map;

public class CooldownValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, CommandSender sender, String[] args) {

        InjectCooldownCheck injectCooldownCheck = (InjectCooldownCheck) annotation;

        if (injectCooldownCheck.command().checkBypassCooldown(sender)) return true;

        for (Map.Entry<CommandSender, Long> entry : injectCooldownCheck.command().getSenders().entrySet()) {

            if (entry.getKey().getName().equalsIgnoreCase(sender.getName())) {

                final long passedTime = System.currentTimeMillis() - entry.getValue();
                final long cooldownTime =  injectCooldownCheck.command().getCooldown() * 1000L;

                MessageStorage.PLEASE_WAIT.getMessage().forEach(message ->
                        sender.sendMessage(message
                                .replaceAll("%sec%", String.valueOf((cooldownTime - passedTime) / 1000))));

                return false;

            }

        }

        return true;

    }

}
