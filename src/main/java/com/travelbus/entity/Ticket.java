package com.travelbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number_of_seat")
    private Integer numberOfSeat;
    private BigDecimal price;
    @Column(name = "time_operation")
    private LocalDateTime timeOperation;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "holder_tickets_id")
    @JsonIgnore
    private HolderTickets holderTickets;
    @ManyToOne()
    @JoinColumn(name = "passanger")
    @JsonIgnore
    private User user;

}

