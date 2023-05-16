package com.travelbus.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordered_tickets_id")
    @JsonIgnore
    private OrderedTickets orderedTickets;
    @ManyToOne()
    @JoinColumn(name = "passanger")
    private User user;

}

enum Status {
    FREE,
    ORDERED,
    BOUGHT
}