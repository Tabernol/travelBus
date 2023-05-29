package com.travelbus.dto.post;

import lombok.Data;

@Data
public class RouteDto {
    private String routeName;
    private Long startPointId;
    private Long finishPointId;
}
