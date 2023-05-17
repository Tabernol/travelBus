package com.travelbus.service;

import com.travelbus.data.entity.Bus;
import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.data.entity.Race;
import com.travelbus.dto.dto.OrderedTicketsDto;

public interface OrderedTicketsService extends BaseService<OrderedTickets> {
    OrderedTickets createOrderedTickets(Bus bus);
    boolean canDeleteOrderedTickets(Long id);
}
