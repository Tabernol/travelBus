package com.example.travelbus.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"routeCities", "startRoutes", "finishRoutes"})
@Builder
@Entity
@Table(name = "city")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @Builder.Default
//    @OneToMany(mappedBy = "city")
//    @ToString.Exclude
//    private List<RouteCity> routCities = new ArrayList<>();

    @OneToMany(mappedBy = "startPoint", orphanRemoval = true)
    @JsonIgnore
    private List<Route> startRoutes = new ArrayList<>();

    @OneToMany(mappedBy = "finishPoint", orphanRemoval = true)
    @JsonIgnore
    private List<Route> finishRoutes = new ArrayList<>();
}
