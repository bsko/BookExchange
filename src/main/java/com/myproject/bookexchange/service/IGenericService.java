package com.myproject.bookexchange.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.myproject.bookexchange.dao.IGenericDAO;
import com.myproject.bookexchange.domain.DomainObject;

public interface IGenericService<T extends DomainObject> {
  
  public void setDao(IGenericDAO<T> dao);
  public T getById(ObjectId id);
  public long getEntitiesCount();
  public List<T> getAllEntities();
  public T addOrUpdateEntity(T entity);
  public void deleteEntity(T entity);
  
}
