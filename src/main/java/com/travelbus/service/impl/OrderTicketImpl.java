package com.travelbus.service.impl;

import com.travelbus.entity.OrderTicket;
import com.travelbus.repo.OrderTicketRepo;
import com.travelbus.service.OrderTicketService;

import java.util.ArrayList;
import java.util.List;

public class OrderTicketImpl implements OrderTicketService {

    private final OrderTicketRepo orderTicketRepo;

    public OrderTicketImpl(OrderTicketRepo orderTicketRepo) {
        this.orderTicketRepo = orderTicketRepo;
    }

    @Override
    public List<OrderTicket> getAll() {
        List<OrderTicket> orderTicketList = new ArrayList<>();
        orderTicketRepo.findAll().forEach(orderTicket -> orderTicketList.add(orderTicket));
        return orderTicketList;
    }

    @Override
    public OrderTicket get(Long id) throws IllegalArgumentException {
        return orderTicketRepo.findById(id).orElseThrow();
    }

    @Override
    public OrderTicket save(OrderTicket orderTicket) {
        return orderTicketRepo.save(orderTicket);
    }

    @Override
    public void delete(Long id) {
        orderTicketRepo.deleteById(id);
    }
}
