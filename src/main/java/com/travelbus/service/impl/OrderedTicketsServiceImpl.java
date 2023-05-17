package com.travelbus.service.impl;

import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.dto.dto.OrderedTicketsDto;
import com.travelbus.repo.OrderedTicketsRepo;
import com.travelbus.service.OrderedTicketsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderedTicketsServiceImpl implements OrderedTicketsService {

    private final OrderedTicketsRepo orderedTicketsRepo;

    public OrderedTicketsServiceImpl(OrderedTicketsRepo orderedTicketsRepo) {
        this.orderedTicketsRepo = orderedTicketsRepo;
    }

    @Override
    public Iterable<OrderedTickets> getAll() {
        return null;
    }

    @Override
    public OrderedTickets get(Long id) {
        return null;
    }

    @Override
    public OrderedTickets save(OrderedTickets orderedTickets) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
