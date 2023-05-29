package com.travelbus.dto.get;

import com.travelbus.entity.Bus;
import com.travelbus.entity.HolderTickets;
import com.travelbus.entity.Route;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RaceGetDto {
    private Long id;
    private String name;
    private LocalDateTime timeStart;
    private LocalDateTime timeFinish;
    private Route route;
    private Bus bus;
    private HolderTickets holderTickets;
}
