package Lesson12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CounterApp {

    private static class Counter {
        private int value;

        public Counter() {
            this.value = 0;
        }

        public Counter(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public synchronized void increment() {
            this.value++;
        }
    }

    private static class DoubleCounter {
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        private int first;
        private int second;

        public DoubleCounter() {
            this.first = 0;
            this.second = 0;
        }

        @Override
        public String toString() {
            return "DoubleCounter{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }

        public void incrementFirst() {
            synchronized (lock1) {
                this.first++;
            }
        }

        public void incrementSecond() {
            synchronized (lock2) {
                this.second++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); //effectively final
        DoubleCounter doubleCounter = new DoubleCounter();

        AtomicInteger atomicInteger = new AtomicInteger(0);
//        AtomicReference<String>

        //counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 10_000; i++) {
                atomicInteger.incrementAndGet();
                counter.increment();
                doubleCounter.incrementFirst();
                if (i % 2 == 0) {
                    doubleCounter.incrementSecond();
                }
                synchronized (doubleCounter) {
                    doubleCounter.incrementFirst();
                    doubleCounter.incrementSecond();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getValue());
        System.out.println(atomicInteger.get());
        System.out.println(doubleCounter.toString());
    }
}
