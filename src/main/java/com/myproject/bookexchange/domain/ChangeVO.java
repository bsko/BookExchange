package com.myproject.bookexchange.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "changes")
public class ChangeVO extends DomainObject {
  
  /**
   * 
   */
  private static final long serialVersionUID = -5559312893368477121L;
  
  private Date date;
  private ObjectId sender;
  private ObjectId receiver;
  private ObjectId book;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public ObjectId getSender() {
    return sender;
  }

  public void setSender(ObjectId sender) {
    this.sender = sender;
  }

  public ObjectId getReceiver() {
    return receiver;
  }

  public void setReceiver(ObjectId receiver) {
    this.receiver = receiver;
  }

  public ObjectId getBook() {
    return book;
  }

  public void setBook(ObjectId book) {
    this.book = book;
  }
}
