package Lesson10;

import java.lang.reflect.AnnotatedType;
import java.util.concurrent.atomic.AtomicInteger;

public class LambdaApp {

    public static void main(String[] args) {
        final AtomicInteger ai = new AtomicInteger(0);
        ai.incrementAndGet();
        //ai = new AtomicInteger(10);
        new Thread(() -> System.out.println(ai.get())).start();
    }

}
