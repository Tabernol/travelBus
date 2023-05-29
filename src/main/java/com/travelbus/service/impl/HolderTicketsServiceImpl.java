package com.travelbus.service.impl;

import com.travelbus.entity.Bus;
import com.travelbus.entity.HolderTickets;
import com.travelbus.repo.HolderTicketsRepo;
import com.travelbus.service.HolderTicketsService;
import org.springframework.stereotype.Service;

@Service
public class HolderTicketsServiceImpl implements HolderTicketsService {

    private final HolderTicketsRepo holderTicketsRepo;

    public HolderTicketsServiceImpl(HolderTicketsRepo holderTicketsRepo) {
        this.holderTicketsRepo = holderTicketsRepo;
    }

    @Override
    public Iterable<HolderTickets> getAll() {
        return holderTicketsRepo.findAll();
    }

    @Override
    public HolderTickets get(Long id) {
        return holderTicketsRepo.findById(id).orElseThrow();
    }

    @Override
    public HolderTickets save(HolderTickets holderTickets) {
        return holderTicketsRepo.save(holderTickets);
    }

    @Override
    public void delete(Long id) {
        holderTicketsRepo.deleteById(id);
    }

    @Override
    public HolderTickets createOrderedTickets(Bus bus) {
        HolderTickets holderTickets = new HolderTickets();
        holderTickets.setCapacitySeats(bus.getCapacitySeats());
        holderTickets.setFreeTickets(bus.getCapacitySeats());
        holderTickets.setOrderTickets(0);
        holderTickets.setBoughtTickets(0);
        return save(holderTickets);
    }

    @Override
    public boolean canDeleteOrderedTickets(Long id) {
        HolderTickets holderTickets = get(id);
        return holderTickets.getOrderTickets() + holderTickets.getBoughtTickets() == 0;
    }
}
