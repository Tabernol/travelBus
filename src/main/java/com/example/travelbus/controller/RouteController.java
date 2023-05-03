package com.example.travelbus.controller;

import com.example.travelbus.data.entity.Route;
import com.example.travelbus.dto.dto.RouteDto;
import com.example.travelbus.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public @ResponseBody List<RouteDto> getAll() {
        return routeService.getAll();
    }

    @GetMapping("/routes/{id}")
    public @ResponseBody RouteDto get(@PathVariable("id") Long id) {
        log.info(id.toString());
        return routeService.getRoute(id);
    }

    @PostMapping("/routes")
    public @ResponseBody RouteDto post(@RequestBody RouteDto routeDto) {
        return routeService.saveRoute(routeDto);
    }

    @DeleteMapping("/routes/{id}")
    public void delete(@PathVariable("id") Long id){
        routeService.deleteRoute(id);
    }

    @PatchMapping("/routes/{id}")
    public @ResponseBody RouteDto update(@RequestBody RouteDto routeDto){
        return routeService.saveRoute(routeDto);
    }

}
