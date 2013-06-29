package com.myproject.bookexchange.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserVO extends DomainObject {

  /**
   * 
   */
  private static final long serialVersionUID = 1459929015945984258L;
  
  
  private String name;
  private String surname;
  private Date birthdate;
  private String description;
  private SecurityVO security;
  
  public UserVO() {}
  
  public UserVO(String name, String surname, Date birthdate, String description, SecurityVO sec) {
    this.name = name;
    this.surname = surname;
    this.birthdate = birthdate;
    this.description = description;
    this.security = sec;
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
