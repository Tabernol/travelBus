package com.travelbus.controller.race;

import com.travelbus.dto.get.RaceGetDto;
import com.travelbus.entity.Race;
import com.travelbus.mapper.RaceMapper;
import com.travelbus.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/races/{raceId}")
public class RaceBusController {

    private final RaceService raceService;
    private final RaceMapper raceMapper;

    public RaceBusController(RaceService raceService, RaceMapper raceMapper) {
        this.raceService = raceService;
        this.raceMapper = raceMapper;
    }

    @PatchMapping("/bus/{busId}")
    public ResponseEntity<RaceGetDto> addBusToRace(@PathVariable(name = "raceId") Long raceId,
                                                   @PathVariable(name = "busId") Long busId) {
        Race race = raceService.addBusToRace(raceId, busId);
        return new ResponseEntity<>(raceMapper.raceToRaceGetDto(race), HttpStatus.OK);
    }

    @DeleteMapping("/bus")
    public ResponseEntity<RaceGetDto> removeBusFromRace(@PathVariable(name = "raceId") Long raceId) {
        Race race = raceService.removeBusFromRace(raceId);
        return new ResponseEntity<>(raceMapper.raceToRaceGetDto(race), HttpStatus.OK);
    }
}
