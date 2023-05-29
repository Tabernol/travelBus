package com.travelbus.service;

import com.travelbus.entity.Bus;
import com.travelbus.entity.HolderTickets;

public interface HolderTicketsService extends BaseService<HolderTickets> {
    HolderTickets createOrderedTickets(Bus bus);
    boolean canDeleteOrderedTickets(Long id);
}
