package com.klip.petcare.service.core;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.core.OwnerRepository;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.mapper.OwnerRequestMapper;
import com.klip.petcare.service.mapper.OwnerResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {


    private final OwnerRepository ownerRepository;
    private final OwnerRequestMapper ownerRequestMapper;
    private final OwnerResponseMapper ownerResponseMapper;


    @Override
    public List<OwnerResponseDTO> findAll() throws ServiceException {

        return ownerRepository.findAll().stream().map(ownerResponseMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public OwnerResponseDTO findById(Integer id) throws ServiceException {

        return ownerResponseMapper.toDto(ownerRepository.findById(id).orElse(null));
    }

    @Override
    public Integer save(OwnerRequestDTO ownerRequestDTO) throws ServiceException {

        OwnerEntity owner = ownerRepository.save(ownerRequestMapper.toEntity(ownerRequestDTO));

        return owner.getId();
    }

    @Override
    public Integer update(OwnerRequestDTO ownerRequestDTO, Integer id) throws ServiceException {

        OwnerEntity ownerUpdated = ownerRepository.save(ownerRequestMapper.toEntity(ownerRequestDTO));

        return ownerUpdated.getId();
    }

}

