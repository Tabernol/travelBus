package com.travelbus.repo;

import com.travelbus.data.entity.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepo extends CrudRepository<Bus, Long> {
}
