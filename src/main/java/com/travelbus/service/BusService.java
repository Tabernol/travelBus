package com.travelbus.service;

import com.travelbus.entity.Bus;

import java.util.List;

public interface BusService extends BaseService<Bus> {
    @Override
    List<Bus> getAll();
}
