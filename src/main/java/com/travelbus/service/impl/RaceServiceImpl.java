package com.travelbus.service.impl;

import com.travelbus.data.entity.Bus;
import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.data.entity.Race;
import com.travelbus.repo.BusRepo;
import com.travelbus.repo.RaceRepo;
import com.travelbus.service.OrderedTicketsService;
import com.travelbus.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RaceServiceImpl implements RaceService {
    private final RaceRepo raceRepo;
    private final OrderedTicketsService orderedTicketsService;
    private final BusRepo busRepo;


    public RaceServiceImpl(RaceRepo raceRepo, OrderedTicketsService orderedTicketsService, BusRepo busRepo) {
        this.raceRepo = raceRepo;
        this.orderedTicketsService = orderedTicketsService;
        this.busRepo = busRepo;
    }


    @Override
    public Race get(Long id) {
        return raceRepo.findById(id).orElseThrow();
    }

    @Override
    public Race save(Race race) {
        return raceRepo.save(race);
    }

    @Override
    public void delete(Long id) {
        raceRepo.deleteById(id);
    }

    @Override
    public List<Race> getAll() {
        List<Race> races = new ArrayList<>();
        raceRepo.findAll().forEach(race -> races.add(race));
        return races;
    }

    @Override
    public Race addBusToRace(Long raceId, Long busId) {
        Race race = raceRepo.findById(raceId).orElseThrow();
        Bus bus = busRepo.findById(busId).orElseThrow();

        race.setOrderedTickets(orderedTicketsService.createOrderedTickets(bus));
        race.setBus(bus);

        race = raceRepo.save(race);
        return race;
    }

    @Override
    public Race removeBusFromRace(Long raceId) {
        Race race = raceRepo.findById(raceId).orElseThrow();

        Long orderTicketsId = race.getOrderedTickets().getId();

        // ===============================================================
        // CHECK FOR WAS ORDERED OR BOUGHT TICKETS
        if (orderedTicketsService.canDeleteOrderedTickets(orderTicketsId)) {
            race.setBus(null);
            race.setOrderedTickets(null);
            race = raceRepo.save(race);
            orderedTicketsService.delete(orderTicketsId);
        } else throw new IllegalArgumentException("Tickets were bought or ordered");

        return race;
    }


}
