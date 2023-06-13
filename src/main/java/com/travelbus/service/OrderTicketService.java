package com.travelbus.service;

import com.travelbus.entity.OrderTicket;
import com.travelbus.entity.Race;

import java.util.List;

public interface OrderTicketService extends BaseService<OrderTicket>{
    @Override
    List<OrderTicket> getAll();
}
