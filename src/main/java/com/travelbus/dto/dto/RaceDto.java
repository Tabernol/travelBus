package com.travelbus.dto.dto;

import com.travelbus.data.entity.Bus;
import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.data.entity.Route;
import com.travelbus.data.entity.Ticket;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RaceDto {
    private Long id;
    private String name;
    private LocalDateTime timeStart;
    private LocalDateTime timeFinish;
    private Route route;
    private Bus bus;
    private OrderedTickets orderedTickets;
}
