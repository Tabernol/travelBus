package com.travelbus.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ordered_tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderedTickets {
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

    @OneToOne(mappedBy = "orderedTickets")
    @JsonIgnore
    private Race race;

    @OneToMany(mappedBy = "orderedTickets")
//    @JsonIgnore
    private List<Ticket> ticketList;
}
