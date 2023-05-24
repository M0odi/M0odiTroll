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

public final class OPTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.OP",
            usageLength = 1, usageMessage = MessageStorage.OP_TROLL_USAGE)
    public OPTroll() {
        super("opTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        MessageStorage.OP_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.OP_SUCCESSFULLY_TARGET.sendMessage(target);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.OP_TROLL);

    }

    @Override @InjectEnableCommandCheck(command = "OP_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "OP_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.OP_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
