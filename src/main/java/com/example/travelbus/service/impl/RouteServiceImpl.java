package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.Route;
import com.example.travelbus.repo.RouteRepo;
import com.example.travelbus.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService {

    private final RouteRepo routeRepo;

    public RouteServiceImpl(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }


    @Override
    public Iterable<Route> getAll() {
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

    @Override
    public Optional<Route> getRoute(Long id) {
        log.info(routeRepo.findById(id).get().toString());
        return routeRepo.findById(id);
    }
}
