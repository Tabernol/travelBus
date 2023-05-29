package com.travelbus.service;

import com.travelbus.entity.Route;

import java.util.List;


public interface RouteService extends BaseService<Route> {
    @Override
    List<Route> getAll();

    Route getByStartAndFinish(Long starId, Long finishId);

}
