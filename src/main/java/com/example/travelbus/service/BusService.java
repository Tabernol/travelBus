package com.example.travelbus.service;

import com.example.travelbus.data.entity.Bus;
import com.example.travelbus.dto.dto.BusDto;
import com.example.travelbus.dto.dto.CityDto;

import java.util.List;

public interface BusService extends BaseService<BusDto, Bus> {
    @Override
    List<BusDto> getAll();
}
