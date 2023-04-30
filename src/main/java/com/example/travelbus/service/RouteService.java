package com.example.travelbus.service;

import com.example.travelbus.data.entity.Route;
import com.example.travelbus.dto.dto.RouteDto;

import java.util.List;
import java.util.Optional;


public interface RouteService {

    List<RouteDto> getAll();

    RouteDto saveRoute(RouteDto routeDto);

    void deleteRoute(Long id);

    RouteDto getRoute(Long id);
}
