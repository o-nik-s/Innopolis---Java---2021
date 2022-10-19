package ru.pcs.emulator;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 11.10.2021
 * ClientsEmulator
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Clients {

    private static final int TOO_MANY_TASKS_COUNT = 3;

    private static final Logger logger = Logger.getLogger(Clients.class);

    private final ExecutorService executorService;

    private List<Runnable> tasks;

    public Clients() {
        this.executorService = Executors.newCachedThreadPool();
        this.tasks = new ArrayList<>();
        logger.info("Initialized thread pool...");
    }

    public void newClient(Runnable task) {
        this.tasks.add(task);
        logger.debug("Added task");

        if (tasks.size() > TOO_MANY_TASKS_COUNT) {
            logger.warn("Too many tasks");
        }
    }

    public void run() {
        for (Runnable task : tasks) {
            executorService.submit(task);
        }
        logger.info("Run clients");
    }

    public void stop() {
        executorService.shutdown();
        logger.info("Shutdown thread pool");
    }


}
