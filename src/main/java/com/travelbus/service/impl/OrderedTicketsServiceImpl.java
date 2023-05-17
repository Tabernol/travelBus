package com.travelbus.service.impl;

import com.travelbus.data.entity.Bus;
import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.data.entity.Race;
import com.travelbus.dto.dto.OrderedTicketsDto;
import com.travelbus.repo.OrderedTicketsRepo;
import com.travelbus.service.OrderedTicketsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return orderedTicketsRepo.findById(id).orElseThrow();
    }

    @Override
    public OrderedTickets save(OrderedTickets orderedTickets) {
        return orderedTicketsRepo.save(orderedTickets);
    }

    @Override
    public void delete(Long id) {
        orderedTicketsRepo.deleteById(id);
    }

    @Override
    public OrderedTickets createOrderedTickets(Bus bus) {
        OrderedTickets orderedTickets = new OrderedTickets();
        orderedTickets.setCapacitySeats(bus.getCapacitySeats());
        orderedTickets.setFreeTickets(bus.getCapacitySeats());
        orderedTickets.setOrderTickets(0);
        orderedTickets.setBoughtTickets(0);
        return save(orderedTickets);
    }

    @Override
    public boolean canDeleteOrderedTickets(Long id) {
        OrderedTickets orderedTickets = get(id);
        return orderedTickets.getOrderTickets() + orderedTickets.getBoughtTickets() == 0;
    }
}
