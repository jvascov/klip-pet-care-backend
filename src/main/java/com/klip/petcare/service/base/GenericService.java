package com.klip.petcare.service.base;

import java.util.List;

public interface GenericService<T, R, U> {

    List<U> findAll() throws ServiceException;

    U findById(R id) throws ServiceException;

    R save(T t) throws ServiceException;

    R update(T t, R id) throws ServiceException;

}
