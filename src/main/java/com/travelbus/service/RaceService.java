package com.travelbus.service;

import com.travelbus.data.entity.Race;
import com.travelbus.dto.dto.DtoForCreateRace;
import com.travelbus.dto.dto.RaceDto;

import java.util.List;

public interface RaceService extends BaseService<Race> {
    @Override
    List<Race> getAll();

//    boolean createRace(DtoForCreateRace dtoForCreateRace);
//
//    RaceDto updateRace(RaceDto raceDto);
}
