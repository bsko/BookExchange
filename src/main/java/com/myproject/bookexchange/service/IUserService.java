package com.myproject.bookexchange.service;

import com.myproject.bookexchange.domain.UserVO;

public interface IUserService extends IGenericService<UserVO>{
  public UserVO getUserByLogin(String login);
}
