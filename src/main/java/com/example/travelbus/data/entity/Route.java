package com.example.travelbus.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route")
public class Route implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "route_name")
    private String routeName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "start_point")
    private City startPoint;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "finish_point")
    private City finishPoint;

//    @Builder.Default
//    @OneToMany(mappedBy = "route")
//    @ToString.Exclude
//    private List<RouteCity> routCities = new ArrayList<>();

    @OneToMany(mappedBy ="route" )
    private List<Race> races;
}
