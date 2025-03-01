package com.klip.petcare.service.base;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, R> {

    List<T> findAll() throws ServiceException;

    T findById(R r) throws ServiceException;

    R save(T t) throws ServiceException;

    R update(T t, R r) throws ServiceException;

}
