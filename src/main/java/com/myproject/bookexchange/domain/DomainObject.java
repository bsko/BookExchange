package com.myproject.bookexchange.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;

public abstract class DomainObject implements Serializable {
  
  private ObjectId id;
  
  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }
}
