package com.travelbus.controller;

import com.travelbus.data.entity.Bus;
import com.travelbus.service.BusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Bus>> getAll() {
        log.info(busService.getAll().toString());
        return new ResponseEntity<>(busService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/buses/{id}")
    public ResponseEntity<Bus> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(busService.get(id), HttpStatus.OK);
    }

    @PostMapping("/buses")
    public ResponseEntity<Bus> save(@RequestBody Bus bus) {
        return new ResponseEntity<>(busService.save(bus), HttpStatus.CREATED);
    }

    @DeleteMapping("/buses/{id}")
    public void delete(@PathVariable Long id) {
        busService.delete(id);
    }
}
