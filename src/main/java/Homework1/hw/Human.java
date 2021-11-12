package Homework1.hw;

public class Human implements Runnable, Jumpable, Competable{

    private int maxDistance;
    private int maxJumpHeight;
    private double stamina;

    public Human(int maxDistance, int maxJumpHeight) {
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(int height) {
        if  (maxJumpHeight >= height) {
            System.out.println("Человек смог перепрыгнуть ");
            return true;
        }
        System.out.println("Человек не смог перепрыгнуть ");
        return false;
    }

    @Override
    public boolean run(int distance) {
        if (maxDistance >= distance) {
            return true;
        }
        return false;
    }
}
