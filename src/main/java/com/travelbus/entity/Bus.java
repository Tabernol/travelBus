package com.travelbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @OneToMany(mappedBy = "bus")
    @JsonIgnore
    private List<Race> schedule;
}
