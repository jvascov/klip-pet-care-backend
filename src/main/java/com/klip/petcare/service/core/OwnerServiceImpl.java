package com.klip.petcare.service.core;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.core.OwnerRepository;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.mapper.OwnerMapper;

import java.util.List;
import java.util.Optional;

public class OwnerServiceImpl implements OwnerService {

    private static OwnerRepository ownerRepository;
    private static OwnerMapper ownerMapper;


    @Override
    public List<OwnerRequestDTO> findAll() throws ServiceException {



        return List.of();
    }

    @Override
    public Optional<OwnerRequestDTO> findById(Integer id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Integer save(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return null;
    }

    @Override
    public Integer update(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return null;
    }

    @Override
    public Integer delete(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return null;
    }
}
