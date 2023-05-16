package com.travelbus.controller;

import com.travelbus.dto.dto.CityDto;
import com.travelbus.service.CityService;
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
        return cityService.get(id);
    }

    @PostMapping("/cities")
    public CityDto addCity(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @PatchMapping("/cities/{id}")
    public CityDto updateCity(@PathVariable Long id, @RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.delete(id);
    }
}
