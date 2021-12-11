package Homework7.server;

/**
 * Сервис аутентификации
 */
public interface AuthService {

    /**
     * Запустить сервис
     */
    void start();

    /**
     * Откдючить сервис
     */
    void stop();

    /**
     * Получить никнейм по логину/паролю
     * @param login
     * @param pass
     * @return никнейм если найден или null, если такого нет
     */
    String getNickByLoginAndPass(String login, String pass);
}
