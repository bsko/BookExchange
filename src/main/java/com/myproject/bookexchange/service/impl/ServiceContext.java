package com.myproject.bookexchange.service.impl;

import com.myproject.bookexchange.service.IBookService;
import com.myproject.bookexchange.service.IChangeService;
import com.myproject.bookexchange.service.IServiceContext;
import com.myproject.bookexchange.service.IUserService;

public class ServiceContext implements IServiceContext {

  public IBookService bookS;
  public IChangeService changeS;
  public IUserService userS;
  
  private static IServiceContext context;
  
  public ServiceContext(IBookService bookS, IChangeService changeS, IUserService userS) {
    this.bookS = bookS;
    this.changeS = changeS;
    this.userS = userS;
  }
  
  @Override
  public IBookService getBookService() {
    return bookS;
  }

  @Override
  public IChangeService getChangeService() {
    return changeS;
  }

  @Override
  public IUserService getUserService() {
    return userS;
  }
  
  public static IServiceContext getServiceContext() {
    return context;
  }
  
  public static void setServiceContext(IServiceContext ctx) {
    context = ctx;
  }
  
}
