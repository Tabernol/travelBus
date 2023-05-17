package com.travelbus.service;

import com.travelbus.data.entity.Route;
import com.travelbus.dto.post.RouteDto;

import java.util.List;


public interface RouteService extends BaseService<Route> {
    @Override
    List<Route> getAll();

    Route getByStartAndFinish(Long starId, Long finishId);

}
