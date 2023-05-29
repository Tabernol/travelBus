package com.travelbus.dto.post;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TicketPostDto {
    private String name;
    private String login;
    private int countOfTickets;

    private LocalDateTime timeOperation;
    private BigDecimal price;
    private Long raceId;
}
