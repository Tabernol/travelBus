package com.travelbus.mapper;

import com.travelbus.entity.Race;
import com.travelbus.dto.get.RaceGetDto;
import com.travelbus.dto.post.RacePostDto;

public interface RaceMapper {
    Race racePostDtoToRace(RacePostDto racePostDto);
    RaceGetDto raceToRaceGetDto(Race race);
}
