package Homework1;

public class Robot  implements AbilityToJump, AbilityToRun, Compete {
    private String model;
    private double runDistance;
    private double jumpHeight;

    public Robot() {

    }

    public Robot(String model) {
        this.model = model;
    }

    public Robot(String nickname, double runDistance, double jumpHeight) {
        this.model = nickname;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRunDistance() {
//        System.out.println("Робот идет пешком.");
        return runDistance;

    }

    public void setRunDistance(double runDistance) {
        System.out.println("Робот модели " + this.model + " не умеет бегать, но идет пешком " + runDistance + " метров.");
        this.runDistance = runDistance;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        System.out.println("Робот модели " + this.model + " не умеет прыгать.");
        jumpHeight = 0;
    }

    @Override
    public void jump() {
        System.out.println(this.model + " не умеет прыгать.");

    }

    @Override
    public void run() {
        System.out.println(this.model + " не умеет бегать, но идет пешком.");

    }

    @Override
    public void doSomething() {

    }
}
