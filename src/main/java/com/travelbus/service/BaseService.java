package com.travelbus.service;

public interface BaseService <Dto, Entity> {
    Iterable<Dto> getAll();

    Dto get(Long id);

    Dto save(Dto dto);

    void delete(Long id);
}
