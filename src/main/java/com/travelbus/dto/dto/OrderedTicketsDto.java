package com.travelbus.dto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelbus.data.entity.Race;
import com.travelbus.data.entity.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
public class OrderedTicketsDto {
    private Long id;
    private Integer capacitySeats;
    private Integer freeTickets;
    private Integer orderTickets;
    private Integer boughtTickets;

//    @OneToOne(mappedBy = "orderedTickets")
//    @JsonIgnore
//    private Race race;

    private List<Ticket> ticketList;
}
