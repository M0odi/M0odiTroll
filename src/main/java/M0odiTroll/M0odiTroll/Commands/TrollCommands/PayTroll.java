package M0odiTroll.M0odiTroll.Commands.TrollCommands;

import M0odiTroll.M0odiTroll.Annotations.InjectCooldownCheck.InjectCooldownCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectEnableCommandCheck.InjectEnableCommandCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPVPCheck.InjectPVPCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPlayerOnlineCheck.InjectPlayerOnlineCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectProtectCheck.InjectProtectCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectRequirements.InjectRequirements;
import M0odiTroll.M0odiTroll.Annotations.InjectYourSelfCheck.InjectYourSelfCheck;
import M0odiTroll.M0odiTroll.Commands.AbstractCommand;
import M0odiTroll.M0odiTroll.Managers.CooldownManager;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class PayTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.PAY",
            usageLength = 1, usageMessage = MessageStorage.PAY_TROLL_USAGE)
    public PayTroll() {
        super("payTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        MessageStorage.PAY_SUCCESSFULLY_SENDER.sendMessage(getSender());

        MessageStorage.PAY_SUCCESSFULLY_TARGET.getMessage().forEach(message ->
                target.sendMessage(message
                        .replaceAll("%money%", String.valueOf((int) (Math.random() * 10000)))));

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.PAY_TROLL);

    }

    @Override @InjectEnableCommandCheck(command = "PAY_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "PAY_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.PAY_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
