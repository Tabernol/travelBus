package com.travelbus.dto.post;

import com.travelbus.data.entity.City;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class RouteDto {
    private String routeName;
    private Long startPointId;
    private Long finishPointId;
}
