package com.example.travelbus.repo;

import com.example.travelbus.data.entity.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepo extends CrudRepository<Bus, Long> {
}
