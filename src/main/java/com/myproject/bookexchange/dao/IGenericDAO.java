package com.myproject.bookexchange.dao;

import java.util.List;

public interface IGenericDAO<T> {
  
  public void deleteEntity(T entity);
  public long countEntities();
  public T addOrUpdateEntity(T entity);
  public List<T> getAllEntities();
  
}
