package Lesson11;

import java.io.*;

public class BufferedIOApp {

    public static void main(String[] args) {
        try (
                FileOutputStream fous = new FileOutputStream("demo.txt");
                BufferedOutputStream out = new BufferedOutputStream(fous, 100000);
        ) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100_000; i++) {
                out.write(65);
            }
            System.out.println("t1 = " + (System.currentTimeMillis() - start));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedInputStream in =
                     new BufferedInputStream(new FileInputStream(new File("demo.txt")))){

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
