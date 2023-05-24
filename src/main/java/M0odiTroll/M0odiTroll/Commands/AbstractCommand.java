package M0odiTroll.M0odiTroll.Commands;

import M0odiTroll.M0odiTroll.Annotations.Annotations;
import M0odiTroll.M0odiTroll.M0odiTroll;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public abstract class AbstractCommand implements CommandExecutor {

    @Getter
    private CommandSender sender;

    @Getter
    private String[] args;

    protected AbstractCommand(String commandName) {

        PluginCommand command = M0odiTroll.getInstance().getCommand(commandName);

        if (command == null) return;

        command.setExecutor(this);

    }

    @Override @SneakyThrows
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        for (Annotation declaredAnnotation : getClass().getConstructor().getDeclaredAnnotations()) {

            if (!Annotations.validateAnnotation(declaredAnnotation, sender, args)) return true;

        }

        for (Method method : getClass().getDeclaredMethods()) {

            for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {

                if (!Annotations.validateAnnotation(declaredAnnotation, sender, args)) return true;

            }

        }

        this.sender = sender;
        this.args = args;

        if (feasibilityCheck()) executeCommand(); return true;

    }

    protected abstract void executeCommand();

    protected abstract boolean feasibilityCheck();

}
