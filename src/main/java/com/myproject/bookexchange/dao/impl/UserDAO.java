package com.myproject.bookexchange.dao.impl;

import com.myproject.bookexchange.dao.IUserDAO;
import com.myproject.bookexchange.domain.UserVO;

public class UserDAO extends GenericMongoDAO<UserVO> implements IUserDAO {

  public UserDAO() {
    super(UserVO.class);
  }

  @Override
  public void beforeEntityUpdateAdd(UserVO entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void beforeEntityDelete(UserVO entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public UserVO getUserByLogin(String login) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
