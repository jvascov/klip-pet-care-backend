package com.klip.petcare.service.core.owner;

import com.klip.petcare.dto.request.OwnerRequestDTO;
import com.klip.petcare.dto.response.OwnerResponseDTO;
import com.klip.petcare.entity.core.OwnerEntity;
import com.klip.petcare.repository.jpa.core.OwnerRepository;
import com.klip.petcare.service.mapper.owner.OwnerRequestMapper;
import com.klip.petcare.service.mapper.owner.OwnerResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.klip.petcare.service.enums.Status.ACTIVE;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {


    private final OwnerRepository ownerRepository;
    private final OwnerRequestMapper ownerRequestMapper;
    private final OwnerResponseMapper ownerResponseMapper;


    @Override
    public List<OwnerResponseDTO> findAll() throws OwnerException {

        return ownerRepository.findAll().stream().map(ownerResponseMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public OwnerResponseDTO findById(Integer id) throws OwnerException {

        return ownerResponseMapper.toDto(ownerRepository.findById(id).orElse(null));
    }

    @Override
    public Integer save(OwnerRequestDTO ownerRequestDTO) throws OwnerException {
        ownerRequestDTO.setStatus(ACTIVE.name());

        OwnerEntity owner = ownerRepository.save(ownerRequestMapper.toEntity(ownerRequestDTO));

        return owner.getId();
    }

    @Override
    public OwnerResponseDTO update(OwnerRequestDTO ownerRequestDTO, Integer id) throws OwnerException {

        return ownerResponseMapper.toDto( ownerRepository.save(ownerRequestMapper.toEntity(ownerRequestDTO)));

    }

}

