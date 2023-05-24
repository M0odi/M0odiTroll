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
import M0odiTroll.M0odiTroll.Managers.TimerManager;
import M0odiTroll.M0odiTroll.Storages.MessageStorage;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class SoundTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.SOUND",
            usageLength = 1, usageMessage = MessageStorage.SOUND_TROLL_USAGE)
    public SoundTroll() {
        super("soundTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        target.playSound(target.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 1f, 1f);

        ((TimerManager) () ->
                target.playSound(target.getLocation(), Sound.ENTITY_ENDER_DRAGON_HURT, 1f, 1f))
        .startDelayedTimer(200);

        ((TimerManager) () ->
                target.playSound(target.getLocation(), Sound.BLOCK_BASALT_BREAK, 1f, 1f))
        .startDelayedTimer(400);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.SOUND_TROLL);

        MessageStorage.SOUND_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

    }

    @Override @InjectEnableCommandCheck(command = "SOUND_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "SOUND_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.SOUND_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
