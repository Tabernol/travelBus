package com.travelbus.service;

public interface BaseService <Entity> {
    Iterable<Entity> getAll();

    Entity get(Long id) throws IllegalArgumentException;

    Entity save(Entity entity);

    void delete(Long id);
}
