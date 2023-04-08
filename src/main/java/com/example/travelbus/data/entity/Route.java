package com.example.travelbus.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "route_name")
    private String routeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_point")
    private City startPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finish_point")
    private City finishPoint;

//    @Builder.Default
//    @OneToMany(mappedBy = "route")
//    @ToString.Exclude
//    private List<RouteCity> routCities = new ArrayList<>();
}
