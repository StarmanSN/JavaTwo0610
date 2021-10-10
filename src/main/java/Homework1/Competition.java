package Homework1;

import java.sql.Array;
import java.util.Arrays;

public class Competition {
    public static void main(String[] args) {

        Human[] humans = new Human[2];
        Cat[] cats = new Cat[2];
        Robot[] robots = new Robot[2];

        Wall[] walls = new Wall[2];
        Track[] tracks = new Track[2];

        humans[0] = new Human("Вася", 16, 500, 1.5);
        humans[1] = new Human("Петя", 18, 5500, 1.6);
        cats[0] = new Cat("Рыжик", 2, 100, 2);
        cats[1] = new Cat("Серый", 3, 50, 0.5);
        robots[0] = new Robot("T-700");
        robots[1] = new Robot("T-800");

        walls[0] = new Wall(0.5);
        walls[1] = new Wall(1.5);
        tracks[0] = new Track(50);
        tracks[1] = new Track(350);


        for (Human human : humans) {
            System.out.println();
            human.setRunDistance(human.getRunDistance());
            human.setJumpHeight(human.getJumpHeight());

        }
        for (Cat cat : cats) {
            System.out.println();
            cat.setRunDistance(cat.getRunDistance());
            cat.setJumpHeight(cat.getJumpHeight());

        }
        for (Robot robot : robots) {
            System.out.println();
            robot.setRunDistance(10);
            robot.setJumpHeight(robot.getJumpHeight());
        }
    }
}
