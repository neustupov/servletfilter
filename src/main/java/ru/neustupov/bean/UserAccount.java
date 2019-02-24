package ru.neustupov.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAccount {

  public static final String GENDER_MALE = "M";
  public static final String GENDER_FEMALE = "F";

  private String userName;
  private String gender;
  private String password;

  private List<String> roles;

  public UserAccount(String userName, String password, String gender, String... roles) {
    this.userName = userName;
    this.password = password;
    this.gender = gender;

    this.roles = new ArrayList<>();
    if (roles != null) {
      Collections.addAll(this.roles, roles);
    }
  }
}
