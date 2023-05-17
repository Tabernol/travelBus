package com.travelbus.service;

import com.travelbus.data.entity.Race;

import java.util.List;

public interface RaceService extends BaseService<Race> {
    @Override
    List<Race> getAll();

//    boolean createRace(DtoForCreateRace dtoForCreateRace);
//
//    RaceDto updateRace(RaceDto raceDto);

    Race addBusToRace(Long raceId, Long busId);

    Race removeBusFromRace(Long raceId);
}
