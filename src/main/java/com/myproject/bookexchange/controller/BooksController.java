package com.myproject.bookexchange.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
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

import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.exception.ApplicationException;
import com.myproject.bookexchange.service.IServiceContext;

@Controller
@RequestMapping(value = "/books", produces = "application/json")
public class BooksController {
  
  private static final Logger LOG = LoggerFactory.getLogger(BooksController.class);
  
  @Autowired
  private IServiceContext serviceContext;
  
  @RequestMapping(method = GET)
  @ResponseStatus(OK)
  @ResponseBody
  public List<BookVO> list() {
    LOG.info("getting list");
    return serviceContext.getBookService().getAllEntities();
  }
  
  @RequestMapping(method = GET, value="{id}")
  @ResponseStatus(OK)
  @ResponseBody
  public List<BookVO> byOwner(@PathVariable String id) {
    LOG.info("getting list by owner id: " + id);
    return serviceContext.getBookService().getBooksByOwner(new ObjectId(id));
  }
  
  @RequestMapping(method = POST, consumes = "application/json")
  @ResponseStatus(CREATED)
  @ResponseBody
  public BookVO create(@Valid @RequestBody BookVO book) {
    LOG.info("creating book");
    return serviceContext.getBookService().addOrUpdateEntity(book);
  }
  
  @ExceptionHandler(ApplicationException.class)
  @ResponseStatus(BAD_REQUEST)
  @ResponseBody
  public Notification onMethodArgumentNotValidException(ApplicationException ex) {
      return new Notification();
  }
}
