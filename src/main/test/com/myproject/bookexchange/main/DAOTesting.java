package com.myproject.bookexchange.main;

import java.util.Date;

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
import com.myproject.bookexchange.tools.PasswordEnrypter;

public class DAOTesting {
  
  public static MongoOperations getMongoOperations() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(
        MongoConfiguration.class);
    MongoOperations mongoOperation = (MongoOperations) ctx
        .getBean("mongoTemplate");
    return mongoOperation;
  }
  
  public static void main(String[] args) throws ApplicationException {
    MongoOperations mongoOperation = getMongoOperations();
    SecurityVO sec = new SecurityVO();
    sec.setLogin("newpos");
    sec.setPassword(PasswordEnrypter.getDiggest("pwd"));
    UserVO user = new UserVO();
    user.setBirthdate(new Date());
    user.setSecurity(sec);
    user.setName("Alex");
    user.setSurname("Bloch");
    user.setDescription("New simple user");
    mongoOperation.save(user);
    ObjectId id = (ObjectId)user.getId();
    //mongoOperation.save(book);
    //mongoOperation.save(ch);*/
    //Query q = new Query(Criteria.where("login").is("newpos"));
    //SecurityVO savedUser = mongoOperation.findOne(q, SecurityVO.class);
    //System.out.println(savedUser);
  }
  
}
