package ru.neustupov.utils;

import java.util.HashMap;
import java.util.Map;
import ru.neustupov.bean.UserAccount;
import ru.neustupov.config.SecurityConfig;

public class DataDAO {

  private static final Map<String, UserAccount> mapUsers = new HashMap<>();

  static {
    initUsers();
  }

  private static void initUsers() {

    // This user has a role as EMPLOYEE.
    UserAccount emp = new UserAccount("employee1", "123", UserAccount.GENDER_MALE,
        SecurityConfig.ROLE_EMPLOYEE);

    // This user has 2 roles EMPLOYEE and MANAGER.
    UserAccount mng = new UserAccount("manager1", "123", UserAccount.GENDER_MALE,
        SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);

    mapUsers.put(emp.getUserName(), emp);
    mapUsers.put(mng.getUserName(), mng);
  }

  // Find a User by userName and password.
  public static UserAccount findUser(String userName, String password) {
    UserAccount u = mapUsers.get(userName);
    if (u != null && u.getPassword().equals(password)) {
      return u;
    }
    return null;
  }

}
