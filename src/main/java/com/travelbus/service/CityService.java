package com.travelbus.service;

import com.travelbus.data.entity.City;

import java.util.List;

public interface CityService extends BaseService<City>{

    @Override
    List<City> getAll();

}
