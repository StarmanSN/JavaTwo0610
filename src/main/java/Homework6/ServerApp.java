package Homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.*;

public class ServerApp {
    private static final Scanner SCANNER = new Scanner(in);

    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            out.println("Сервер запущен, ожидает подключения...");
            socket = serverSocket.accept();
            out.println("Клиент подключился!");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    String message = null;
                    try {
                        message = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (message.equals("/end")) {
                        try {
                            out.writeUTF(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    System.out.println("Клиент прислал: " + message);
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    try {
                        String message = SCANNER.nextLine();
                        out.writeUTF("Сообщение из сервера: " + message);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
