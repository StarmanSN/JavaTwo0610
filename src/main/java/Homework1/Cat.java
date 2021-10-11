package Homework1;

public class Cat implements Jumpable, Runnable, Competitor {
    private String nickname;
    private int age;
    private int maxDistance = 100;
    private double maxHeight = 1;

    public Cat() {

    }

    public Cat(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
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

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        if (maxDistance > 0 && maxDistance < 100) {

            this.maxDistance = maxDistance;
            System.out.println("Кот по кличке " + this.nickname + " стог пробежать дистанцию в " + maxDistance + " метров.");
        } else if (maxDistance >= 100) {
            maxDistance = 100;
            System.out.println("Кот по кличке " + this.nickname + " пробежал " + maxDistance + " метров, но ему лень бежать бельше.");
        }
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        if (maxHeight >= 0 && maxHeight < 1) {
            this.maxHeight = maxHeight;
            System.out.println("Кот по кличке " + this.nickname + " стог перепрыгнуть препятствие в " + maxHeight + " метра.");
        } else if (maxHeight >= 1) {
            maxHeight = 1;
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
    public int maxDistance() {
        if (maxDistance > 0 && maxDistance < 100) {

            this.maxDistance = maxDistance;
            System.out.println("Кот по кличке " + this.nickname + " стог пробежать дистанцию в " + maxDistance + " метров.");
        } else if (maxDistance >= 100) {
            maxDistance = 100;
            System.out.println("Кот по кличке " + this.nickname + " пробежал " + maxDistance + " метров, но ему лень бежать бельше.");
        }
        return 0;
    }

    @Override
    public int maxHeight() {
        if (maxHeight >= 0 && maxHeight < 1) {
            this.maxHeight = maxHeight;
            System.out.println("Кот по кличке " + this.nickname + " стог перепрыгнуть препятствие в " + maxHeight + " метра.");
        } else if (maxHeight >= 1) {
            maxHeight = 1;
            System.out.println(this.nickname + " лень прыгать выше 1 метра.");

        }
        return 0;

    }
}