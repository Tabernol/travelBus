package com.example.travelbus.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "bus")
public class Bus {
    @Id
    private Long id;

    @Column(name = "governmental_number")
    private String governmentalNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "capacity_seats")
    private Integer capacitySeats;

    @Column(name = "free_seats")
    private Integer freeSeats;



    @OneToMany(mappedBy = "bus")
    @JsonIgnore
    private List<Race> schedule;
}
