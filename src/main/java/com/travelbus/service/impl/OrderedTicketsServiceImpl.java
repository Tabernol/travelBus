package com.travelbus.service.impl;

import com.travelbus.data.entity.OrderedTickets;
import com.travelbus.dto.dto.OrderedTicketsDto;
import com.travelbus.repo.OrderedTicketsRepo;
import com.travelbus.service.DtoService;
import com.travelbus.service.OrderedTicketsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderedTicketsServiceImpl implements OrderedTicketsService, DtoService<OrderedTicketsDto, OrderedTickets> {

    private final OrderedTicketsRepo orderedTicketsRepo;

    public OrderedTicketsServiceImpl(OrderedTicketsRepo orderedTicketsRepo) {
        this.orderedTicketsRepo = orderedTicketsRepo;
    }

    @Override
    public Iterable<OrderedTicketsDto> getAll() {
        return null;
    }

    @Override
    public OrderedTicketsDto get(Long id) {
        return toDto(orderedTicketsRepo.findById(id).orElse(new OrderedTickets()));
    }

    @Override
    public OrderedTicketsDto save(OrderedTicketsDto orderedTicketsDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public OrderedTicketsDto toDto(OrderedTickets orderedTickets) {
        OrderedTicketsDto orderedTicketsDto = new OrderedTicketsDto();
        orderedTicketsDto.setId(orderedTickets.getId());
        orderedTicketsDto.setCapacitySeats(orderedTickets.getCapacitySeats());
        orderedTicketsDto.setFreeTickets(orderedTickets.getFreeTickets());
        orderedTicketsDto.setOrderTickets(orderedTickets.getOrderTickets());
        orderedTicketsDto.setBoughtTickets(orderedTickets.getBoughtTickets());
        orderedTicketsDto.setTicketList(orderedTickets.getTicketList());
        return orderedTicketsDto;
    }

    @Override
    public List<OrderedTicketsDto> toDto(Iterable<OrderedTickets> orderedTickets) {
        return null;
    }

    @Override
    public OrderedTickets toEntity(OrderedTicketsDto orderedTicketsDto) {
        return null;
    }
}
