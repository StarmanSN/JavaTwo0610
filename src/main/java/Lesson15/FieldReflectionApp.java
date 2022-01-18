package Lesson15;

import java.lang.reflect.Field;

public class FieldReflectionApp {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class bikeClass = Bike.class;

        Field[] fields = bikeClass.getDeclaredFields(); //DeclaredFields - дает доступ к приватным полям

        for (Field f : fields) {
            System.out.println("name = " + f.getName() + " type = " + f.getType().getName());
        }

        Bike bike = new Bike();
        System.out.println(bike);

        Field field = bikeClass.getField("model");
        field.set(bike, "Canyon");
        System.out.println(bike);

        Field yearField = bikeClass.getDeclaredField("year");
        yearField.setAccessible(true); //изменение модификатора доступа только для этого объекта
        yearField.set(bike, 2021);
        System.out.println(bike);
    }
}
