package com.myproject.bookexchange.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class BookVO extends DomainObject {
  
  /**
   * 
   */
  private static final long serialVersionUID = -425462222620335969L;
  
  private String name;
  private String author;
  private List<CommentVO> comments;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public List<CommentVO> getComments() {
    return comments;
  }

  public void setComments(List<CommentVO> comments) {
    this.comments = comments;
  }
}
