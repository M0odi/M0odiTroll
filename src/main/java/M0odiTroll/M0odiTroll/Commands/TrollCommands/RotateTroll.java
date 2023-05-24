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
import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class RotateTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.ROTATE",
            usageLength = 1, usageMessage = MessageStorage.ROTATE_TROLL_USAGE)
    public RotateTroll() {
        super("rotateTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        ((TimerManager) () -> {

            final Location targetLocation = target.getLocation();
            targetLocation.setYaw(targetLocation.getYaw() + 5F);

            target.teleport(targetLocation);

        }).startTimer(M0odiTroll.getInstance().getConfig().getInt("ROTATE_TROLL.AMOUNT"), 1);

        MessageStorage.ROTATE_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.ROTATE_SUCCESSFULLY_TARGET.sendMessage(target);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.ROTATE_TROLL);

    }

    @Override @InjectEnableCommandCheck(command = "ROTATE_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "ROTATE_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.ROTATE_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
