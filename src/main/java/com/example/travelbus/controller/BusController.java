package com.example.travelbus.controller;

import com.example.travelbus.dto.dto.BusDto;
import com.example.travelbus.service.BusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BusController {
    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/buses")
    public List<BusDto> getAll() {
        log.info(busService.getAll().toString());
        return busService.getAll();
    }

    @GetMapping("/buses/{id}")
    public BusDto get(@PathVariable(value = "id") Long id) {
        return busService.get(id);
    }

    @PostMapping("/buses")
    public BusDto save(@RequestBody BusDto busDto) {
        return busService.save(busDto);
    }

    @DeleteMapping("/buses/{id}")
    public void delete(@PathVariable Long id) {
        busService.delete(id);
    }
}
