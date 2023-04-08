package com.example.travelbus.dto.service;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityDtoServiceImpl implements CityDtoService {

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
