package Lesson13.Homework;

import java.util.Random;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static Random random = new Random();

    public static void main(String[] args) {
        Thread[] threads = new Thread[CARS_COUNT];
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + random.nextInt() * 10);
        }
        for (int i = 0; i < cars.length; i++) {

            threads[i] = new Thread(cars[i]);
            threads[i].start();
        }
            for (int i = 0; i < cars.length; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
