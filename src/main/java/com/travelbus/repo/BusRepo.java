package com.travelbus.repo;

import com.travelbus.entity.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepo extends CrudRepository<Bus, Long> {

    Bus getBusByGovernmentalNumber(String governmentalNumber);
}
