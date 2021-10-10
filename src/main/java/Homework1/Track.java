package Homework1;

public class Track {

    private double trackDistance;

    public Track(double trackDistance) {
        this.trackDistance = trackDistance;
    }

    public double getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(double trackDistance) {
        this.trackDistance = trackDistance;
    }

    public static void main(String[] args) {
        int trackDistance = 2000;
        Human human = new Human("Василий Петрович", 50);
        Cat cat = new Cat("Матроскин", 4);
        Robot robot = new Robot("T-800");
        human.run();
        cat.run();
        robot.run();
        System.out.println();

        human.setRunDistance(trackDistance);
        cat.setRunDistance(trackDistance);
        robot.setRunDistance(trackDistance);


    }

}
