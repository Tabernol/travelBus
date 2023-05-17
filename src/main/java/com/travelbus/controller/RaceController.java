package com.travelbus.controller;

import com.travelbus.data.entity.Race;
import com.travelbus.dto.get.RaceGetDto;
import com.travelbus.dto.post.RacePostDto;
import com.travelbus.mapper.RaceMapper;
import com.travelbus.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RaceController {
    private final RaceService raceService;
    private final RaceMapper raceMapper;

    public RaceController(RaceService raceService, RaceMapper raceMapper) {
        this.raceService = raceService;
        this.raceMapper = raceMapper;
    }

    @GetMapping("/races/{id}")
    public RaceGetDto get(@PathVariable(value = "id") Long id) {
        return raceMapper.raceToRaceGetDto(raceService.get(id));
    }

    @PostMapping("/races")
    public ResponseEntity<RaceGetDto> createRace(@RequestBody RacePostDto racePostDto) {
        Race race = raceMapper.racePostDtoToRace(racePostDto);
        Race savedRace = raceService.save(race);
        RaceGetDto raceDto = raceMapper.raceToRaceGetDto(savedRace);
        return new ResponseEntity<>(raceDto, HttpStatus.CREATED);
    }

    @PatchMapping("/races/{id}")
    public ResponseEntity<RaceGetDto> addBusToRace(@RequestBody RacePostDto racePostDto) {
        Race race = raceService.save(raceMapper.racePostDtoToRace(racePostDto));
        return new ResponseEntity<>(raceMapper.raceToRaceGetDto(race), HttpStatus.OK);
    }

    @DeleteMapping("/races/{id}")
    public void deleteRace(@PathVariable(name = "id") Long id) {
        raceService.delete(id);
    }

    @PatchMapping("/races/{raceId}/{busId}")
    public ResponseEntity<RaceGetDto> addBusToRace(@PathVariable(name = "raceId") Long raceId,
                                                   @PathVariable(name = "busId") Long busId) {
        Race race = raceService.addBusToRace(raceId, busId);
        return new ResponseEntity<>(raceMapper.raceToRaceGetDto(race), HttpStatus.OK);
    }

    @DeleteMapping("/races/bus/{raceId}")
    public ResponseEntity<RaceGetDto> removeBusFromRace(@PathVariable(name = "raceId") Long raceId) {
        Race race = raceService.removeBusFromRace(raceId);
        return new ResponseEntity<>(raceMapper.raceToRaceGetDto(race), HttpStatus.OK);
    }


}
