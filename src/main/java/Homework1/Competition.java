package Homework1;

public class Competition {
    public static void main(String[] args) {

        Competitor[] competitors = new Competitor[3];
        competitors[0] = new Human("Вася", 19);
        competitors[1] = new Cat("Ви", 2);
        competitors[2] = new Robot("T-800", 2000, 0);

        Obstacle[] obstacles = new Obstacle[3];
        obstacles[0] = new Wall();
        obstacles[1] = new Track();
        obstacles[2] = new Track();

        competition(competitors, obstacles);
    }


    public static void competition(Competitor[] competitors, Obstacle[] obstacles) {
        for (Competitor competitor : competitors) {
            if (competitor instanceof Runnable) {
                Runnable runnable = (Runnable) competitor;
                for (int i = 0; i < competitors.length; i++) {
                    for (int j = 0; j < obstacles.length; j++) {
                        if (competitors[i].maxDistance() >= obstacles[j].getDistances() && obstacles[j].getDistances() != 0) {
                            competitors[i].run();
                            obstacles[j].getDistances();
                        } else if (competitors[i].maxHeight() >= obstacles[j].getHeights() && obstacles[j].getHeights() != 0) {
                            competitors[i].jump();
                        } else break;
                    }
                }
            }
        }
    }
}