package com.klip.petcare.service.base;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, R> {

    List<T> findAll() throws ServiceException;

    Optional<T> findById(R r) throws ServiceException;

    R save(T t) throws ServiceException;

    R update(T t) throws ServiceException;

    R delete(T t) throws ServiceException;
}
