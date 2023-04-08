package com.example.travelbus.service;

import com.example.travelbus.data.entity.Route;

import java.util.List;
import java.util.Optional;


public interface RouteService {

    Iterable<Route> getAll();

    void addRoute(Route route);

    void deleteRoute(Long id);

    Optional<Route> getRoute(Long id);
}
