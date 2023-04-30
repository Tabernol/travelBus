package com.example.travelbus.service;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.dto.dto.CityDto;

import java.util.Optional;

public interface CityService {

    Iterable<CityDto> getAll();

    CityDto getCity(Long id);

    CityDto saveCity(CityDto cityDto);

    void deleteCity(Long id);
}
