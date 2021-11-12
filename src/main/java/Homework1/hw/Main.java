package Homework1.hw;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human = new Human(100, 2);
        Treadmill treadmill = new Treadmill(10);
        Wall wall = new Wall(1);
        System.out.println(human.run(treadmill.getLength()));
        System.out.println(human.jump(wall.getHeight()));

        List<Obstacle> obstacles = List.of(new Treadmill(10), new Wall(1.5), new Wall(2.1), new Treadmill(5));
        List<Competable> competitors = List.of(new Human(100, 2), new Cat(100, 3), new Cat(100, 1));
        for (Competable competitor : competitors) {
            boolean finished = true;
            for (Obstacle obstacle : obstacles) {

                if (obstacle instanceof Treadmill) {
                    Treadmill treadmill1 = (Treadmill) obstacle;
                    finished = competitor.run(treadmill1.getLength());
                } else if (obstacle instanceof Wall) {
                    finished = competitor.jump(1);
                }
            }
            if (!finished) {
                break;
            }

        }
    }
}
