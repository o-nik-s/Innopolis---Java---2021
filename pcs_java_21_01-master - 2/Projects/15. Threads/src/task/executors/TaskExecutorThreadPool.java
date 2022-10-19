package task.executors;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TaskExecutorThreadPool implements TaskExecutor {

    // очередь задач
    private final Deque<Runnable> tasks;
    // массив потоков, которые выполняются параллельно и берут на себя задачи
    private final WorkerThread[] threads;

    public TaskExecutorThreadPool(int count) {
        this.tasks = new LinkedList<>();
        this.threads = new WorkerThread[count];
        for (int i = 0; i < threads.length; i++) {
            this.threads[i] = new WorkerThread();
        }
        for (WorkerThread thread : threads) {
            thread.start();
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable currentTask;
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            // пока задач для нас нет - уходим в ожидание
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalArgumentException();
                        }
                    }
                    // забираем задачу из очереди
                    currentTask = tasks.poll();
                }
                currentTask.run();

            }
        }
    }

    @Override
    public void submit(Runnable task) {
        // как положить задачу в очередь? если мы туда что-то кладем, значит из нее забирать
        synchronized (tasks) {
            // добавили задачу в очередь
            tasks.add(task);
            // как только положили задачу в очередь - оповестили ожидающий поток
            tasks.notify();
        }
    }
}
