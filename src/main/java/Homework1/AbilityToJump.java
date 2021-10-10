package Homework1;

public interface AbilityToJump {
    default void jump() {
        System.out.println("Прыгает");
    }
}
