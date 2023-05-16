package com.travelbus.service;

import com.travelbus.data.entity.Route;
import com.travelbus.dto.dto.RouteDto;

import java.util.List;


public interface RouteService extends BaseService<RouteDto, Route> {
    @Override
    List<RouteDto> getAll();

    Route getByStartAndFinish(Long starId, Long finishId);

}
