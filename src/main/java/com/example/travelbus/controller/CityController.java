package com.example.travelbus.controller;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.dto.dto.CityDto;
import com.example.travelbus.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<CityDto> getAll(Model model) {
        List<CityDto> all = new ArrayList<>();
        cityService.getAll().forEach(cityDto ->all.add(cityDto));
        return all;
    }

    @GetMapping("/cities/{id}")
    public CityDto getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    @PostMapping("/cities")
    public CityDto addCity(@RequestBody CityDto cityDto) {
        return cityService.saveCity(cityDto);
    }

    @PatchMapping("/cities/{id}")
    public CityDto updateCity(@PathVariable Long id, @RequestBody CityDto cityDto) {
        return cityService.saveCity(cityDto);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
