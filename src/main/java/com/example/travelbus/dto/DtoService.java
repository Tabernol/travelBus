package com.example.travelbus.dto;

import java.util.List;

public interface DtoService <Dto, Entity>{

    Dto toDto(Entity entity);

    List<Dto> toDto(Iterable<Entity> entities);

    Entity toEntity(Dto dto);
}