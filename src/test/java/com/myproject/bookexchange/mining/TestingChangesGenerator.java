package com.myproject.bookexchange.mining;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;

import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.domain.ChangeVO;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.main.DAOTesting;
import com.myproject.bookexchange.service.IServiceContext;

public class TestingChangesGenerator {
  
  public static void main(String[] args) {
    IServiceContext ctx = DAOTesting.getContext();
    List<User> users = new ArrayList<User>();
    List<BookVO> books = ctx.getBookService().getAllEntities();
    List<UserVO> uservos = ctx.getUserService().getAllEntities();
    for(UserVO vo : uservos) {
      User us = new User();
      us.id = vo.getId();
      users.add(us);
    }
    final int changesCount = 300;
    final int booksCount = books.size();
    final int usersCount = users.size();
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.roll(Calendar.DAY_OF_MONTH, 10);
    Random rnd = new Random();
    for(int i = 0; i < changesCount; i++) {
      if(i != 0 && i % (new Integer(changesCount/10).intValue()) == 0) {
        cal.add(Calendar.DAY_OF_MONTH, 1);
      }
      int bookindex = Math.abs(rnd.nextInt() % booksCount);
      BookVO bk = books.get(bookindex);
      User user = null; 
      while(user == null || user.id.equals(bk.getOwner())) {
        int userindex = Math.abs(rnd.nextInt() % usersCount);
        user = users.get(userindex);
      }
      ChangeVO vo = new ChangeVO();
      vo.setBook(bk.getId());
      vo.setDate(cal.getTime());
      vo.setReceiver(user.id);
      vo.setSender(bk.getOwner());
      ctx.getChangeService().addOrUpdateEntity(vo);
      bk.setOwner(user.id);
      ctx.getBookService().addOrUpdateEntity(bk);
    }
    
  }
}


class Book {
  public ObjectId owner;
  public ObjectId id;
}

class User {
  ObjectId id;
}