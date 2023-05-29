package com.travelbus.controller;

import com.travelbus.entity.City;
import com.travelbus.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id) {
        return new ResponseEntity<>(cityService.get(id), HttpStatus.OK);
    }

    @PostMapping("/cities")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

//    @PatchMapping("/cities")
//    public ResponseEntity<CityGetDto> updateCity(@RequestBody CityPostDto cityPostDto) {
//        City save = cityService.save(cityMapper.cityPostDtoToCity(cityPostDto));
//        return new ResponseEntity<>(cityMapper.cityToCityGetDto(save), HttpStatus.OK);
//    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.delete(id);
    }
}
