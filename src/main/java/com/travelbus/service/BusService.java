package com.travelbus.service;

import com.travelbus.data.entity.Bus;
import com.travelbus.dto.dto.BusDto;

import java.util.List;

public interface BusService extends BaseService<Bus> {
    @Override
    List<Bus> getAll();
}
