import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
  
  // Хранилище для зарегистрированных пользователей (для примера используется HashMap)
  private static Map<String, String> users = new HashMap<>();

  /**
   * Регистрация нового пользователя.
   * 
   * @param email Электронная почта пользователя.
   * @param password Пароль пользователя.
   * @return Статус регистрации.
   */
  public static boolean register(String email, String password) {
    if (users.containsKey(email)) {
      // Если пользователь с таким email уже существует
      return false;
    }
    users.put(email, password);
    return true;
  }

  /**
   * Аутентификация пользователя.
   * 
   * @param email Электронная почта пользователя.
   * @param password Пароль пользователя.
   * @return Статус аутентификации.
   */
  public static boolean authenticate(String email, String password) {
    return users.containsKey(email) && users.get(email).equals(password);
  }
}
