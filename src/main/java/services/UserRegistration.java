package services;

import java.util.HashMap;

public class UserRegistration {

    private HashMap<String, String> registeredAccounts = new HashMap<>();

    /**
     * Регистрация нового пользователя с использованием электронной почты и пароля.
     *
     * @param email Электронная почта.
     * @param password Пароль.
     * @return boolean Возвращает true, если регистрация прошла успешно, иначе false.
     */
    public boolean register(String email, String password) {
        // Проверка, существует ли уже такой электронный адрес
        if (registeredAccounts.containsKey(email)) {
            return false;
        }

        // В реальном приложении здесь должна быть логика для сохранения пользователя в базе данных.
        // Например, это может быть взаимодействие с SQL или NoSQL базой данных.
        // Также необходимо хешировать пароль перед сохранением в базу данных.

        // Добавление новой электронной почты и пароля в хеш-карту зарегистрированных аккаунтов.
        registeredAccounts.put(email, password);

        return true;
    }

    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();

        // Пример регистрации
        boolean registrationStatus = userRegistration.register("example@email.com", "examplePassword");
        System.out.println("Регистрация успешна? " + (registrationStatus ? "Да" : "Нет"));
    }
}
