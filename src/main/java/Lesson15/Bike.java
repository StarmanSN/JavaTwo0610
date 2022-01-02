package Lesson15;

public class Bike {
    public String model;
    public String serialNo;
    private int year;

    public Bike(String model, String serialNo) {
        this.model = model;
        this.serialNo = serialNo;
    }

    public Bike() {
    }

    public Bike(String model, String serialNo, int year) {
        this(model, serialNo);
        this.year = year;
    }

    @SimpleAnnotation
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @SimpleAnnotation
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @SimpleAnnotation
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @NotSimpleAnnotation
    private void setYearAndModel(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", year=" + year +
                '}';
    }
}
