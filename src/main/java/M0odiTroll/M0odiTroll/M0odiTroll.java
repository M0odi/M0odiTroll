package M0odiTroll.M0odiTroll;

import M0odiTroll.M0odiTroll.Commands.TrollCommands.*;
import M0odiTroll.M0odiTroll.Events.DamageEvent;
import M0odiTroll.M0odiTroll.Managers.ConfigManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class M0odiTroll extends JavaPlugin {

    @Getter
    private static M0odiTroll instance;

    @Getter
    private static ConfigManager messages;

    @Override
    public void onEnable() {

        instance = this;

        Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);

        saveDefaultConfig();
        messages = new ConfigManager("messages.yml");

        loadCommands();

    }

    private void loadCommands() {

        new DrunkTroll();
        new HeallTroll();
        new LiftTroll();
        new RotateTroll();
        new SlapTroll();
        new SpamTroll();
        new DropTroll();
        new StarveTroll();
        new PayTroll();
        new OPTroll();
        new SoundTroll();

        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("§b███╗░░░███╗░█████╗░░█████╗░██████╗░██╗§c████████╗██████╗░░█████╗░██╗░░░░░██╗░░░░░");
        Bukkit.getLogger().info("§b████╗░████║██╔══██╗██╔══██╗██╔══██╗██║§c╚══██╔══╝██╔══██╗██╔══██╗██║░░░░░██║░░░░░");
        Bukkit.getLogger().info("§b██╔████╔██║██║░░██║██║░░██║██║░░██║██║§c░░░██║░░░██████╔╝██║░░██║██║░░░░░██║░░░░░");
        Bukkit.getLogger().info("§b██║╚██╔╝██║██║░░██║██║░░██║██║░░██║██║§c░░░██║░░░██╔══██╗██║░░██║██║░░░░░██║░░░░░");
        Bukkit.getLogger().info("§b██║╚██╔╝██║██║░░██║██║░░██║██║░░██║██║§c░░░██║░░░██╔══██╗██║░░██║██║░░░░░██║░░░░░");
        Bukkit.getLogger().info("§b██║░╚═╝░██║╚█████╔╝╚█████╔╝██████╔╝██║§c░░░██║░░░██║░░██║╚█████╔╝███████╗███████╗");
        Bukkit.getLogger().info("§b╚═╝░░░░░╚═╝░╚════╝░░╚════╝░╚═════╝░╚═╝§c░░░╚═╝░░░╚═╝░░╚═╝░╚════╝░╚══════╝╚══════╝");
        Bukkit.getLogger().info("");
        Bukkit.getLogger().info(" §b| §7Плагин разработан §cДенисом Тимофеевым §7a.k.a §cM0odi");
        Bukkit.getLogger().info(" §b| §7ВКонтакте: §chttps://vk.com/m0odi");
        Bukkit.getLogger().info(" §b| §7Telegram: §chttps://t.me/M0odiX");
        Bukkit.getLogger().info(" §b| ");
        Bukkit.getLogger().info(" §b| §7Нативная версия: §cPAPER 1.16.5");
        Bukkit.getLogger().info("");

    }

    @Override
    public void onDisable() {}

}
