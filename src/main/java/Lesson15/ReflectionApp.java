package Lesson15;

import java.lang.reflect.Modifier;

public class ReflectionApp {

    public static void main(String[] args) {

        Class clazz = "Java".getClass();

        Class strClass = String.class; //вернет экземаляр объекта класс
        Class intClass = Integer.class;

        Class smallIntClass = int.class;

        Class smallIntArrayClass = int[].class;

        System.out.println(smallIntArrayClass.getName() + " " + smallIntArrayClass.getSimpleName());

        System.out.println(new int[][]{{1, 2}, {3, 4}});

        int modifiers = clazz.getModifiers();
        if (Modifier.isFinal(modifiers)) {
            System.out.println(clazz.getName() + " is final");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(clazz.getName() + " is abstract");
        }
        if (Modifier.isPublic(modifiers)) {
            System.out.println(clazz.getName() + " is public");
        }

        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        Class superclass = clazz.getSuperclass();

    }
}
