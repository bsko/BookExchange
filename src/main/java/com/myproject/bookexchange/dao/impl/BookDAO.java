package com.myproject.bookexchange.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

  @Override
  public List<BookVO> getBooksByOwner(ObjectId id) {
    Query q = new Query(Criteria.where("owner").is(id));
    return mongo.find(q, BookVO.class);
  }

}
