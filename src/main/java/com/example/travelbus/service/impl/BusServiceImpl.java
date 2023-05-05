package com.example.travelbus.service.impl;

import com.example.travelbus.data.entity.Bus;
import com.example.travelbus.dto.dto.BusDto;
import com.example.travelbus.repo.BusRepo;
import com.example.travelbus.service.BusService;
import com.example.travelbus.service.DtoService;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class BusServiceImpl implements BusService, DtoService<BusDto, Bus> {

    private BusRepo busRepo;

    public BusServiceImpl(BusRepo busRepo) {
        this.busRepo = busRepo;
    }

    @Override
    public List<BusDto> getAll() {
        return toDto(busRepo.findAll());
    }

    @Override
    public BusDto get(Long id) {
        return toDto(busRepo.findById(id).orElse(new Bus()));
    }

    @Override
    public BusDto save(BusDto dto) {
        return toDto(busRepo.save(toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        busRepo.deleteById(id);
    }

    @Override
    public BusDto toDto(Bus bus) {
        return BusDto.builder()
                .id(bus.getId())
                .model(bus.getModel())
                .governmentalNumber(bus.getGovernmentalNumber())
                .capacitySeats(bus.getCapacitySeats())
                .freeSeats(bus.getFreeSeats()).build();
    }

    @Override
    public List<BusDto> toDto(Iterable<Bus> buses) {
        List<BusDto> busDtoList = new ArrayList<>();
        for (Bus bus : buses) {
            busDtoList.add(toDto(bus));
        }
        return busDtoList;
    }

    @Override
    public Bus toEntity(BusDto busDto) {
        Bus bus = new Bus();
        bus.setId(busDto.getId());
        bus.setModel(busDto.getModel());
        bus.setGovernmentalNumber(busDto.getGovernmentalNumber());
        bus.setCapacitySeats(busDto.getCapacitySeats());
        bus.setFreeSeats(busDto.getFreeSeats());
        return bus;
    }
}
