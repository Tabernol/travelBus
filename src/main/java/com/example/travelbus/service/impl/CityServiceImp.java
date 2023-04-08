package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.repo.CityRepo;
import com.example.travelbus.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImp implements CityService {

    private CityRepo cityRepo;

    public CityServiceImp(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public Iterable<City> getAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<City> getCity(Long id) {
        return cityRepo.findById(id);
    }

    public City saveCity(City city){
        return cityRepo.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepo.deleteById(id);
    }

    @Override
    public City updateCity(City city) {
        return cityRepo.save(city);
    }
}
