package Lesson2.poly;

public class Bus extends Transport {
    String marshrout;

    public String getMarshrout() {
        return marshrout;
    }

    public void setMarshrout(String marshrout) {
        this.marshrout = marshrout;
    }

    @Override
    void load() {
        System.out.println("Люди ломятся в автобус");
    }
}
