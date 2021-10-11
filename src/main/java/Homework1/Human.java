package Homework1;

public class Human implements Jumpable, Runnable, Competitor {
    private String name;
    private int age;
    private int maxDistance = 1000;
    private int maxHeight = 2;

    public Human() {

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
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

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        if (maxDistance >= 0 && maxDistance < 1000) {
            this.maxDistance = maxDistance;
            System.out.println("Человек по имени " + this.name + " смог пробежать " + maxDistance + " метров.");
        } else if (maxDistance >= 1000) {
            this.maxDistance = 1000;
            System.out.println("Человек по имени " + this.name + " не смог пробежать " + maxDistance + " метров, он выдохся на 1000 метров.");
        }
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        if (maxHeight >= 0 && maxHeight < 2) {
            maxHeight = maxHeight;
            System.out.println("Человек по имени " + this.name + " смог перепрыгнуть препятствие в " + maxHeight + " метра.");

        } else if (maxHeight >= 2) {
            maxHeight = 2;
            System.out.println("Человек по имени " + this.name + " не может перепрыгнуть препятствие в " + maxHeight + " метра.");
        }
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
    public int maxDistance() {
        if (maxDistance >= 0 && maxDistance < 1000) {
            this.maxDistance = maxDistance;
            System.out.println("Человек по имени " + this.name + " смог пробежать " + maxDistance + " метров.");
        } else if (maxDistance >= 1000) {
            this.maxDistance = 1000;
            System.out.println("Человек по имени " + this.name + " не смог пробежать " + maxDistance + " метров, он выдохся на 1000 метров.");
        }
        return maxDistance;
    }

    @Override
    public int maxHeight() {
        if (maxHeight >= 0 && maxHeight < 2) {
            maxHeight = maxHeight;
            System.out.println("Человек по имени " + this.name + " смог перепрыгнуть препятствие в " + maxHeight + " метра.");

        } else if (maxHeight >= 2) {
            maxHeight = 2;
            System.out.println("Человек по имени " + this.name + " не может перепрыгнуть препятствие в " + maxHeight + " метра.");
        }
        return 0;
    }

}
