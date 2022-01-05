package Lesson15.Homework;

public class Car {
    public String model;
    public String color;

    public Car() {
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @BeforeSuite
    void startEngine() {
        System.out.println("Engine started");
    }

    @Test(priority = 1)
    void start() {
        System.out.println("Start");

    }

    @Test
    void drive() {
        System.out.println("Drive");
    }

    @Test(priority = 9)
    void stop() {
        System.out.println("Stop");
    }

    @AfterSuite
    void stopEngine() {
        System.out.println("Engine off");
    }
}
