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

public final class StarveTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.STARVE",
            usageLength = 1, usageMessage = MessageStorage.STARVE_TROLL_USAGE)
    public StarveTroll() {
        super("starveTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        final int newLevel =
                M0odiTroll.getInstance().getConfig().getInt("STARVE_TROLL.NEW_LEVEL");

        target.setFoodLevel(newLevel);

        MessageStorage.STARVE_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.STARVE_SUCCESSFULLY_TARGET.sendMessage(target);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.STARVE_TROLL);

    }

    @Override @InjectEnableCommandCheck(command = "STARVE_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "STARVE_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.STARVE_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
