package com.travelbus.dto.post;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RacePostDto {
    private String raceName;
    private Long routeId;
    private LocalDateTime timeStart;
    private LocalDateTime timeFinish;
}
