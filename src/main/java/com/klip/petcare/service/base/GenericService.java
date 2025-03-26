package com.klip.petcare.service.base;

import com.klip.petcare.controller.exceptions.NotContentException;

import java.util.List;

public interface GenericService<T, R> {

    List<R> findAll() throws ServiceException;

    R findById(Integer id) throws ServiceException, NotContentException;

    R save(T t) throws ServiceException, NotContentException;

    R update(Integer id, T t) throws ServiceException;

}
