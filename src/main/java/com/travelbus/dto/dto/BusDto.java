package com.travelbus.dto.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusDto {
    private Long id;
    private String governmentalNumber;
    private String model;
    private Integer capacitySeats;
    private Integer freeSeats;
}
