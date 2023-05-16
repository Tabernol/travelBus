package com.travelbus.service;

import com.travelbus.data.entity.Race;
import com.travelbus.dto.dto.RaceDto;

import java.util.List;

public interface RaceService extends BaseService<RaceDto, Race> {
    @Override
    List<RaceDto> getAll();
}
