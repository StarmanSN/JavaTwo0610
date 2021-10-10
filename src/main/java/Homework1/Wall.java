package Homework1;

public class Wall {

    private double wallHeight;

    public Wall() {

    }

    public Wall(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public double getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public static void main(String[] args) {

        jumpTheWall();
    }

    public static void jumpTheWall() {
        double wallHeight = 0.5;

        Human human = new Human("Василий Петрович", 50);
        Cat cat = new Cat("Матроскин", 4);
        Robot robot = new Robot("T-800");
        human.jump();
        cat.jump();
        robot.jump();
        System.out.println();

        human.setJumpHeight(wallHeight);
        cat.setJumpHeight(wallHeight);
        robot.setJumpHeight(wallHeight);

    }
}
