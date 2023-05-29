package com.travelbus.controller;

import com.travelbus.dto.dto.HolderTicketsDto;
import com.travelbus.service.HolderTicketsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolderTicketsController {
    private final HolderTicketsService holderTicketsService;

    public HolderTicketsController(HolderTicketsService holderTicketsService) {
        this.holderTicketsService = holderTicketsService;
    }
}
