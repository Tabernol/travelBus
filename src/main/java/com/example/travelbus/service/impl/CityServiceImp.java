package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.repo.CityRepo;
import com.example.travelbus.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    private CityRepo cityRepo;

    public CityServiceImp(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public List<City> getAll() {
        return cityRepo.findAll();
    }

    public void addCity(City city){
        cityRepo.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepo.deleteById(id);
    }
}
