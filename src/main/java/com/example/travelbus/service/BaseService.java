package com.example.travelbus.service;

import com.example.travelbus.dto.dto.CityDto;

public interface BaseService <Dto, Entity> {
    Iterable<Dto> getAll();

    Dto get(Long id);

    Dto save(Dto Dto);

    void delete(Long id);
}
