package com.travelbus.dto.dto;

import com.travelbus.data.entity.City;
import lombok.Data;

@Data
public class RouteDto {
    private Long id;
    private String routeName;
    private City startPoint;
    private City finishPoint;
}
