package com.myproject.bookexchange.main;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.myproject.bookexchange.configuration.MongoConfiguration;
import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.exception.ApplicationException;
import com.myproject.bookexchange.service.IServiceContext;

public class DAOTesting {
  
  public static ApplicationContext ctx = new AnnotationConfigApplicationContext(
      MongoConfiguration.class);
  
  public static MongoOperations getMongoOperations() {
    MongoOperations mongoOperation = (MongoOperations) ctx
        .getBean("mongoTemplate");
    return mongoOperation;
  }
  
  public static IServiceContext getContext() {
    IServiceContext services = (IServiceContext) ctx
        .getBean("serviceContext");
    return services;
  }
  
  public static void main(String[] args) throws ApplicationException {
    IServiceContext context = getContext();
    context.getBookService().getEntitiesCount();
    context.getUserService().getEntitiesCount();
    UserVO user = context.getUserService().getUserByLogin("newpos");
    context.getUserService().getUserByLogin("Fake");
    BookVO testbook = context.getBookService().getAllEntities().get(1);
    context.getChangeService().getAllChangesByUser(user);
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.set(Calendar.DAY_OF_MONTH, 17);
    context.getChangeService().getAllChangesForDate(cal.getTime());
    context.getChangeService().getChangesByBook(testbook);
    context.getChangeService().getChangesByGiver(user);
    context.getChangeService().getChangesByReceiver(user);
  }
  
}
