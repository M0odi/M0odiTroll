package M0odiTroll.M0odiTroll.Managers;

import M0odiTroll.M0odiTroll.M0odiTroll;
import org.bukkit.scheduler.BukkitRunnable;

public interface TimerManager {

    default void startTimer(int iterations, int period) {

        new BukkitRunnable() {

            int indexIteration = 0;

            @Override
            public void run() {

                if (indexIteration >= iterations) { this.cancel(); return; }

                executeTimer();

                indexIteration++;

            }

        }.runTaskTimer(M0odiTroll.getInstance(), 0, period);


    }

    default void startDelayedTimer(int delay) {

        new BukkitRunnable() {

            @Override
            public void run() {
                executeTimer();
            }

        }.runTaskLater(M0odiTroll.getInstance(), delay);

    }

    void executeTimer();

}
