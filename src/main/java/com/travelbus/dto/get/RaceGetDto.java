package com.travelbus.dto.get;

import com.travelbus.data.entity.Bus;
import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.data.entity.Route;
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
    private OrderedTickets orderedTickets;
}
