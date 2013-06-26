package com.myproject.bookexchange.mining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.myproject.bookexchange.domain.BookVO;
import com.myproject.bookexchange.main.DAOTesting;

public class GoogleBooksMining {
  
  public static void main(String[] args) {
    try {
      String url = "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords=";
      URL obj = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)obj.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      BufferedReader in = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      MongoOperations op = DAOTesting.getMongoOperations();
      String[] strs = response.toString().split("<div class=\"fluid asin");
      for(int i = 1; i < strs.length; i++) {
        String target = strs[i];
        if(target.contains("<span class=\"s9TitleText\">")) {
          String title = target.split("<span class=\"s9TitleText\">")[1].split("</span>")[0];
          String preauthor = target.split("<div class=\"t11\">")[1].split("</div>")[0];
          String author = null;
          if(preauthor.contains("<span")) {
            author = target.split("<span class=\"carat\">&rsaquo;</span>")[1].split("\">")[1].split("</a>")[0];
          } else {
            author = preauthor;
          }
          BookVO bk = new BookVO();
          bk.setAuthor(author);
          bk.setName(title);
          bk.setComments(null);
          op.save(bk);
        }
      } 
    } catch (Throwable e) {
      System.out.println(e);
    }
  }
  
}
