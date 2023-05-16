package com.travelbus.repo;

import com.travelbus.data.entity.OrderedTickets;
import org.springframework.data.repository.CrudRepository;

public interface OrderedTicketsRepo extends CrudRepository<OrderedTickets,Long> {
}
