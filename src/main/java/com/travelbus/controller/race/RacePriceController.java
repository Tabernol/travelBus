package com.travelbus.controller.race;

import com.travelbus.dto.dto.HolderTicketsDto;
import com.travelbus.dto.get.RaceGetDto;
import com.travelbus.entity.Race;
import com.travelbus.mapper.RaceMapper;
import com.travelbus.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/races/{raceId}")
public class RacePriceController {
    private final RaceService raceService;
    private final RaceMapper raceMapper;

    public RacePriceController(RaceService raceService, RaceMapper raceMapper) {
        this.raceService = raceService;
        this.raceMapper = raceMapper;
    }

    @PatchMapping("/price/{price}")
    public ResponseEntity<RaceGetDto> setPrice(@PathVariable(name = "raceId") Long raceId,
                                               @PathVariable(name = "price") BigDecimal price) {
        Race race = raceService.setPrice(raceId, price);
        return new ResponseEntity<>(raceMapper.raceToRaceGetDto(race), HttpStatus.OK);
    }
}
