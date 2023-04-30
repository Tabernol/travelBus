package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.dto.DtoService;
import com.example.travelbus.dto.dto.CityDto;
import com.example.travelbus.repo.CityRepo;
import com.example.travelbus.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImp implements CityService, DtoService<CityDto, City> {

    private CityRepo cityRepo;

    public CityServiceImp(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public Iterable<CityDto> getAll() {
        return toDto(cityRepo.findAll());
    }

    @Override
    public CityDto getCity(Long id) {
        return toDto(cityRepo.findById(id).orElse(new City()));
    }

    public CityDto saveCity(CityDto cityDto) {
        return toDto(cityRepo.save(toEntity(cityDto)));
    }

    @Override
    public void deleteCity(Long id) {
        cityRepo.deleteById(id);
    }

    @Override
    public CityDto toDto(City city) {
        CityDto cityDto = new CityDto();
        if (city != null) {
            cityDto.setId(city.getId());
            cityDto.setName(city.getName());
            return cityDto;
        }
        return cityDto;
    }

    @Override
    public List<CityDto> toDto(Iterable<City> cities) {
        List<CityDto> cityDtoList = new ArrayList<>();
        CityDto cityDto;
        for (City city : cities) {
            cityDto = new CityDto();
            cityDto.setId(city.getId());
            cityDto.setName(city.getName());
            cityDtoList.add(cityDto);
        }
        return cityDtoList;
    }

    @Override
    public City toEntity(CityDto cityDto) {
        City city = new City();
        if (cityDto != null) {
            city.setId(cityDto.getId());
            city.setName(cityDto.getName());
            return city;
        }
        return city;
    }
}