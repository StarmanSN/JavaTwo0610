package Lesson7.server;

//Логика сервера

import Lesson14.CurrentClass;
import Lesson7.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyServer {
    private static final Logger logger = LogManager.getLogger(CurrentClass.class);

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

    public int timeout = Constants.TIME_OUT;

    public MyServer() {
        try (ServerSocket server = new ServerSocket(Constants.SERVER_PORT)) {
            authService = new DbAuthService();
            authService.start();
            logger.info("Сервер запущен");
            clients = new ArrayList<>();

            while (true) {
                System.out.println("Сервер ожидает подключения");
                logger.info("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                logger.info("Клиент подключился");
                new ClientHandler(this, socket);
                new Thread(() -> {
                    for (ClientHandler c : clients) {
                        System.out.println("Ждем когда клиент авторизуется");
                        logger.info("Ждем когда клиент авторизуется");
                        try {
                            Thread.sleep(Constants.TIME_OUT);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (System.currentTimeMillis() > Constants.TIME_OUT) {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Не дождались авторизации");
                            logger.info("Не дождались авторизации");
                        }
                    }
                }).start();
            }

        } catch (SQLException throwables) {
            System.out.println("Ошибка в работе сервера");
            logger.info("Ошибка в работе сервера");
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
                logger.info("Сервер остановлен");
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> {
            try {
                client.sendMessage(message);
                logger.info("Отправлено сообщение: " + client.getName() + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
        logger.info("клиент с ником " + client.getName() + " вошел в чат");
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public synchronized String getActiveClients() {
        StringBuilder sb = new StringBuilder(Constants.CHECK_COMMAND).append(" ");
        sb.append(clients.stream()
                .map(c -> c.getName())
                .collect(Collectors.joining())
        );
        return sb.toString();
    }

    public synchronized void sendPrivateMessage(ClientHandler from, String nickTo, String message) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getName().equals(nickTo)) {
                client.sendMessage("Сообщение от " + from.getName() + ": " + message);
                logger.info("Сообщение от " + from.getName() + ": " + message);
                from.sendMessage("Сообщение клиенту " + nickTo + ": " + message);
                return;
            }
        }
        from.sendMessage("Участника с ником " + nickTo + "нет в чате");
    }
}
