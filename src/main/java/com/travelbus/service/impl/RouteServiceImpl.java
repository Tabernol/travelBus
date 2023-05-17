package com.travelbus.service.impl;

import com.travelbus.data.entity.Route;
import com.travelbus.dto.post.RouteDto;
import com.travelbus.repo.CityRepo;
import com.travelbus.repo.RouteRepo;
import com.travelbus.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService {

    private final RouteRepo routeRepo;
    private final CityRepo cityRepo;

    public RouteServiceImpl(RouteRepo routeRepo, CityRepo cityRepo) {
        this.routeRepo = routeRepo;
        this.cityRepo = cityRepo;
    }

    @Override
    public Route get(Long id) {
        return routeRepo.findById(id).orElseThrow();
    }

    @Override
    public Route save(Route route) {
        return routeRepo.save(route);
    }

    @Override
    public void delete(Long id) {
        routeRepo.deleteById(id);
    }

    @Override
    public List<Route> getAll() {
        List<Route> routes = new ArrayList<>();
        routeRepo.findAll().forEach(route-> routes.add(route));
        return routes;
    }

    @Override
    public Route getByStartAndFinish(Long starId, Long finishId) {
       return routeRepo.getRouteByStartPointAndFinishPoint(cityRepo.findById(starId).get(),
                cityRepo.findById(finishId).get());
    }
}
