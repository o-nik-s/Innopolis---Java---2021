package task.executors;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TaskExecutorThreadPerTask implements TaskExecutor {
    @Override
    public void submit(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
    }
}
