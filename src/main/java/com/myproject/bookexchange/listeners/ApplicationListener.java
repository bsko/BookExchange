package com.myproject.bookexchange.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.bookexchange.configuration.MongoConfiguration;
import com.myproject.bookexchange.service.IServiceContext;
import com.myproject.bookexchange.service.impl.ServiceContext;

public class ApplicationListener implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {

  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(
        MongoConfiguration.class);
    IServiceContext context = (IServiceContext) ctx.getBean("serviceContext");
    ServiceContext.setServiceContext(context);
  }

}
