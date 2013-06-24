package com.myproject.bookexchange.domain;

import java.util.Date;

public class UserVO {
  
  private Long id;
  private String name;
  private String surname;
  private Date birthdate;
  private String description;
  private SecurityVO security;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public Date getBirthdate() {
    return birthdate;
  }
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public SecurityVO getSecurity() {
    return security;
  }
  public void setSecurity(SecurityVO security) {
    this.security = security;
  }
}
