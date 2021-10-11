package Homework1;

public class Track implements Obstacle {

    private double distance;

    public Track() {
        distance = (int)(Math.random() * 100);
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static void main(String[] args) {
        testTrack();
    }

    public static void testTrack() {
        int trackDistance = 1000;
        Human human = new Human("Василий Петрович", 50);
        Cat cat = new Cat("Матроскин", 4);
        Robot robot = new Robot("T-800");
        human.run();
        cat.run();
        robot.run();
        System.out.println();

        human.setMaxDistance(trackDistance);
        cat.setMaxDistance(trackDistance);
        robot.setRunDistance(trackDistance);

    }

    @Override
    public int getDistances() {
     return (int)(Math.random() * 100);
    }

    @Override
    public int getHeights() {
        return 0;
    }
}
