package com.travelbus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "order_ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    private Race race;
    //many to one
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Enumerated(EnumType.STRING)
    private StatusOrderTicket statusOrderTicket;
    private LocalDateTime timeOrder;
    private LocalDateTime timeFinish;
}
