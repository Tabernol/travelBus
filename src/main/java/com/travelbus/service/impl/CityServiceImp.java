package com.travelbus.service.impl;

import com.travelbus.data.entity.City;
import com.travelbus.repo.CityRepo;
import com.travelbus.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImp implements CityService {
    private final CityRepo cityRepo;

    public CityServiceImp(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }


    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        cityRepo.findAll().forEach(city -> cities.add(city));
        return cities;
    }

    @Override
    public City get(Long id) {
        return cityRepo.findById(id).orElseThrow();
    }

    @Override
    public City save(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepo.deleteById(id);
    }

}
