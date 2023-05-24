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
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class DropTroll extends AbstractCommand {

    @InjectRequirements(permission = "M0odiTroll.DROP",
            usageLength = 1, usageMessage = MessageStorage.DROP_TROLL_USAGE)
    public DropTroll() {
        super("dropTroll");
    }

    @Override @SuppressWarnings("ConstantConditions")
    protected void executeCommand() {

        final Player target = Bukkit.getPlayer(getArgs()[0]);

        ItemStack itemInMainHand = target.getInventory().getItemInMainHand();
        if (!itemInMainHand.getType().equals(Material.AIR)) {
            target.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            target.getLocation().getWorld().dropItemNaturally(target.getLocation(), itemInMainHand);
        }

        MessageStorage.DROP_SUCCESSFULLY_SENDER.getMessage().forEach(message ->
                getSender().sendMessage(message
                        .replaceAll("%target%", getArgs()[0])));

        MessageStorage.DROP_SUCCESSFULLY_TARGET.sendMessage(target);

        CooldownManager.setCooldown(getSender(), CooldownManager.CooldownCommands.DROP_TROLL);

    }

    @SuppressWarnings("ConstantConditions")
    @Override @InjectEnableCommandCheck(command = "DROP_TROLL")
    @InjectYourSelfCheck @InjectPlayerOnlineCheck
    @InjectProtectCheck @InjectPVPCheck(command = "DROP_TROLL")
    @InjectCooldownCheck(command = CooldownManager.CooldownCommands.DROP_TROLL)
    protected boolean feasibilityCheck() {
        return true;
    }

}
