package com.myproject.bookexchange.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

public class CommentVO {
  
  private ObjectId user;
  private String comment;

  public ObjectId getUser() {
    return user;
  }

  public void setUser(ObjectId user) {
    this.user = user;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
