package com.example.travelbus.service;

import com.example.travelbus.data.entity.Race;
import com.example.travelbus.dto.dto.RaceDto;

import java.util.List;

public interface RaceService extends BaseService<RaceDto, Race> {
    @Override
    List<RaceDto> getAll();
}
