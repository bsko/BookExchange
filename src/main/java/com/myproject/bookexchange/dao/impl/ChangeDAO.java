package com.myproject.bookexchange.dao.impl;

import java.util.Date;
import java.util.List;

import com.myproject.bookexchange.dao.IChangeDAO;
import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.ChangeVO;
import com.myproject.bookexchange.domain.UserVO;

public class ChangeDAO extends GenericMongoDAO<ChangeVO> implements IChangeDAO {

  public ChangeDAO() {
    super(ChangeVO.class);
  }

  @Override
  public void beforeEntityUpdateAdd(ChangeVO entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void beforeEntityDelete(ChangeVO entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<ChangeVO> getChangesByBook(BookVO book) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ChangeVO> getChangesByReceiver(UserVO receiver) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ChangeVO> getChangesByGiver(UserVO giver) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ChangeVO> getAllChangesByUser(UserVO user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ChangeVO> getAllChangesForDate(Date date) {
    // TODO Auto-generated method stub
    return null;
  }

}
