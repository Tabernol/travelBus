package com.travelbus.repo;

import com.travelbus.entity.Status;
import com.travelbus.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
    List<Ticket> deleteByStatusAndTimeOperation(Status status, LocalDateTime time);

}
