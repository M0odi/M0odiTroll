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
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class BurnTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.BURN",
            usageLength = 1, usageMessage = MessageStorage.BURN_TROLL_USAGE)
    public BurnTroll() {
        super("burnTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        final int fireTicks =
                M0odiTroll.getInstance().getConfig().getInt("BURN_TROLL.FIRE_TICKS");

        target.setFireTicks(fireTicks);

        MessageStorage.BURN_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.BURN_SUCCESSFULLY_TARGET.sendMessage(target);

    }

    @Override @InjectEnableCommandCheck(command = "BURN_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "BURN_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.BURN_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
