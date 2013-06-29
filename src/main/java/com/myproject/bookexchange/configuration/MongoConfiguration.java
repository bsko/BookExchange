package com.myproject.bookexchange.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;
import com.myproject.bookexchange.dao.IBookDAO;
import com.myproject.bookexchange.dao.IChangeDAO;
import com.myproject.bookexchange.dao.IUserDAO;
import com.myproject.bookexchange.dao.impl.BookDAO;
import com.myproject.bookexchange.dao.impl.ChangeDAO;
import com.myproject.bookexchange.dao.impl.UserDAO;

@Configuration
public class MongoConfiguration {

  public @Bean
  MongoDbFactory mongoDbFactory() throws Exception {
    return new SimpleMongoDbFactory(new MongoClient(), "bookexchangedb");
  }

  public @Bean
  MongoTemplate mongoTemplate() throws Exception {
    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
    return mongoTemplate;
  }
  
  public @Bean 
    IUserDAO userDAO() throws Exception {
    IUserDAO dao =  new UserDAO();
    dao.setMongo(mongoTemplate());
    return dao;
  }
  
  public @Bean 
    IBookDAO bookDAO() throws Exception {
    IBookDAO dao = new BookDAO();
    dao.setMongo(mongoTemplate());
    return dao;
  }
  
  public @Bean 
    IChangeDAO changeDAO() throws Exception {
    IChangeDAO dao = new ChangeDAO();
    dao.setMongo(mongoTemplate());
    return dao;
  }
}
