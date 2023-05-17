package com.travelbus.dto.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class DtoForCreateRace {
    private String raceName;
    private String routeName;
    private LocalDateTime timeStart;
    private LocalDateTime timeFinish;
}
