package com.myproject.bookexchange.dao;

import com.myproject.bookexchange.domain.UserVO;

public interface IUserDAO extends IGenericDAO<UserVO> {
  
  public UserVO getUserByLogin(String login);
  
}
