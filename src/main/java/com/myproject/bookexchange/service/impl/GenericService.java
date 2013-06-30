package com.myproject.bookexchange.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;

import com.myproject.bookexchange.dao.IGenericDAO;
import com.myproject.bookexchange.domain.DomainObject;
import com.myproject.bookexchange.service.IGenericService;

public abstract class GenericService<T extends DomainObject> implements IGenericService<T> {
  
  protected IGenericDAO<T> dao;
  protected Log log = LogFactory.getLog(getClass());
  
  public T getById(ObjectId id) {
    return dao.getEntityById(id);
  }
  public long getEntitiesCount() {
    return dao.countEntities();
  }
  public List<T> getAllEntities() {
    return dao.getAllEntities();
  }
  
  public T addOrUpdateEntity(T entity) {
    return dao.addOrUpdateEntity(entity);
  }
  
  public void deleteEntity(T entity) {
    dao.deleteEntity(entity);
  }
  
  public void setDao(IGenericDAO<T> dao) {
    this.dao = dao;
  }
}
