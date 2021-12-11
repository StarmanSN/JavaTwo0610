package Homework7.server;

//Логика сервера

import Homework7.constants.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    /**
     * Сервис аутентификации
     */
    private AuthService authService;

    /**
     * Активные клиенты
     */
    private List<ClientHandler> clients;

    public AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(Constants.SERVER_PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка в работе сервера.");
            ex.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMessage(message));

//        for (ClientHandler client : clients) {
//            client.sendMessage(message);
//        }
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler client : clients) {
            if (client.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public synchronized void sendPrivateMessage(ClientHandler from, String nickTo, String message) {
        for (ClientHandler client : clients) {
            if (client.getName().equals(nickTo)) {
                client.sendMessage("от " + from.getName() + ": " + message);
                from.sendMessage("Сообщение клиенту " + nickTo + ": " + message);
                return;
            }
        }
        from.sendMessage("Участника с ником " + nickTo + "нет в чате");
    }

    public synchronized String getActiveClients() {
        StringBuilder sb = new StringBuilder(Constants.CLIENTS_LIST_COMMAND).append(" ");
        for (ClientHandler clientHandler : clients) {
            sb.append(clientHandler.getName()).append(" ");
        }
        return sb.toString();
    }
}
