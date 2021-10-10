package Homework1;

public class Human implements AbilityToJump, AbilityToRun, Compete {
    private String name;
    private int age;
    private double runDistance;
    private double jumpHeight;

    public Human() {

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, double runDistance, double jumpHeight) {
        this.name = name;
        this.age = age;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Указан некорректный возраст.");
        }
    }

    public double getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(double runDistance) {
        if (runDistance >= 0 && runDistance < 1000) {
            this.runDistance = runDistance;
            System.out.println("Человек по имени " + this.name + " смог пробежать " + runDistance + " метров.");
        } else if (runDistance >= 1000) {
            this.runDistance = 1000;
            System.out.println("Человек по имени " + this.name + " не смог пробежать " + runDistance + " метров, он выдохся на 1000 метров.");
        }
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        if (jumpHeight >= 0 && jumpHeight < 1.7) {
            jumpHeight = jumpHeight;
            System.out.println("Человек по имени " + this.name + " смог перепрыгнуть препятствие в " + jumpHeight + " метра.");

        } else if (jumpHeight >= 1.7) {
            jumpHeight = 1.7;
            System.out.println("Человек по имени " + this.name + " не может перепрыгнуть препятствие в " + jumpHeight + " метра.");
        }
    }

    public static void ableToJump() {


    }

    @Override
    public void jump() {
        System.out.println(this.name + " прыгает");

    }

    @Override
    public void run() {
        System.out.println(this.name + " бежит");
    }

    @Override
    public void doSomething() {

    }
}
