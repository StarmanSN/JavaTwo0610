package Lesson7.server;

import Lesson7.constants.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

/**
 * Обработчик для конкретного клиента
 */
public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public ClientHandler(MyServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    authentification();
                    readMessage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();

        } catch (IOException ex) {
            throw new RuntimeException("Проблемы при создании обработчика");
        }
    }

    // /auth login pass
    private void authentification() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith(Constants.AUTH_COMMAND)) {
                String[] tokens = str.split("\\s+"); // разбитие строки по пробелам / массив длины 3
                Optional<String> nick = server.getAuthService().getNickByLoginAndPass(tokens[1], tokens[2]);

                if (nick.isPresent()) {
                    //Такого ника нет в чате...
                    //авторизовались
                    name = nick.get();
                    sendMessage(Constants.AUTH_OK_COMMAND + " " + nick);
                    server.broadcastMessage(nick + " вошел в чат");
                    server.broadcastMessage(server.getActiveClients());
                    server.subscribe(this);
                    return;
                } else {
                    sendMessage("Неверные логин/пароль");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessage() throws IOException {
        while (true) {
            String messageFromClient = in.readUTF();
            // hint можем получать команды
            if (messageFromClient.startsWith(Constants.CHECK_COMMAND)) {
                sendMessage(server.getActiveClients());
                System.out.println("Сообщение от " + name + ": " + messageFromClient);
                if (messageFromClient.equals(Constants.END_COMMAND)) {
                    break;
                }
                if (messageFromClient.startsWith(Constants.PRIVATE_MESSAGE_COMMAND)) {
                    String[] tokens = messageFromClient.split("\\s+");
                    String nick = tokens[1];
                    String message = messageFromClient.substring(4 + nick.length());
                    server.sendPrivateMessage(this, nick, message);
                }
                continue;
            }
            server.broadcastMessage(name + ": " + messageFromClient);
        }
    }

    public String getName() {
        return name;
    }

    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(name + " вышел из чата");
        try {
            in.close();
        } catch (IOException ex) {
            // ignore
        }
        try {
            out.close();
        } catch (IOException ex) {
            // ignore
        }
        try {
            socket.close();
        } catch (IOException ex) {
            // ignore
        }
    }
}
