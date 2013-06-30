package com.myproject.bookexchange.service.impl;

import com.myproject.bookexchange.dao.IUserDAO;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.service.IUserService;

public class UserService extends GenericService<UserVO> implements IUserService {

  @Override
  public UserVO getUserByLogin(String login) {
    return ((IUserDAO)dao).getUserByLogin(login);
  }
  
}
