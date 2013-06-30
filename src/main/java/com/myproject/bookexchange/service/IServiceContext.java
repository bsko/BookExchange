package com.myproject.bookexchange.service;

public interface IServiceContext {
  
  public IBookService getBookService();
  public IChangeService getChangeService();
  public IUserService getUserService();
  
}
