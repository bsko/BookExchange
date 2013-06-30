package com.myproject.bookexchange.main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.myproject.bookexchange.configuration.MongoConfiguration;
import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.ChangeVO;
import com.myproject.bookexchange.domain.SecurityVO;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.exception.ApplicationException;
import com.myproject.bookexchange.service.IServiceContext;
import com.myproject.bookexchange.tools.PasswordEnrypter;

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
    long bcount = context.getBookService().getEntitiesCount();
    long ucount = context.getUserService().getEntitiesCount();
    UserVO user = context.getUserService().getUserByLogin("newpos");
    UserVO user1 = context.getUserService().getUserByLogin("Fake");
    BookVO testbook = context.getBookService().getAllEntities().get(1);
    List<ChangeVO> changesbyuser = context.getChangeService().getAllChangesByUser(user);
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.set(Calendar.DAY_OF_MONTH, 17);
    List<ChangeVO> changesbydate = context.getChangeService().getAllChangesForDate(cal.getTime());
    List<ChangeVO> changesbybook = context.getChangeService().getChangesByBook(testbook);
    List<ChangeVO> changesbygiver = context.getChangeService().getChangesByGiver(user);
    List<ChangeVO> changesbyreceiver = context.getChangeService().getChangesByReceiver(user);
  }
  
}
