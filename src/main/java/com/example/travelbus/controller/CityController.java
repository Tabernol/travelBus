package com.example.travelbus.controller;

import com.example.travelbus.data.entity.City;
import com.example.travelbus.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String getAll(Model model) {
        model.addAttribute("newCity",new City());
        model.addAttribute("cities", cityService.getAll());
        return "cities";
    }
    @GetMapping("/cities/toAdd")
    public String toAddCity(Model model){
        model.addAttribute("newCity",new City());
        return "addCity";
    }
    @PostMapping("/cities/toAdd")
    public String addCity(@ModelAttribute("newCity") City city){
        System.out.println(city.getName());
        cityService.addCity(city);
        return "redirect:/cities";
    }
    @GetMapping("/cities/del/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        System.out.println("delete city");
        cityService.deleteCity(id);
        return "redirect:/cities";
    }
}
