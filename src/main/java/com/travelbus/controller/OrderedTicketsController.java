package com.travelbus.controller;

import com.travelbus.dto.dto.OrderedTicketsDto;
import com.travelbus.service.OrderedTicketsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderedTicketsController {
    private final OrderedTicketsService orderedTicketsService;

    public OrderedTicketsController(OrderedTicketsService orderedTicketsService) {
        this.orderedTicketsService = orderedTicketsService;
    }
    @GetMapping("/order/{id}")
    public OrderedTicketsDto getOrder(@PathVariable(name = "id") Long id){
        return orderedTicketsService.get(id);
    }
}
