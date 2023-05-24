package M0odiTroll.M0odiTroll.Commands.TrollCommands;

import M0odiTroll.M0odiTroll.Annotations.InjectCooldownCheck.InjectCooldownCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectEnableCommandCheck.InjectEnableCommandCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPVPCheck.InjectPVPCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPlayerOnlineCheck.InjectPlayerOnlineCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectProtectCheck.InjectProtectCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectRequirements.InjectRequirements;
import M0odiTroll.M0odiTroll.Annotations.InjectYourSelfCheck.InjectYourSelfCheck;
import M0odiTroll.M0odiTroll.Commands.AbstractCommand;
import M0odiTroll.M0odiTroll.M0odiTroll;
import M0odiTroll.M0odiTroll.Managers.CooldownManager;
import M0odiTroll.M0odiTroll.Managers.TimerManager;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public final class SpamTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.SPAM",
            usageLength = 1, usageMessage = MessageStorage.SPAM_TROLL_USAGE)
    public SpamTroll() {
        super("spamTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        MessageStorage.SPAM_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.SPAM_TROLL);

        final int amount =
                M0odiTroll.getInstance().getConfig().getInt("SPAM_TROLL.AMOUNT");

        final int period =
                M0odiTroll.getInstance().getConfig().getInt("SPAM_TROLL.PERIOD");

        ((TimerManager) () -> {

            final List<String> spamMessages = M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.SPAM_TROLL.SPAM");
            final String randomMessage = spamMessages.get((int) (Math.random() * (spamMessages.size() - 1)));

            MessageStorage.SPAM_SUCCESSFULLY_TARGET.getMessage().forEach(message ->
                    target.sendMessage(message
                            .replaceAll("%message%", randomMessage)));

        }).startTimer(amount, period);

    }

    @Override @InjectEnableCommandCheck(command = "SPAM_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "SPAM_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.SPAM_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
