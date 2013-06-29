package com.myproject.bookexchange.mining;

import java.util.Calendar;
import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;

import com.myproject.bookexchange.domain.SecurityVO;
import com.myproject.bookexchange.domain.UserVO;
import com.myproject.bookexchange.exception.ApplicationException;
import com.myproject.bookexchange.main.DAOTesting;
import com.myproject.bookexchange.tools.PasswordEnrypter;

public class UsersMining {
  
  public static void main(String[] args) throws ApplicationException {
    MongoOperations op = DAOTesting.getMongoOperations();
    
    Calendar cl1 = Calendar.getInstance();
    cl1.setTime(new Date());
    cl1.set(Calendar.YEAR, 1985);
    Calendar cl2 = Calendar.getInstance();
    cl2.setTime(new Date());
    cl2.set(Calendar.YEAR, 1982);
    cl2.set(Calendar.MONTH, 2);
    cl2.set(Calendar.DAY_OF_MONTH, 12);
    Calendar cl3 = Calendar.getInstance();
    cl3.setTime(new Date());
    cl3.set(Calendar.YEAR, 1978);
    cl3.set(Calendar.MONTH, 10);
    cl3.set(Calendar.DAY_OF_MONTH, 3);
    Calendar cl4 = Calendar.getInstance();
    cl4.setTime(new Date());
    cl4.set(Calendar.YEAR, 1990);
    cl4.set(Calendar.MONTH, 1);
    cl4.set(Calendar.DAY_OF_MONTH, 25);
    
    UserVO u = new UserVO("John", "Smith", cl1.getTime(), "John Smith user", new SecurityVO("johnsmith", PasswordEnrypter.getDiggest("johnsmith")));
    UserVO u1 = new UserVO("Viktoria", "Temnova", cl2.getTime(), "My lovely wife", new SecurityVO("mona", PasswordEnrypter.getDiggest("12345")));
    UserVO u2 = new UserVO("Alex", "Temnov", cl3.getTime(), "Its my self", new SecurityVO("bsko", PasswordEnrypter.getDiggest("bsko")));
    UserVO u3 = new UserVO("Newpos", "Pos", cl4.getTime(), "SLOLP user", new SecurityVO("newpos", PasswordEnrypter.getDiggest("a")));
    UserVO u4 = new UserVO("Habele", "Hab", cl1.getTime(), "SLOLP admin", new SecurityVO("habele", PasswordEnrypter.getDiggest("a")));
    UserVO u5 = new UserVO("Jose", "Mourinho", cl2.getTime(), "Chelsea coach", new SecurityVO("jose", PasswordEnrypter.getDiggest("chelsea")));
    UserVO u6 = new UserVO("John", "Carmac", cl3.getTime(), "Quake founder", new SecurityVO("carmac", PasswordEnrypter.getDiggest("quake")));
    UserVO u7 = new UserVO("Fernando", "Alonso", cl4.getTime(), "Ferrari driver", new SecurityVO("falonso", PasswordEnrypter.getDiggest("hatevettel")));
    
    op.save(u);
    op.save(u1);
    op.save(u2);
    op.save(u3);
    op.save(u4);
    op.save(u5);
    op.save(u6);
    op.save(u7);
  }
  
}
