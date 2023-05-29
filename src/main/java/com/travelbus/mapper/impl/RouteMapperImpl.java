package com.travelbus.mapper.impl;

import com.travelbus.entity.Route;
import com.travelbus.dto.post.RouteDto;
import com.travelbus.mapper.RouteMapper;
import com.travelbus.service.CityService;
import org.springframework.stereotype.Component;

@Component
public class RouteMapperImpl implements RouteMapper {
    private final CityService cityService;

    public RouteMapperImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public Route routeDtoToRoute(RouteDto routeDto) {
        Route route = new Route();
        route.setRouteName(routeDto.getRouteName());
        route.setStartPoint(cityService.get(routeDto.getStartPointId()));
        route.setFinishPoint(cityService.get(routeDto.getFinishPointId()));
        return route;
    }
}
