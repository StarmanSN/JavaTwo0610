package Homework1;

public class Wall implements Obstacle {

    private double height;

    public Wall() {
        height = (int) (Math.random() * 10);

    }

    public Wall(double wallHeight) {
        this.height = wallHeight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static void main(String[] args) {

        testWall();
    }

    public static void testWall() {
        int wallHeight = 1;

        Human human = new Human("Василий Петрович", 50);
        Cat cat = new Cat("Матроскин", 4);
        Robot robot = new Robot("T-800");
        human.jump();
        cat.jump();
        robot.jump();
        System.out.println();

        human.setMaxHeight(wallHeight);
        cat.setMaxHeight(wallHeight);
        robot.setJumpHeight(wallHeight);

    }

    @Override
    public int getDistances() {
        return 0;
    }

    @Override
    public int getHeights() {
        return 0;
    }
}
