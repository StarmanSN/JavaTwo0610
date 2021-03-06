package Homework7.server;

import Homework7.constants.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
            this.name = "";
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
                String nick = server.getAuthService().getNickByLoginAndPass(tokens[1], tokens[2]);
                if (nick != null) {
                    if (!server.isNickBusy(nick)) {
                        //Такого ника нет в чате...
                        //авторизовались
                        name = nick;
                        sendMessage(Constants.AUTH_OK_COMMAND + " " + nick);
                        server.broadcastMessage(nick + " вошел в чат");
                        server.broadcastMessage(server.getActiveClients());
                        server.subscribe(this);
                        return;
                    } else {
                        sendMessage("Учетная запись уже используется");
                    }
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
            String messageFromClient = null;
            try {
                messageFromClient = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // hint можем получать команды
            if (messageFromClient.startsWith(Constants.CLIENTS_LIST_COMMAND)) {
                sendMessage(server.getActiveClients());
                System.out.println("Сообщение от " + name + ": " + messageFromClient);
                if (messageFromClient.equals(Constants.END_COMMAND)) {
                    break;
                }
                if (messageFromClient.startsWith("/w ")) {
                    String[] tokens = messageFromClient.split("\\s+");
                    String nick = tokens[1];
                    String message = messageFromClient.substring(2 + nick.length());
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
