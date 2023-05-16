package com.travelbus.controller;

import com.travelbus.dto.dto.RaceDto;
import com.travelbus.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }
    @GetMapping("/races/{id}")
    public RaceDto get(@PathVariable(value = "id") Long id){
        log.info(raceService.get(id).toString());
        return raceService.get(id);
    }
}
