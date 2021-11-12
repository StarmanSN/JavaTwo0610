package Homework1.hw;

public class Wall extends Obstacle{
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public int getHeight() {
        return (int) height;
    }
}
