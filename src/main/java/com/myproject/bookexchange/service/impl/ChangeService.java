package com.myproject.bookexchange.service.impl;

import java.util.Date;
import java.util.List;

import com.myproject.bookexchange.dao.IChangeDAO;
import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.ChangeVO;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.service.IChangeService;

public class ChangeService extends GenericService<ChangeVO> implements IChangeService {

  @Override
  public List<ChangeVO> getChangesByBook(BookVO book) {
    return ((IChangeDAO)dao).getChangesByBook(book);
  }

  @Override
  public List<ChangeVO> getChangesByReceiver(UserVO receiver) {
    return ((IChangeDAO)dao).getChangesByReceiver(receiver);
  }

  @Override
  public List<ChangeVO> getChangesByGiver(UserVO giver) {
    return ((IChangeDAO)dao).getChangesByGiver(giver);
  }

  @Override
  public List<ChangeVO> getAllChangesByUser(UserVO user) {
    return ((IChangeDAO)dao).getAllChangesByUser(user);
  }

  @Override
  public List<ChangeVO> getAllChangesForDate(Date date) {
    return ((IChangeDAO)dao).getAllChangesForDate(date);
  }

}
