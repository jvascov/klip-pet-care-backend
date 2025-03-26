package com.klip.petcare.service.core.daycare;

import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.DaycareRequestDTO;
import com.klip.petcare.dto.response.DaycareResponseDTO;
import com.klip.petcare.dto.response.PetResponseDTO;
import com.klip.petcare.entity.core.DaycareEntity;
import com.klip.petcare.entity.core.PackageEntity;
import com.klip.petcare.entity.core.PetEntity;
import com.klip.petcare.repository.jpa.core.DaycareRepository;
import com.klip.petcare.repository.jpa.core.PackageRepository;
import com.klip.petcare.repository.jpa.core.PetRepository;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.mapper.daycare.DaycareRequestMapper;
import com.klip.petcare.service.mapper.daycare.DaycareResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.klip.petcare.service.enums.Status.IN_PROGRESS;
import static com.klip.petcare.service.enums.Status.OPEN;


@Service
@AllArgsConstructor
public class DaycareServiceImpl implements DaycareService {

    private final DaycareRepository daycareRepository;
    private final DaycareResponseMapper daycareResponseMapper;
    private final DaycareRequestMapper daycareRequestMapper;
    private final PackageRepository packageRepository;
    private final PetRepository petRepository;

    @Override
    public List<DaycareResponseDTO> findAll() throws ServiceException {
        return daycareRepository.findAll()
                .stream()
                .map(
                        daycareResponseMapper::toDTO
                ).toList();

    }

    @Override
    public DaycareResponseDTO findById(Integer id) throws ServiceException {
        return daycareResponseMapper.toDTO(daycareRepository.findById(id).orElseThrow(() -> new ServiceException("Not daycare found, Id: " + id)));
    }

    @Override
    public DaycareResponseDTO save(DaycareRequestDTO daycareRequestDTO) throws ServiceException, NotContentException {

        Optional<DaycareEntity> optionalDaycare = daycareRepository.findActiveDaycare(daycareRequestDTO.getPet());

        if (optionalDaycare.isPresent()) {
            DaycareEntity daycareEntity = optionalDaycare.get();

            if(IN_PROGRESS.toString().equals(daycareEntity.getStatus()) || OPEN.toString().equals(daycareEntity.getStatus())){
                    throw new RuntimeException("The pet already has an active daycare.");
            }
        }

        PackageEntity packages = packageRepository.findById(daycareRequestDTO.getPackages()).orElseThrow(() -> new NotContentException("Package not found"));

        PetEntity petTemp = petRepository.findPetById(daycareRequestDTO.getPet()).orElseThrow(() -> new NotContentException("Pet not found"));

        DaycareEntity daycare = daycareRequestMapper.toEntity(daycareRequestDTO);

        daycare.setPackages(packages);
        daycare.setPet(petTemp);
        daycare.setLeftHours(packages.getHours());
        daycare.setStatus(IN_PROGRESS.toString());
        daycare.setAdditionalHours(0.0);

        return daycareResponseMapper.toDTO(daycareRepository.save(daycare));
    }

    @Override
    public DaycareResponseDTO update(Integer id, DaycareRequestDTO daycareRequestDTO) throws ServiceException {

        //DaycareEntity existingDaycare = daycareRequestMapper.toEntity(daycareRequestDTO);




        return null;
    }
}
