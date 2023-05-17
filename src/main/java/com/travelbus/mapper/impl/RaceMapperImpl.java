package com.travelbus.mapper.impl;

import com.travelbus.data.entity.Race;
import com.travelbus.dto.get.RaceGetDto;
import com.travelbus.dto.post.RacePostDto;
import com.travelbus.mapper.RaceMapper;
import com.travelbus.service.BusService;
import com.travelbus.service.OrderedTicketsService;
import com.travelbus.service.RouteService;
import org.springframework.stereotype.Component;

@Component
public class RaceMapperImpl implements RaceMapper {
    private final RouteService routeService;
    private final BusService busService;
    private final OrderedTicketsService orderedTicketsService;

    public RaceMapperImpl(RouteService routeService,
                          BusService busService,
                          OrderedTicketsService orderedTicketsService) {
        this.routeService = routeService;
        this.busService = busService;
        this.orderedTicketsService = orderedTicketsService;
    }

    @Override
    public Race racePostDtoToRace(RacePostDto racePostDto) {
        Race race = new Race();
        race.setName(racePostDto.getRaceName());
        race.setTimeStart(racePostDto.getTimeStart());
        race.setTimeFinish(racePostDto.getTimeFinish());
        race.setRoute(routeService.get(racePostDto.getRouteId()));
        return race;
    }

    @Override
    public RaceGetDto raceToRaceGetDto(Race race) {
        RaceGetDto raceGetDto = new RaceGetDto();
        raceGetDto.setId(race.getId());
        raceGetDto.setName(race.getName());
        raceGetDto.setTimeStart(race.getTimeStart());
        raceGetDto.setTimeFinish(race.getTimeFinish());
        raceGetDto.setBus(race.getBus());
        raceGetDto.setRoute(race.getRoute());
        raceGetDto.setOrderedTickets(race.getOrderedTickets());
        return raceGetDto;
    }
}
