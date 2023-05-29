package com.travelbus.repo;

import com.travelbus.entity.HolderTickets;
import org.springframework.data.repository.CrudRepository;

public interface HolderTicketsRepo extends CrudRepository<HolderTickets,Long> {

    int deleteAllByRace(Long raceId);
}
