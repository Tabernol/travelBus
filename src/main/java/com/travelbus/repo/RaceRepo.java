package com.travelbus.repo;

import com.travelbus.data.entity.Race;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepo extends CrudRepository<Race, Long> {
}
