package com.myproject.bookexchange.controller;

import com.myproject.bookexchange.service.IServiceContext;
import com.myproject.bookexchange.service.impl.ServiceContext;

public class MainController {
  
  public IServiceContext getServiceContext() {
    return ServiceContext.getServiceContext();
  }
  
}
