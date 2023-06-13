package com.travelbus.repo;

import com.travelbus.entity.OrderTicket;
import org.springframework.data.repository.CrudRepository;

public interface OrderTicketRepo extends CrudRepository<OrderTicket, Long> {
}
