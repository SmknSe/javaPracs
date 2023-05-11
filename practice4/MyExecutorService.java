package practice4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class MyExecutorService implements ExecutorService {
    private final int numThreads;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> tasks;

    public MyExecutorService(int numThreads) {
        this.numThreads = numThreads;
        this.threads = new ArrayList<>(numThreads);
        this.tasks = new LinkedBlockingQueue<>();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = tasks.take();
                        task.run();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    @Override
    public void execute(Runnable command) {
        tasks.add(command);
    }

    @Override
    public void shutdown() {
        threads.forEach(Thread::interrupt);
    }

    @Override
    public List<Runnable> shutdownNow() {
        threads.forEach(Thread::stop);
        return tasks.stream().collect(Collectors.toList());
    }

    @Override
    public boolean isShutdown() {
        return threads.stream().allMatch(Thread::isInterrupted);
    }

    @Override
    public boolean isTerminated() {
        return tasks.isEmpty() && threads.stream().allMatch(Thread::isInterrupted);
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        while (!isTerminated()) {
            if (System.currentTimeMillis() - startTime > unit.toMillis(timeout)) {
                return false;
            }
            Thread.sleep(100);
        }
        return true;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        List<Future<T>> futures = new ArrayList<>();
        for (Callable<T> task : tasks) {
            FutureTask<T> futureTask = new FutureTask<>(task);
            futures.add(futureTask);
            execute(futureTask);
        }

        long startTime = System.currentTimeMillis();
        while (!futures.stream().allMatch(Future::isDone)) {
            if (System.currentTimeMillis() - startTime > unit.toMillis(timeout)) {
                break;
            }
            Thread.sleep(100);
        }

        return futures;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        List<Future<T>> futures = new ArrayList<>();
        for (Callable<T> task : tasks) {
            FutureTask<T> futureTask = new FutureTask<>(task);
            futures.add(futureTask);
            execute(futureTask);
        }

        while (!futures.stream().anyMatch(Future::isDone)) {
            Thread.sleep(100);
        }

        for (Future<T> future : futures) {
            if (future.isDone()) {
                return future.get();
            }
        }
        throw new ExecutionException(new Throwable("No task completed"));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        FutureTask<T> futureTask = new FutureTask<>(task);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        FutureTask<T> futureTask = new FutureTask<>(task, result);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public Future<?> submit(Runnable task) {
        FutureTask<?> futureTask = new FutureTask<>(task, null);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        List<Future<T>> futures = new ArrayList<>();
        for (Callable<T> task : tasks) {
            FutureTask<T> futureTask = new FutureTask<>(task);
            futures.add(futureTask);
            execute(futureTask);
        }

        while (!futures.stream().allMatch(Future::isDone)) {
            Thread.sleep(100);
        }
        return futures;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        List<Future<T>> futures = new ArrayList<>();
        for (Callable<T> task : tasks) {
            FutureTask<T> futureTask = new FutureTask<>(task);
            futures.add(futureTask);
            execute(futureTask);
        }

        long startTime = System.currentTimeMillis();
        while (!futures.stream().anyMatch(Future::isDone)) {
            if (System.currentTimeMillis() - startTime > unit.toMillis(timeout)) {
                throw new TimeoutException();
            }
            Thread.sleep(100);
        }

        for (Future<T> future : futures) {
            if (future.isDone()) {
                return future.get();
            }
        }

        throw new ExecutionException(new Throwable("No task completed"));
    }
}
