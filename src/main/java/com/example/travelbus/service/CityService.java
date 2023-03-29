package com.example.travelbus.service;

import com.example.travelbus.data.entity.City;

import java.util.List;

public interface CityService {

    List<City> getAll();

    void addCity(City city);

    void deleteCity(Long id);
}
