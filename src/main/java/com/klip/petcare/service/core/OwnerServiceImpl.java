package com.klip.petcare.service.core;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.core.OwnerRepository;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.mapper.OwnerMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OwnerServiceImpl implements OwnerService {

    private static OwnerRepository ownerRepository;
    private static OwnerMapper ownerMapper;


    @Override
    public List<OwnerRequestDTO> findAll() throws ServiceException {

        return ownerRepository.findAll().stream().map(ownerMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public OwnerRequestDTO findById(Integer id) throws ServiceException {

        return ownerMapper.toDto(ownerRepository.findById(id).orElse(null));
    }

    @Override
    public Integer save(OwnerRequestDTO ownerRequestDTO) throws ServiceException {

        OwnerEntity owner = ownerRepository.save(ownerMapper.toEntity(ownerRequestDTO));

        return owner.getId();
    }

    @Override
    public Integer update(OwnerRequestDTO ownerRequestDTO, Integer id) throws ServiceException {

        OwnerEntity ownerUpdated = ownerRepository.save(ownerMapper.toEntity(ownerRequestDTO));

        return ownerUpdated.getId();
    }

}
