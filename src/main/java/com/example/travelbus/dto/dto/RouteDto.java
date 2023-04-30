package com.example.travelbus.dto.dto;

import com.example.travelbus.data.entity.City;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class RouteDto {
    private Long id;
    private String routeName;
    private City startPoint;
    private City finishPoint;
}
