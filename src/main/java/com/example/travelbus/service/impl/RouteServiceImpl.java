package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.Route;
import com.example.travelbus.repo.RouteRepo;
import com.example.travelbus.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepo routeRepo;

    public RouteServiceImpl(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }

    @Override
    public List<Route> getAll() {
        return routeRepo.findAll();
    }

    @Override
    public void addRoute(Route route) {
        routeRepo.save(route);
    }

    @Override
    public void deleteRoute(Long id) {
        routeRepo.deleteById(id);
    }
}
