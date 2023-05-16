package com.travelbus.service.impl;

import com.travelbus.data.entity.Race;
import com.travelbus.dto.dto.RaceDto;
import com.travelbus.repo.RaceRepo;
import com.travelbus.service.DtoService;
import com.travelbus.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class RaceServiceImpl implements RaceService, DtoService<RaceDto, Race> {
    private RaceRepo raceRepo;

    public RaceServiceImpl(RaceRepo raceRepo) {
        this.raceRepo = raceRepo;
    }

    @Override
    public RaceDto get(Long id) {
        return toDto(raceRepo.findById(id).orElse(new Race()));
    }

    @Override
    public RaceDto save(RaceDto raceDto) {
        return toDto(raceRepo.save(toEntity(raceDto)));
    }

    @Override
    public void delete(Long id) {
        raceRepo.deleteById(id);
    }

    @Override
    public List<RaceDto> getAll() {
        return toDto(raceRepo.findAll());
    }

    @Override
    public RaceDto toDto(Race race) {
        RaceDto raceDto = new RaceDto();
        raceDto.setId(race.getId());
        raceDto.setName(race.getName());
        raceDto.setTimeStart(race.getTimeStart());
        raceDto.setTimeFinish(race.getTimeFinish());
        raceDto.setBus(race.getBus());
        raceDto.setRoute(race.getRoute());
        raceDto.setOrderedTickets(race.getOrderedTickets());
        int size = race.getOrderedTickets().getTicketList().size();
        log.info("size= " +size);
        return raceDto;
    }

    @Override
    public List<RaceDto> toDto(Iterable<Race> races) {
        List<RaceDto> raceDtoList = new ArrayList<>();
        for (Race race : races) {
            raceDtoList.add(toDto(race));
        }
        return raceDtoList;
    }

    @Override
    public Race toEntity(RaceDto raceDto) {
        Race race = new Race();
        race.setId(raceDto.getId());
        race.setName(raceDto.getName());
        race.setTimeStart(raceDto.getTimeStart());
        race.setTimeFinish(raceDto.getTimeFinish());
        race.setBus(raceDto.getBus());
        race.setRoute(raceDto.getRoute());
        return race;
    }
}
