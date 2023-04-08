package com.example.travelbus.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "route_city")
public class RouteCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "route_id")
//    private Route route;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "city_id")
//    private City city;

//    public void setRoute(Route route){
//        this.route = route;
//        this.route.getRoutCities().add(this);
//    }

//    public void setCity(City city){
//        this.city = city;
//        this.city.getRoutCities().add(this);
//    }
}
