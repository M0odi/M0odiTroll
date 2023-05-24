package M0odiTroll.M0odiTroll.Managers;

import M0odiTroll.M0odiTroll.M0odiTroll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CooldownManager {

    public static void setCooldown(CommandSender sender, CooldownCommands command) {

        command.getSenders().put(sender, System.currentTimeMillis());

        ((TimerManager) () ->
                command.getSenders().remove(sender))
        .startDelayedTimer(command.getCooldown() * 20);

    }

    @AllArgsConstructor
    public enum CooldownCommands {

        DROP_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("DROP_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.DROP_TROLL"),
        DRUNK_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("DRUNK_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.DRUNK_TROLL"),
        HEALL_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("HEALL_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.HEALL_TROLL"),
        LIFT_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("LIFT_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.LIFT_TROLL"),
        OP_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("OP_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.OP_TROLL"),
        PAY_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("PAY_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.PAY_TROLL"),
        ROTATE_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("ROTATE_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.ROTATE_TROLL"),
        SLAP_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("SLAP_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.SLAP_TROLL"),
        SPAM_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("SPAM_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.SPAM_TROLL"),
        STARVE_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("STARVE_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.STARVE_TROLL"),
        SOUND_TROLL (new HashMap<>(), M0odiTroll.getInstance().getConfig().getInt("SOUND_TROLL.COOLDOWN"), "M0odiTroll.COOLDOWN_BYPASS.SOUND_TROLL");

        @Getter
        private final HashMap<CommandSender, Long> senders;

        @Getter
        private final int cooldown;

        @Getter
        private final String permForBypassCooldown;

        public boolean checkBypassCooldown(CommandSender sender) {
            return sender.hasPermission(getPermForBypassCooldown()) || sender.hasPermission("M0odiTroll.COOLDOWN_BYPASS.ALL");
        }

    }

}
