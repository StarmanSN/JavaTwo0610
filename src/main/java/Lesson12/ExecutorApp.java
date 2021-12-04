package Lesson12;

import java.util.concurrent.*;

public class ExecutorApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));

        Future<?> future = executorService.submit(() -> System.out.println("something"));

        Future<String> stringFuture = executorService.submit(new MyCallable());

        System.out.println(stringFuture.get());

        executorService.shutdown();
    }

    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "string from callable";
        }
    }
}
