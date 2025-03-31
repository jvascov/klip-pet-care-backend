package com.klip.petcare.service.core.daycare.events;

import com.klip.petcare.controller.exceptions.NotContentException;
import com.klip.petcare.dto.request.EventRequestDTO;
import com.klip.petcare.dto.response.EventResponseDTO;
import com.klip.petcare.entity.core.DaycareEntity;
import com.klip.petcare.entity.core.EventEntity;
import com.klip.petcare.repository.jpa.core.EventRepository;
import com.klip.petcare.repository.jpa.core.DaycareRepository;
import com.klip.petcare.service.base.ServiceException;
import com.klip.petcare.service.mapper.event.EventRequestMapper;
import com.klip.petcare.service.mapper.event.EventResponseMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.klip.petcare.service.enums.Status.IN_PROGRESS;
import static com.klip.petcare.service.enums.Status.DONE;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final DaycareRepository daycareRepository;
    private final EventRequestMapper eventRequestMapper;
    private final EventResponseMapper eventResponseMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Override
    public List<EventResponseDTO> findAll() throws ServiceException {


        List<EventResponseDTO> eventList = eventRepository.findAll()
                .stream()
                .map(eventResponseMapper::toDto).toList();

        if (eventList.isEmpty()) {
            throw new ServiceException("No events found");
        }

        return eventList;
    }

    @Override
    public EventResponseDTO findById(Integer id) throws ServiceException, NotContentException {
        return eventResponseMapper.toDto(eventRepository.findById(id).orElseThrow(()-> new  NotContentException("Event not found")));
    }

    @Override
    public EventResponseDTO save(EventRequestDTO eventRequestDTO) throws ServiceException, NotContentException {

        DaycareEntity daycare = daycareRepository.findById(eventRequestDTO.getDaycare()).orElseThrow(() -> new NotContentException("Daycare not found"));

        eventRepository.findEventEntityByDaycareAndStatus(daycare, IN_PROGRESS.name())
                .ifPresent(
                event -> {
                    throw new ServiceException("Event in progress");
                    }
                );


        EventEntity event = eventRequestMapper.toEntity(eventRequestDTO);

        event.setDaycare(daycare);
        event.setStatus(IN_PROGRESS.name());

        return eventResponseMapper.toDto(eventRepository.save(event));
    }

    @Override
    public EventResponseDTO update(Integer id, EventRequestDTO eventRequestDTO) throws ServiceException {
        return null;
    }

    @Override
    public String updateEvent(Integer id) throws NotContentException, ServiceException {

        EventEntity event = eventResponseMapper.toEntity(this.findById(id));

        if (event.getStatus().equals(DONE.name())) {
            throw new ServiceException("Event closed");
        }

        LocalDateTime endDate = LocalDateTime.now();

        Duration duration = Duration.between(event.getStartDate(), endDate);

        BigDecimal totalHours = BigDecimal.valueOf(duration.toMinutes() / 60.0)
                        .setScale(2, RoundingMode.HALF_UP);

        event.setEndDate(endDate);
        event.setTotalHours(totalHours);
        event.setStatus(DONE.name());

        eventRepository.save(event);

        DaycareEntity daycare = event.getDaycare();

        daycare.setLeftHours(daycare.getLeftHours().subtract(totalHours));

        daycareRepository.save(daycare);

        return "Event updated";
    }
}
