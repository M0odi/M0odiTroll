package M0odiTroll.M0odiTroll.Storages;

import M0odiTroll.M0odiTroll.M0odiTroll;
import M0odiTroll.M0odiTroll.Utils.ChatUtils;
import lombok.AllArgsConstructor;
import org.bukkit.command.CommandSender;

import java.util.List;

@AllArgsConstructor
public enum MessageStorage {

    NOT_PERMS (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.NOT_PERMS")),
    COMMAND_FOR_PLAYERS_ONLY (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.COMMAND_FOR_PLAYERS_ONLY")),
    PLAYER_NOT_ONLINE (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.PLAYER_NOT_ONLINE")),
    COMMAND_NOT_ACTIVATED (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.COMMAND_NOT_ACTIVATED")),
    IS_PROTECTED_PLAYER (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.IS_PROTECTED_PLAYER")),
    PLEASE_WAIT (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.PLEASE_WAIT")),
    IS_PVP_PLAYER (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.IS_PVP_PLAYER")),
    YOUR_SELF_ACTION (M0odiTroll.getMessages().getConfig().getStringList("GENERALIZED_ERRORS.YOUR_SELF_ACTION")),

    DRUNK_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.DRUNK_TROLL_USAGE")),
    HEALL_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.HEALL_TROLL_USAGE")),
    ROTATE_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.ROTATE_TROLL_USAGE")),
    LIFT_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.LIFT_TROLL_USAGE")),
    SLAP_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.SLAP_TROLL_USAGE")),
    SPAM_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.SPAM_TROLL_USAGE")),
    DROP_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.DROP_TROLL_USAGE")),
    STARVE_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.STARVE_TROLL_USAGE")),
    PAY_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.PAY_TROLL_USAGE")),
    OP_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.OP_TROLL_USAGE")),
    SOUND_TROLL_USAGE (M0odiTroll.getMessages().getConfig().getStringList("USAGES.SOUND_TROLL_USAGE")),

    DRUNK_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.DRUNK_TROLL.DRUNK_SUCCESSFULLY_SENDER")),
    DRUNK_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.DRUNK_TROLL.DRUNK_SUCCESSFULLY_TARGET")),

    HEALL_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.HEALL_TROLL.HEALL_SUCCESSFULLY_SENDER")),
    HEALL_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.HEALL_TROLL.HEALL_SUCCESSFULLY_TARGET")),

    ROTATE_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.ROTATE_TROLL.ROTATE_SUCCESSFULLY_SENDER")),
    ROTATE_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.ROTATE_TROLL.ROTATE_SUCCESSFULLY_TARGET")),

    LIFT_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.LIFT_TROLL.LIFT_SUCCESSFULLY_SENDER")),
    LIFT_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.LIFT_TROLL.LIFT_SUCCESSFULLY_TARGET")),

    SLAP_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.SLAP_TROLL.SLAP_SUCCESSFULLY_SENDER")),
    SLAP_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.SLAP_TROLL.SLAP_SUCCESSFULLY_TARGET")),

    SPAM_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.SPAM_TROLL.SPAM_SUCCESSFULLY_SENDER")),
    SPAM_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.SPAM_TROLL.SPAM_SUCCESSFULLY_TARGET")),

    DROP_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.DROP_TROLL.DROP_SUCCESSFULLY_SENDER")),
    DROP_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.DROP_TROLL.DROP_SUCCESSFULLY_TARGET")),

    STARVE_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.STARVE_TROLL.STARVE_SUCCESSFULLY_SENDER")),
    STARVE_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.STARVE_TROLL.STARVE_SUCCESSFULLY_TARGET")),

    PAY_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.PAY_TROLL.PAY_SUCCESSFULLY_SENDER")),
    PAY_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.PAY_TROLL.PAY_SUCCESSFULLY_TARGET")),

    OP_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.OP_TROLL.OP_SUCCESSFULLY_SENDER")),
    OP_SUCCESSFULLY_TARGET (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.OP_TROLL.OP_SUCCESSFULLY_TARGET")),

    SOUND_SUCCESSFULLY_SENDER (M0odiTroll.getMessages().getConfig().getStringList("MESSAGES.SOUND_TROLL.SOUND_SUCCESSFULLY_SENDER"));

    private final List<String> message;

    public List<String> getMessage() {
        return ChatUtils.format(message);
    }

    public void sendMessage(CommandSender sender) {
        getMessage().forEach(sender::sendMessage);
    }

}
