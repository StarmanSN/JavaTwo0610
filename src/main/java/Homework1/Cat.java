package Homework1;

public class Cat implements AbilityToJump, AbilityToRun, Compete {
    private String nickname;
    private int age;
    private double runDistance;
    private double jumpHeight;

    public Cat() {

    }

    public Cat(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public Cat(String nickname, int age, double runDistance, double jumpHeight) {
        this.nickname = nickname;
        this.age = age;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        if (runDistance > 0 && runDistance < 100) {

            this.runDistance = runDistance;
            System.out.println("Кот по кличке " + this.nickname + " стог пробежать дистанцию в " + runDistance + " метров.");
        } else if (runDistance >= 100) {
            runDistance = 100;
            System.out.println("Кот по кличке " + this.nickname + " пробежал " + runDistance + " метров, но ему лень бежать бельше.");
        }
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        if (jumpHeight >= 0 && jumpHeight < 1) {
            this.jumpHeight = jumpHeight;
            System.out.println("Кот по кличке " + this.nickname + " стог перепрыгнуть препятствие в " + jumpHeight + " метра.");
        } else if (jumpHeight >= 1) {
            jumpHeight = 1;
            System.out.println(this.nickname + " лень прыгать выше 1 метра.");
        }

    }

    @Override
    public void jump() {
        System.out.println(this.nickname + " хорошо прыгает");

    }

    @Override
    public void run() {
        System.out.println(this.nickname + " бежит");

    }

    @Override
    public void doSomething() {

    }
}
