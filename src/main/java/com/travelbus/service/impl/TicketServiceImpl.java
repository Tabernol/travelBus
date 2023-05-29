package com.travelbus.service.impl;

import com.travelbus.entity.Ticket;
import com.travelbus.repo.TicketRepo;
import com.travelbus.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepo ticketRepo;

    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Iterable<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket get(Long id) throws IllegalArgumentException {
        return ticketRepo.findById(id).orElseThrow();
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketRepo.deleteById(id);
    }
}
