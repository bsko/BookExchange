package com.myproject.bookexchange.main;

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
    List<ChangeVO> changes = context.getChangeService().getAllEntities();
    for(ChangeVO ch : changes) {
      BookVO book = context.getBookService().getById(ch.getBook());
      UserVO from = context.getUserService().getById(ch.getSender());
      UserVO to = context.getUserService().getById(ch.getReceiver());
      String fromname = (from != null) ? from.getName() : "null";
      
      System.out.println("At time of: " + ch.getDate() + " Book named: " + book.getName() + " changed owner from: "
          + fromname + " to: " + to.getName());
    }
  }
  
}
