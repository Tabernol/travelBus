package com.example.travelbus.controller;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.dto.CityDto;
import com.example.travelbus.dto.service.CityDtoService;
import com.example.travelbus.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CityController {
    private final CityService cityService;
    private final CityDtoService cityDtoService;

    public CityController(CityService cityService, CityDtoService cityDtoService) {
        this.cityService = cityService;
        this.cityDtoService = cityDtoService;
    }

    @GetMapping("/cities")
    public List<CityDto> getAll(Model model) {
        return cityDtoService.toDto(cityService.getAll());
    }

    @GetMapping("/cities/{id}")
    public CityDto getCity(@PathVariable Long id) {
        return cityDtoService.toDto(cityService.getCity(id).orElse(new City()));
    }

    @PostMapping("/cities")
    public CityDto addCity(@RequestBody CityDto cityDto) {
        City city = cityDtoService.toEntity(cityDto);
        return cityDtoService.toDto(cityService.saveCity(city));
    }

    @PatchMapping("/cities/{id}")
    public CityDto updateCity(@PathVariable Long id, @RequestBody CityDto cityDto) {
        City city = cityDtoService.toEntity(cityDto);
        return cityDtoService.toDto(cityService.saveCity(city));
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
