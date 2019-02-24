package ru.neustupov.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

  public static final String ROLE_MANAGER = "MANAGER";
  public static final String ROLE_EMPLOYEE = "EMPLOYEE";

  // String: Role
  // List<String>: urlPatterns.
  private static final Map<String, List<String>> mapConfig = new HashMap<>();

  static {
    init();
  }

  private static void init() {

    // Конфигурация для роли "EMPLOYEE".
    List<String> urlPatterns1 = new ArrayList<>();

    urlPatterns1.add("/userInfo");
    urlPatterns1.add("/employeeTask");

    mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);

    // Конфигурация для роли "MANAGER".
    List<String> urlPatterns2 = new ArrayList<>();

    urlPatterns2.add("/userInfo");
    urlPatterns2.add("/managerTask");

    mapConfig.put(ROLE_MANAGER, urlPatterns2);
  }

  public static Set<String> getAllAppRoles() {
    return mapConfig.keySet();
  }

  public static List<String> getUrlPatternsForRole(String role) {
    return mapConfig.get(role);
  }
}
