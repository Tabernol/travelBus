package com.travelbus.dto.dto;

import com.travelbus.entity.Ticket;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class HolderTicketsDto {
    private Long id;
    private Integer capacitySeats;
    private Integer freeTickets;
    private Integer orderTickets;
    private Integer boughtTickets;
    private BigDecimal price;

//    @OneToOne(mappedBy = "orderedTickets")
//    @JsonIgnore
//    private Race race;

    private List<Ticket> ticketList;
}
