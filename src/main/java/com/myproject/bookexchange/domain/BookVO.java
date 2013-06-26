package com.myproject.bookexchange.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class BookVO {
  
  private ObjectId id;
  private String name;
  private String description;
  private List<CommentVO> comments;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<CommentVO> getComments() {
    return comments;
  }

  public void setComments(List<CommentVO> comments) {
    this.comments = comments;
  }
}
