package com.myproject.bookexchange.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "securities")
public class SecurityVO {

  private Long id;
  private UserVO user;
  private String login;
  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserVO getUser() {
    return user;
  }

  public void setUser(UserVO user) {
    this.user = user;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
