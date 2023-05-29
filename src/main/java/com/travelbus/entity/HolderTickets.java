package com.travelbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "holder_tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HolderTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capacity_seats")
    private Integer capacitySeats;
    @Column(name = "free_tickets")
    private Integer freeTickets;
    @Column(name = "order_tickets")
    private Integer orderTickets;
    @Column(name = "bought_tickets")
    private Integer boughtTickets;
    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(mappedBy = "holderTickets")
    @JsonIgnore
    private Race race;

    @OneToMany(mappedBy = "holderTickets")
    @JsonIgnore
    private List<Ticket> ticketList;
}
