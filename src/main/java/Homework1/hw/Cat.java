package Homework1.hw;

public class Cat implements Runnable, Jumpable, Competable{
    private int maxDistance;
    private int maxJumpHeight;
    private double stamina;

    public Cat(int maxDistance, int maxJumpHeight) {
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;

    }

    @Override
    public boolean jump(int height) {
        return false;
    }

    @Override
    public boolean run(int distance) {
        return false;
    }
}
