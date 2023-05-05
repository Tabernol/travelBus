package com.example.travelbus.dto.dto;

import com.example.travelbus.data.entity.Bus;
import com.example.travelbus.data.entity.Route;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RaceDto {

    private Long id;
    private String name;
    private LocalDateTime timeStart;
    private LocalDateTime timeFinish;
    private Route route;
    private Bus bus;
}
