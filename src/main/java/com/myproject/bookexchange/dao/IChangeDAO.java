package com.myproject.bookexchange.dao;

import java.util.Date;
import java.util.List;

import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.ChangeVO;
import com.myproject.bookexchange.domain.UserVO;

public interface IChangeDAO extends IGenericDAO<ChangeVO> {
  
  public List<ChangeVO> getChangesByBook(BookVO book);
  public List<ChangeVO> getChangesByReceiver(UserVO receiver);
  public List<ChangeVO> getChangesByGiver(UserVO giver);
  public List<ChangeVO> getAllChangesByUser(UserVO user);
  public List<ChangeVO> getAllChangesForDate(Date date);
  
}
