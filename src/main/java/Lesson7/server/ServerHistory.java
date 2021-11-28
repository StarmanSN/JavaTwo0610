package Lesson7.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerHistory {

    public static void chatHistory(String message) throws IOException {
        File history = new File("MessageHistory");
        if (!history.exists()) {
            history.mkdirs();
        }
        File file = new File(history, "chatHistory.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(message + "\n");
        }
    }

    public static void clientHistory(String message) throws IOException {
        File history = new File("MessageHistory");
        if (!history.exists()) {
            history.mkdirs();
        }
        File file = new File(history, "history.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(message + "\n");
        }
    }
}
