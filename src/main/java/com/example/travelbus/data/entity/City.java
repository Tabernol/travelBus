package com.example.travelbus.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"routeCities", "startRoutes", "finishRoutes"})
@Builder
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @Builder.Default
//    @OneToMany(mappedBy = "city")
//    @ToString.Exclude
//    private List<RouteCity> routCities = new ArrayList<>();

    @OneToMany(mappedBy = "startPoint")
    @ToString.Exclude
    private List<Route> startRoutes = new ArrayList<>();

    @OneToMany(mappedBy = "finishPoint")
    @ToString.Exclude
    private List<Route> finishRoutes = new ArrayList<>();
}
