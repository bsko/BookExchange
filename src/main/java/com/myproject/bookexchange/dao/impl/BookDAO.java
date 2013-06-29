package com.myproject.bookexchange.dao.impl;

import com.myproject.bookexchange.dao.IBookDAO;
import com.myproject.bookexchange.domain.BookVO;

public class BookDAO extends GenericMongoDAO<BookVO> implements IBookDAO {

  public BookDAO() {
    super(BookVO.class);
  }

  @Override
  public void beforeEntityUpdateAdd(BookVO entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void beforeEntityDelete(BookVO entity) {
    // TODO Auto-generated method stub
    
  }

}
