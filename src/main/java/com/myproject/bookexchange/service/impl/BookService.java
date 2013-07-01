package com.myproject.bookexchange.service.impl;

import java.util.List;

import org.bson.types.ObjectId;

import com.myproject.bookexchange.dao.IBookDAO;
import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.service.IBookService;

public class BookService extends GenericService<BookVO> implements IBookService {

  @Override
  public List<BookVO> getBooksByOwner(ObjectId id) {
    return ((IBookDAO)dao).getBooksByOwner(id);
  }

}
