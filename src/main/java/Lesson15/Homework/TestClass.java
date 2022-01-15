package Lesson15.Homework;

import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) {
        start(Car.class);
    }

    public static void start(Class classObject) {
        Method[] declaredMethods = classObject.getDeclaredMethods();
        try {
            int count = 0;
            for (Method o : declaredMethods) {
                if (o.getAnnotation(BeforeSuite.class) != null) {
                    if (count > 1) throw new RuntimeException();
                    System.out.println(o);
                    count++;
                }
            }
            for (int i = 0; i < 11; i++) {
                for (Method t : declaredMethods) {
                    if (t.isAnnotationPresent(Test.class) && t.getAnnotation(Test.class).priority() == i) {
                        Test test = t.getAnnotation(Test.class);
                        System.out.println(t);
                        System.out.println("priority: " + test.priority());
                    }
                }
            }
            int count2 = 0;
            for (Method o : declaredMethods) {
                if (o.getAnnotation(AfterSuite.class) != null) {
                    if (count2 > 1) throw new RuntimeException();
                    System.out.println(o);
                    count2++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
