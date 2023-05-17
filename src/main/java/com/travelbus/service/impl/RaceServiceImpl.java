package com.travelbus.service.impl;

import com.travelbus.data.entity.Bus;
import com.travelbus.data.entity.Race;
import com.travelbus.data.entity.Route;
import com.travelbus.dto.dto.DtoForCreateRace;
import com.travelbus.dto.dto.RaceDto;
import com.travelbus.repo.BusRepo;
import com.travelbus.repo.RaceRepo;
import com.travelbus.repo.RouteRepo;
import com.travelbus.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RaceServiceImpl implements RaceService{
    private final RaceRepo raceRepo;
    private final RouteRepo routeRepo;
    private final BusRepo busRepo;


    public RaceServiceImpl(RaceRepo raceRepo, RouteRepo routeRepo, BusRepo busRepo) {
        this.raceRepo = raceRepo;
        this.routeRepo = routeRepo;
        this.busRepo = busRepo;
    }


    @Override
    public Race get(Long id) {
        return null;
    }

    @Override
    public Race save(Race race) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Race> getAll() {
        return null;
    }
}
