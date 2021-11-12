package Lesson7.server;

import java.util.Optional;

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
    Optional<String> getNickByLoginAndPass(String login, String pass);
}
