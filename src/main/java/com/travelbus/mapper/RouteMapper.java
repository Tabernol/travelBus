package com.travelbus.mapper;

import com.travelbus.entity.Route;
import com.travelbus.dto.post.RouteDto;

public interface RouteMapper {
    Route routeDtoToRoute(RouteDto routeDto);
}
