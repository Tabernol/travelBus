package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.Route;
import com.example.travelbus.dto.DtoService;
import com.example.travelbus.dto.dto.RouteDto;
import com.example.travelbus.repo.RouteRepo;
import com.example.travelbus.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService, DtoService<RouteDto, Route> {

    private final RouteRepo routeRepo;

    public RouteServiceImpl(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }


    @Override
    public List<RouteDto> getAll() {
        List<RouteDto> all = new ArrayList<>();
        routeRepo.findAll().forEach(route -> all.add(toDto(route)));
        return all;
    }

    @Override
    public RouteDto saveRoute(RouteDto routeDto) {
        return toDto(routeRepo.save(toEntity(routeDto)));
    }

    @Override
    public void deleteRoute(Long id) {

        routeRepo.deleteById(id);
    }

    @Override
    public RouteDto getRoute(Long id) {
        log.info(routeRepo.findById(id).get().toString());
        return toDto(routeRepo.findById(id).orElse(new Route()));
    }

    @Override
    public RouteDto toDto(Route route) {
        RouteDto routeDto = new RouteDto();
        if (route != null) {
            routeDto.setId(route.getId());
            routeDto.setRouteName(route.getRouteName());
            routeDto.setStartPoint(route.getStartPoint());
            routeDto.setFinishPoint(route.getFinishPoint());
            return routeDto;
        }
        return routeDto;
    }

    @Override
    public List<RouteDto> toDto(Iterable<Route> routes) {
        List<RouteDto> routeDtoList = new ArrayList<>();
        RouteDto routeDto;
        for (Route route : routes) {
            routeDto = new RouteDto();
            routeDto.setId(route.getId());
            routeDto.setRouteName(route.getRouteName());
            routeDto.setStartPoint(route.getStartPoint());
            routeDto.setFinishPoint(route.getFinishPoint());
            routeDtoList.add(routeDto);
        }
        return routeDtoList;
    }

    @Override
    public Route toEntity(RouteDto routeDto) {
        Route route = new Route();
        route.setId(routeDto.getId());
        route.setRouteName(routeDto.getRouteName());
        route.setStartPoint(routeDto.getStartPoint());
        route.setFinishPoint(routeDto.getFinishPoint());
        return route;
    }
}
