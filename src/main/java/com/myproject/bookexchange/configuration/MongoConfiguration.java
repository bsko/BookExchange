package com.myproject.bookexchange.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
import com.myproject.bookexchange.service.IBookService;
import com.myproject.bookexchange.service.IChangeService;
import com.myproject.bookexchange.service.IServiceContext;
import com.myproject.bookexchange.service.IUserService;
import com.myproject.bookexchange.service.impl.BookService;
import com.myproject.bookexchange.service.impl.ChangeService;
import com.myproject.bookexchange.service.impl.ServiceContext;
import com.myproject.bookexchange.service.impl.UserService;

@Configuration
@PropertySource("classpath:resources/db.properties")
public class MongoConfiguration {

  @Autowired
  private Environment env;
  
  public @Bean
  MongoDbFactory mongoDbFactory() throws Exception {
    return new SimpleMongoDbFactory(new MongoClient(), env.getProperty("mongodb.name"));
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
  
  public @Bean IBookService bookService() throws Exception {
    IBookService service = new BookService();
    service.setDao(bookDAO());
    return service;
  }
  
  public @Bean IChangeService changeService() throws Exception {
    IChangeService service = new ChangeService();
    service.setDao(changeDAO());
    return service;
  }
  
  public @Bean IUserService userService() throws Exception {
    IUserService service = new UserService();
    service.setDao(userDAO());
    return service;
  }
  
  public @Bean IServiceContext serviceContext() throws Exception {
    return new ServiceContext(bookService(), changeService(), userService());
  }
}
