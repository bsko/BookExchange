package com.myproject.bookexchange.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "changes")
public class ChangeVO {
  private Long id;
  private Date date;
  private UserVO sender;
  private UserVO receiver;
  private BookVO book;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public UserVO getSender() {
    return sender;
  }

  public void setSender(UserVO sender) {
    this.sender = sender;
  }

  public UserVO getReceiver() {
    return receiver;
  }

  public void setReceiver(UserVO receiver) {
    this.receiver = receiver;
  }

  public BookVO getBook() {
    return book;
  }

  public void setBook(BookVO book) {
    this.book = book;
  }
}
