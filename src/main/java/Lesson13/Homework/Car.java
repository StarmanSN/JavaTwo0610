package Lesson13.Homework;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static Random random = new Random();
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Race getRace() {
        return race;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            int ready = 0;
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) Math.random() * 800);
            System.out.println(this.name + " готов");
            ready++;
            if (CARS_COUNT == ready) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }


}
