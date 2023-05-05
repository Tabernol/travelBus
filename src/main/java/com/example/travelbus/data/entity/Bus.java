package com.example.travelbus.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
