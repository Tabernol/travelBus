package com.example.travelbus.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "route")
public class Route {
    @Id
    private Long id;
    @Column(name = "start_point")
    private String startPoint;
    @Column(name = "finish_point")
    private String finishPoint;

}
