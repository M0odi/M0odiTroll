package M0odiTroll.M0odiTroll.Managers;

import M0odiTroll.M0odiTroll.M0odiTroll;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public final class ConfigManager {

    @Getter
    private final FileConfiguration config;

    /**
     * Создает файл с указанным названием в папке плагина.
     * Используется для хранения каких-либо ресурсов,
     * инициализация которых требуется на моменте загрузки плагина.
     *
     * @param name Название файла.
     *             Необходимо указание расширения.
     *             Пример: messages.yml
     */
    public ConfigManager(String name) {

        final File file = new File(M0odiTroll.getInstance().getDataFolder(), name);

        M0odiTroll.getInstance().getDataFolder().mkdir();

        // Если файла не существует, сохраняем как ресурс...
        if (!file.exists()) M0odiTroll.getInstance().saveResource(name, false);

        config = YamlConfiguration.loadConfiguration(file);

    }

}
