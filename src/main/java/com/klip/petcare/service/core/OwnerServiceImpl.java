package com.klip.petcare.service.core;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.core.OwnerRepository;
import com.klip.petcare.service.base.ServiceException;

import java.util.List;
import java.util.Optional;

public class OwnerServiceImpl implements OwnerService {

    private static OwnerRepository ownerRepository;


    @Override
    public List<OwnerRequestDTO> findAll() throws ServiceException {

        List<OwnerEntity> owners = ownerRepository.findAll();

        return List.of();
    }

    @Override
    public Optional<OwnerRequestDTO> findById(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Long save(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return 0L;
    }

    @Override
    public Long update(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return 0L;
    }

    @Override
    public Long delete(OwnerRequestDTO ownerRequestDTO) throws ServiceException {
        return 0L;
    }
}
