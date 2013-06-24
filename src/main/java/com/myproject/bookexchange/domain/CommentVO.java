package com.myproject.bookexchange.domain;

public class CommentVO {
  private Long id;
  private BookVO book;
  private UserVO user;
  private String comment;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public BookVO getBook() {
    return book;
  }
  public void setBook(BookVO book) {
    this.book = book;
  }
  public UserVO getUser() {
    return user;
  }
  public void setUser(UserVO user) {
    this.user = user;
  }
  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
}
