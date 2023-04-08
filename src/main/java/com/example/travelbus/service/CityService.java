package com.example.travelbus.service;

import com.example.travelbus.data.entity.City;

import java.util.Optional;

public interface CityService {

    Iterable<City> getAll();

    Optional<City> getCity(Long id);

    City saveCity(City city);

    void deleteCity(Long id);

    City updateCity(City city);


}
