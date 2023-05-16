package com.travelbus.controller;

import com.travelbus.data.entity.Route;
import com.travelbus.dto.dto.RouteDto;
import com.travelbus.service.RouteService;
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
        return routeService.get(id);
    }

    @PostMapping("/routes")
    public @ResponseBody RouteDto post(@RequestBody RouteDto routeDto) {
        return routeService.save(routeDto);
    }

    @DeleteMapping("/routes/{id}")
    public void delete(@PathVariable("id") Long id){
        routeService.delete(id);
    }

    @PatchMapping("/routes/{id}")
    public @ResponseBody RouteDto update(@RequestBody RouteDto routeDto){
        return routeService.save(routeDto);
    }


    @GetMapping("/routes/find")
    public Route getByStartAndFinish(@RequestParam("startId") Long startId, @RequestParam("finishId") Long finishId){
        return routeService.getByStartAndFinish(startId, finishId);
    }

}
