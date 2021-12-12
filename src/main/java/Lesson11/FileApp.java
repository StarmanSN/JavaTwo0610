package Lesson11;

import java.io.File;
import java.io.IOException;

public class FileApp {
    public static void main(String[] args) throws IOException {
        File parentDir = new File("dir");
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        File file = new File(parentDir,"demo.txt");

        System.out.println("File exist " + file.exists());

        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println("Is file " + file.isFile() + " isDirectory " + file.isDirectory());

        System.out.println(file.getParent());

        System.out.println(file.getAbsolutePath());

        for (File f : parentDir.listFiles()) {
            if (f.isDirectory()) {
                continue;
            }
            System.out.println(f.getName());
        }
        file.length();
    }
}
