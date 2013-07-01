package com.myproject.bookexchange.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.myproject.bookexchange.domain.BookVO;

public interface IBookDAO extends IGenericDAO<BookVO> {
  public List<BookVO> getBooksByOwner(ObjectId id);
}
