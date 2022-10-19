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
public class TaskExecutorWorkerThread implements TaskExecutor {

    // очередь задач
    private final Deque<Runnable> tasks;
    // побочный поток, который все время будет выполнять какую-то работу
    // будет брать очередную задачу из очереди и выполнять ее внутри себя
    private final WorkerThread workerThread;

    public TaskExecutorWorkerThread() {
        this.tasks = new LinkedList<>();
        this.workerThread = new WorkerThread();
        this.workerThread.start();
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
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
                    Runnable task = tasks.poll();
                    task.run();
                }

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
