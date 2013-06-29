package com.myproject.bookexchange.dao;

import com.myproject.bookexchange.domain.UserVO;

public interface IUserDAO {
  
  public UserVO getUserByLogin(String login);
  
}
