package com.travelbus.service;

import com.travelbus.entity.Race;
import com.travelbus.dto.post.TicketPostDto;

import java.math.BigDecimal;
import java.util.List;

public interface RaceService extends BaseService<Race> {
    @Override
    List<Race> getAll();

//    boolean createRace(DtoForCreateRace dtoForCreateRace);
//
//    RaceDto updateRace(RaceDto raceDto);

    Race addBusToRace(Long raceId, Long busId);

    Race removeBusFromRace(Long raceId);

    Race setPrice(Long raceId, BigDecimal price);

    Race orderedTickets(TicketPostDto ticketPostDto);
}
