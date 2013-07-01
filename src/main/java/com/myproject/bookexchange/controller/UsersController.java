package com.myproject.bookexchange.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.List;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.exception.ApplicationException;
import com.myproject.bookexchange.service.IServiceContext;

@Controller
@RequestMapping(value="/users", produces = "application/json")
public class UsersController {
  
  private static Logger LOG = LoggerFactory.getLogger(UsersController.class); 
  
  @Autowired
  private IServiceContext serviceContext;
  
  @RequestMapping(method=GET)
  @ResponseStatus(OK)
  @ResponseBody
  public List<UserVO> list() {
    LOG.info("getting list");
    return serviceContext.getUserService().getAllEntities();
  }
  
  @RequestMapping(method=GET, value="{id}")
  @ResponseStatus(OK)
  @ResponseBody
  public UserVO byId(@PathVariable String id) {
    LOG.info("getting by id: " + id);
    return serviceContext.getUserService().getById(new ObjectId(id));
  }
  
  @RequestMapping(method=POST, consumes="application/json")
  @ResponseStatus(CREATED)
  @ResponseBody
  public UserVO create(@Valid @RequestBody UserVO user) {
    LOG.info("creating user");
    return serviceContext.getUserService().addOrUpdateEntity(user);
  }
  
  @ExceptionHandler(ApplicationException.class)
  @ResponseStatus(BAD_REQUEST)
  @ResponseBody
  public Notification onMethodArgumentNotValidException(ApplicationException ex) {
      return new Notification();
  }
}
