package com.example.travelbus.controller;

import com.example.travelbus.data.entity.Route;
import com.example.travelbus.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String getAll(Model model) {
        model.addAttribute("routes", routeService.getAll());
        log.info("get routes ");
        return "routes";
    }

    @GetMapping("/routes/{id}")
    public String get(@PathVariable Long id, Model model) {
        log.info(String.valueOf(id));
        model.addAttribute("rou", routeService.getRoute(id).get());
        return "route";
    }


}
