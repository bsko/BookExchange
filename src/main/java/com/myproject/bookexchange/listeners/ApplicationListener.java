package com.myproject.bookexchange.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.myproject.bookexchange.configuration.MongoConfiguration;

public class ApplicationListener implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {

  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(
        MongoConfiguration.class);
    MongoOperations mongoOperation = (MongoOperations) ctx
        .getBean("mongoTemplate");
  }

}
