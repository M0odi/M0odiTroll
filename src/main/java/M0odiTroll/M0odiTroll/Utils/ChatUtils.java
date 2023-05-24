package M0odiTroll.M0odiTroll.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ChatUtils {

    private static final Pattern PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String format(String message) {

        if (Bukkit.getVersion().contains("1.16")) {

            Matcher matcher = PATTERN.matcher(message);

            while (matcher.find()) {
                String color = message.substring(matcher.start(), matcher.end());
                message = message.replace(color, ChatColor.of(color) + "");
                matcher = PATTERN.matcher(message);
            }

        }

        return message.replaceAll("&", "§");

    }

    public static List<String> format(List<String> message) {

        final List<String> formattedMessage = new ArrayList<>();

        message.forEach(partMessage -> formattedMessage.add(format(partMessage)));

        return formattedMessage;

    }

}
