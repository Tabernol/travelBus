package com.travelbus.service.impl;

import com.travelbus.data.entity.*;
import com.travelbus.dto.post.TicketPostDto;
import com.travelbus.entity.*;
import com.travelbus.repo.BusRepo;
import com.travelbus.repo.RaceRepo;
import com.travelbus.repo.TicketRepo;
import com.travelbus.service.HolderTicketsService;
import com.travelbus.service.RaceService;
import com.travelbus.service.TicketService;
import com.travelbus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RaceServiceImpl implements RaceService {
    private final RaceRepo raceRepo;
    private final HolderTicketsService holderTicketsService;
    private final BusRepo busRepo;

    private final TicketService ticketService;

    private final UserService userService;


    public RaceServiceImpl(RaceRepo raceRepo, HolderTicketsService holderTicketsService, BusRepo busRepo, TicketRepo ticketRepo, TicketService ticketService, UserService userService) {
        this.raceRepo = raceRepo;
        this.holderTicketsService = holderTicketsService;
        this.busRepo = busRepo;
        this.ticketService = ticketService;
        this.userService = userService;
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

        race.setHolderTickets(holderTicketsService.createOrderedTickets(bus));
        race.setBus(bus);

        race = raceRepo.save(race);
        return race;
    }

    @Override
    public Race removeBusFromRace(Long raceId) {
        Race race = raceRepo.findById(raceId).orElseThrow();

        Long orderTicketsId = race.getHolderTickets().getId();

        // ===============================================================
        // CHECK FOR WAS ORDERED OR BOUGHT TICKETS
        if (holderTicketsService.canDeleteOrderedTickets(orderTicketsId)) {
            race.setBus(null);
            race.setHolderTickets(null);
            race = raceRepo.save(race);
            holderTicketsService.delete(orderTicketsId);
        } else throw new IllegalArgumentException("Tickets were bought or ordered");

        return race;
    }

    public Race setPrice(Long raceId, BigDecimal price) {
        Race race = get(raceId);
        race.getHolderTickets().setPrice(price);
        return save(race);
    }


    public Race orderedTickets(TicketPostDto ticketPostDto) {
        Race race = get(ticketPostDto.getRaceId());
        HolderTickets holderTickets = race.getHolderTickets();
        Integer freeTickets = holderTickets.getFreeTickets();

        if (freeTickets >= ticketPostDto.getCountOfTickets()) {
            holderTickets.setFreeTickets(freeTickets - ticketPostDto.getCountOfTickets());
            holderTickets.setOrderTickets(holderTickets.getOrderTickets() + ticketPostDto.getCountOfTickets());
            race.setHolderTickets(holderTickets);
            //insert to tickets

            for (Ticket ticket : createTicket(ticketPostDto)) {
                ticketService.save(ticket);
            }

            return save(race);
        }
        return race;

    }

    private List<Ticket> createTicket(TicketPostDto ticketPostDto) {
        Race race = get(ticketPostDto.getRaceId());
        HolderTickets holderTickets = race.getHolderTickets();
        User user = userService.get(ticketPostDto.getLogin());


        int countOfTickets = ticketPostDto.getCountOfTickets();
        List<Ticket> ticketList = new ArrayList<>();

        Ticket ticket;
        for (int i = 0; i < countOfTickets; i++) {
            ticket = new Ticket();
            ticket.setStatus(Status.ORDERED);
            ticket.setPrice(holderTickets.getPrice());
            ticket.setTimeOperation(LocalDateTime.now());
            ticket.setHolderTickets(holderTickets);

            // take user
            ticket.setUser(user);
            ticketList.add(ticket);

        }

        return ticketList;


    }

}
