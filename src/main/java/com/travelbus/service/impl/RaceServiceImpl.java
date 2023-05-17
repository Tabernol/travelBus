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
        return null;
    }

    @Override
    public Race addBusToRace(Long raceId, Long busId) {
        Race race = raceRepo.findById(raceId).orElseThrow();
        Bus bus = busRepo.findById(busId).orElseThrow();

        race.setOrderedTickets(createOrderedTickets(race, bus));
        race.setBus(bus);

        race = raceRepo.save(race);
        return race;
    }

    @Override
    public Race removeBusFromRace(Long raceId) {
        Race race = raceRepo.findById(raceId).orElseThrow();

        Long orderTicketsId = race.getOrderedTickets().getId();

        race.setBus(null);
        race.setOrderedTickets(null);
        race = raceRepo.save(race);

        orderedTicketsService.delete(orderTicketsId);

        return race;
    }


    private OrderedTickets createOrderedTickets(Race race, Bus bus) {
        OrderedTickets orderedTickets = new OrderedTickets();
        orderedTickets.setCapacitySeats(bus.getCapacitySeats());
        orderedTickets.setFreeTickets(bus.getCapacitySeats());
        orderedTickets.setOrderTickets(0);
        orderedTickets.setBoughtTickets(0);
        return orderedTicketsService.save(orderedTickets);
    }
}
