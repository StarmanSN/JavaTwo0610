package Homework1;

public interface Runnable {
    default void run() {
        System.out.println("Бежит");
    }

}
