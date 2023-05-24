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
import org.bukkit.util.Vector;

public final class SlapTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.SLAP",
            usageLength = 1, usageMessage = MessageStorage.SLAP_TROLL_USAGE)
    public SlapTroll() {
        super("slapTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        final double yStrength =
                M0odiTroll.getInstance().getConfig().getDouble("SLAP_TROLL.Y_STRENGTH");

        final double strength =
                M0odiTroll.getInstance().getConfig().getDouble("SLAP_TROLL.STRENGTH");

        Vector vector = target.getLocation().getDirection().multiply(strength).setY(yStrength);
        target.setVelocity(vector);

        MessageStorage.SLAP_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.SLAP_SUCCESSFULLY_TARGET.sendMessage(target);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.SLAP_TROLL);

    }

    @Override @InjectEnableCommandCheck(command = "SLAP_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "SLAP_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.SLAP_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
