package com.klip.petcare.service.base;

import com.klip.petcare.controller.exceptions.NotContentException;

import java.util.List;

public interface GenericService<T, R, U> {

    List<U> findAll() throws ServiceException;

    U findById(Integer id) throws ServiceException, NotContentException;

    R save(T t) throws ServiceException, NotContentException;

    U update(T t, R id) throws ServiceException;

}
