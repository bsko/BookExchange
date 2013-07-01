package com.myproject.bookexchange.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.myproject.bookexchange.domain.BookVO;

public interface IBookService  extends IGenericService<BookVO> {
  public List<BookVO> getBooksByOwner(ObjectId id);
}
