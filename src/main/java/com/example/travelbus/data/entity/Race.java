package com.example.travelbus.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "race")
public class Race {
    @Id
    private Long id;

    private String name;

    private LocalDateTime timeStart;

    private LocalDateTime timeFinish;

    //FetchType.EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "races")
    private Route route;

    //FetchType.EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule")
    private Bus bus;



}
