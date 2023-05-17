package com.travelbus.controller;

import com.travelbus.data.entity.Route;
import com.travelbus.dto.post.RouteDto;
import com.travelbus.mapper.RouteMapper;
import com.travelbus.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class RouteController {
    private final RouteService routeService;
    private final RouteMapper routeMapper;

    public RouteController(RouteService routeService, RouteMapper routeMapper) {
        this.routeService = routeService;
        this.routeMapper = routeMapper;
    }

    @GetMapping("/routes")
    public ResponseEntity<List<Route>> getAll() {
        return new ResponseEntity<>(routeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/routes/{id}")
    public ResponseEntity<Route> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(routeService.get(id), HttpStatus.OK);
    }

    @PostMapping("/routes")
    public ResponseEntity<Route> post(@RequestBody RouteDto routeDto) {
        return new ResponseEntity<>(routeService.save(routeMapper.routeDtoToRoute(routeDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/routes/{id}")
    public void delete(@PathVariable("id") Long id) {
        routeService.delete(id);
    }

    @PatchMapping("/routes/{id}")
    public ResponseEntity<Route> update(@RequestBody Route route) {
        return new ResponseEntity<>(routeService.save(route), HttpStatus.OK);
    }


    @GetMapping("/routes/find")
    public ResponseEntity<Route> getByStartAndFinish(
            @RequestParam("startId") Long startId,
            @RequestParam("finishId") Long finishId) {
        return
                new ResponseEntity<>(routeService.getByStartAndFinish(startId, finishId), HttpStatus.OK);
    }

}
