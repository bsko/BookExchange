package com.myproject.bookexchange.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.myproject.bookexchange.exception.ApplicationException;

public class PasswordEnrypter {
  public static String getDiggest(String input) throws ApplicationException {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] bytes = input.getBytes();
      md.update(bytes);
      byte[] mdbytes = md.digest();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < mdbytes.length; i++) {
        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new ApplicationException();
    }
  }
}
