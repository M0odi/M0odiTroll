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
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public final class DrunkTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.DRUNK",
            usageLength = 1, usageMessage = MessageStorage.DRUNK_TROLL_USAGE)
    public DrunkTroll() {
        super("drunkTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        final ConfigurationSection settings =
                M0odiTroll.getInstance().getConfig().getConfigurationSection("DRUNK_TROLL.POTIONS");

        settings.getKeys(false).forEach(namePotion ->
                target.addPotionEffect(
                        PotionEffectType.getByName(namePotion)
                                .createEffect(
                                        settings.getInt(namePotion + ".DURATION"),
                                        settings.getInt(namePotion + ".LVL"))));

        MessageStorage.DRUNK_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.DRUNK_SUCCESSFULLY_TARGET.sendMessage(target);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.DRUNK_TROLL);

    }

    @Override @InjectEnableCommandCheck(command = "DRUNK_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "DRUNK_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.DRUNK_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
