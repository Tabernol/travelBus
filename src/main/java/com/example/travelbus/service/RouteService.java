package com.example.travelbus.service;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.data.entity.Route;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RouteService {

    List<Route> getAll();

    void addRoute(Route route);

    void deleteRoute(Long id);
}
