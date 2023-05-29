package com.travelbus.service.impl;

import com.travelbus.entity.Bus;
import com.travelbus.repo.BusRepo;
import com.travelbus.service.BusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private BusRepo busRepo;

    public BusServiceImpl(BusRepo busRepo) {
        this.busRepo = busRepo;
    }


    @Override
    public Bus get(Long id) {
        return busRepo.findById(id).orElseThrow();
    }

    @Override
    public Bus save(Bus bus) {
        return busRepo.save(bus);
    }

    @Override
    public void delete(Long id) {
        busRepo.deleteById(id);
    }

    @Override
    public List<Bus> getAll() {
        List<Bus> buses = new ArrayList<>();
        busRepo.findAll().forEach(bus -> buses.add(bus));
        return buses;
    }
}
