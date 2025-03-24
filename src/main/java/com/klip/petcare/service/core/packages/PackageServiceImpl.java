package com.klip.petcare.service.core.packages;

import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.response.PackageResponseDTO;
import com.klip.petcare.repository.jpa.core.PackageRepository;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.mapper.packages.PackagesRequestMapper;
import com.klip.petcare.service.mapper.packages.PackagesResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final PackagesRequestMapper packagesRequestMapper;
    private final PackagesResponseMapper packagesResponseMapper;

    @Override
    public List<PackageResponseDTO> findAll() {
        return packageRepository.findAll()
                .stream()
                .map(packagesResponseMapper::toDTO).toList();
    }

    @Override
    public PackageResponseDTO findById(Integer id) throws ServiceException, NotContentException {
        return packageRepository.findById(id)
                .map(packagesResponseMapper::toDTO)
                .orElseThrow( () -> new NotContentException("Package not found with id: " + id));
    }

    @Override
    public Integer save(PackageResponseDTO packageResponseDTO) throws ServiceException, NotContentException {
        return 0;
    }

    @Override
    public PackageResponseDTO update(PackageResponseDTO packageResponseDTO, Integer id) throws ServiceException {
        return null;
    }
}
