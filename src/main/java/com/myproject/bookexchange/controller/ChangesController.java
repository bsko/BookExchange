package com.myproject.bookexchange.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.ChangeVO;
import com.myproject.bookexchange.exception.ApplicationException;
import com.myproject.bookexchange.service.IServiceContext;

@Controller
@RequestMapping(value = "/changes", produces = "application/json")
public class ChangesController {
  
  private static final Logger LOG = LoggerFactory.getLogger(ChangesController.class);
  
  @Autowired
  private IServiceContext serviceContext;
  
  @RequestMapping(method = GET)
  @ResponseStatus(OK)
  @ResponseBody
  public List<ChangeVO> list() {
    LOG.info("getting list");
    return serviceContext.getChangeService().getAllEntities();
  }
  
  @RequestMapping(method = POST, consumes = "application/json")
  @ResponseStatus(CREATED)
  @ResponseBody
  public ChangeVO create(@Valid @RequestBody ChangeVO change) {
    LOG.info("creating change");
    ChangeVO ch = serviceContext.getChangeService().addOrUpdateEntity(change);
    BookVO book = serviceContext.getBookService().getById(ch.getBook());
    book.setOwner(ch.getReceiver());
    serviceContext.getBookService().addOrUpdateEntity(book);
    return ch;
  }
  
  @ExceptionHandler(ApplicationException.class)
  @ResponseStatus(BAD_REQUEST)
  @ResponseBody
  public Notification onMethodArgumentNotValidException(ApplicationException ex) {
      return new Notification();
  }
}
