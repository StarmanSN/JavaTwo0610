package Homework1;

public interface Jumpable {
    default void jump() {
        System.out.println("Прыгает");
    }
}
